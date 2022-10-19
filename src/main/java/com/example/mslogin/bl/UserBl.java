package com.example.mslogin.bl;


import com.example.mslogin.dao.RoleRepository;
import com.example.mslogin.dao.UserRepository;
import com.example.mslogin.dto.RoleEntity;
import com.example.mslogin.dto.UserEntity;
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

    public static final Logger LOGGER = LoggerFactory.getLogger(UserBl.class);
    private PasswordEncoder passwordEncoder;

    public UserBl(UserRepository userRepository, VerificationMailBl verificationMailBl, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.verificationMailBl = verificationMailBl;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        LOGGER.info("saveUser from UserBl. {}", user.toString());
        //Validate if user already exists
        if(userRepository.existsByEmail(user.getEmail()))
            return null;
        //Validate if user already exists
        if(userRepository.existsByNickname(user.getNickname()))
            return  null;
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleRepository.findById(user.getIdTypeUser()).orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
        user.setRoles(roles);
        user.setCreateDate(new Date(System.currentTimeMillis()));
        user.setUpdateDate(new Date(System.currentTimeMillis()));
        user.setStatus("Pending");
        UserEntity newUser = userRepository.save(user);
        verificationMailBl.createToken(newUser);
        LOGGER.info("User saved");
        return newUser;
    }

    public Optional<UserEntity> findUserByID(int id){
        return userRepository.findById(id);
    }

    public Optional<UserEntity> findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity user = userRepository.findUserByID(userEntity.getIdUser());
        user.setIdTypeUser(userEntity.getIdTypeUser());
        user.setUpdateDate(new Date(System.currentTimeMillis()));

        return userRepository.save(user);
    }
}
