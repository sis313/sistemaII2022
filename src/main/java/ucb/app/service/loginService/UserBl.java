package ucb.app.service.loginService;

import ucb.app.repository.BusinessRepository;
import ucb.app.repository.loginRepository.UserRepository;
import ucb.app.service.CUSTOMService;
import ucb.app.model.loginModel.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Optional;

@Service
public class UserBl {
    private UserRepository userRepository;
    private VerificationMailBl verificationMailBl;
    private CUSTOMService customService;

    public static final Logger LOGGER = LoggerFactory.getLogger(UserBl.class);
    private PasswordEncoder passwordEncoder;

    public UserBl(UserRepository userRepository, VerificationMailBl verificationMailBl,
            PasswordEncoder passwordEncoder, CUSTOMService customService) {
        this.userRepository = userRepository;
        this.verificationMailBl = verificationMailBl;
        this.passwordEncoder = passwordEncoder;
        this.customService = customService;
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
        user.setCreateDate(new Date(System.currentTimeMillis()));
        user.setUpdateDate(new Date(System.currentTimeMillis()));
        user.setStatus("Pending");
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

        return userRepository.save(user);
    }

    // CODE CHANGE - START
    public UserEntity deleteByIdDto(Integer userId) {
        UserEntity userFound = userRepository.getReferenceById(userId);
        Boolean status = userFound.getStatus().equals("Pending");
        userFound.setStatus(status ? "Active" : "Pending");
        Integer countUpdate = customService.updateBusinessStatusDto(status ? 1 : 0, userId);
        Integer countUpdateaaa = customService.updateBranchStatusDto(status ? 1 : 0, userId);
        UserEntity response = userRepository.save(userFound);
        return response;
    }
    // CODE CHANGE - START
}
