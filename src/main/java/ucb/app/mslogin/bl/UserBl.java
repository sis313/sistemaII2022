package ucb.app.mslogin.bl;

import ucb.app.mslogin.dao.RoleRepository;
import ucb.app.mslogin.dao.UserRepository;
import ucb.app.mslogin.dto.RoleEntity;
import ucb.app.mslogin.dto.UserEntity;
import ucb.app.service.CUSTOMService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserBl {
    private UserRepository userRepository;
    private VerificationMailBl verificationMailBl;
    private RoleRepository roleRepository;
    // CODE CHANGE - START
    private CUSTOMService customService;
    // CODE CHANGE - STOP

    public static final Logger LOGGER = LoggerFactory.getLogger(UserBl.class);
    private PasswordEncoder passwordEncoder;

    public UserBl(UserRepository userRepository, VerificationMailBl verificationMailBl, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder, CUSTOMService customService) {
        this.userRepository = userRepository;
        this.verificationMailBl = verificationMailBl;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        // CODE CHANGE - START
        this.customService = customService;
        // CODE CHANGE - STOP
    }

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        LOGGER.info("saveUser from UserBl. {}", user.toString());
        // Validate if user already exists
        if (userRepository.existsByEmail(user.getEmail()))
            return null;
        // Validate if user already exists
        if (userRepository.existsByNickname(user.getNickname()))
            return null;
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleRepository.findById(user.getIdTypeUser())
                .orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
        user.setRoles(roles);
        user.setCreateDate(new Date(System.currentTimeMillis()));
        user.setUpdateDate(new Date(System.currentTimeMillis()));
        user.setStatus(0);
        UserEntity newUser = userRepository.save(user);
        verificationMailBl.createToken(newUser);
        LOGGER.info("User saved");
        return newUser;
    }

    public Optional<UserEntity> findUserByID(int id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity user = userRepository.findUserByID(userEntity.getIdUser());
        user.setIdTypeUser(userEntity.getIdTypeUser());
        user.setUpdateDate(new Date(System.currentTimeMillis()));
        user.setRoles(userEntity.getRoles().stream().map((role) -> roleRepository.findByName(role.getName()))
                .collect(java.util.stream.Collectors.toList()));
        return userRepository.save(user);
    }

    // CODE CHANGE - START
    public UserEntity deleteByIdDto(Integer userId) {
        UserEntity userFound = userRepository.getReferenceById(userId);
        Boolean status = userFound.getStatus().equals(0);
        userFound.setStatus(status ? 1 : 0);
        Integer countUpdate = customService.updateBusinessStatusDto(status ? 1 : 0, userId);
        Integer countUpdateaaa = customService.updateBranchStatusDto(status ? 1 : 0, userId);
        UserEntity response = userRepository.save(userFound);
        return response;
    }

    public List<UserEntity> findUserByTypeAndStatus(Integer tipo, Integer status) {
        List<UserEntity> users = userRepository.findAllByTypeAndStatus(tipo, status);
        return users;
    }
    // CODE CHANGE - START
}
