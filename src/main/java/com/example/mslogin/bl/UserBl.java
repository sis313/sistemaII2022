package com.example.mslogin.bl;


import com.example.mslogin.dao.UserRepository;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@Service
public class UserBl {
    private UserRepository userRepository;
    private VerificationMailBl verificationMailBl;

    public static final Logger LOGGER = LoggerFactory.getLogger(UserBl.class);
    private PasswordEncoder passwordEncoder;

    public UserBl(UserRepository userRepository, VerificationMailBl verificationMailBl, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.verificationMailBl = verificationMailBl;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public String saveUser(UserEntity user) {
        LOGGER.info("saveUser from UserBl");
        //Validate if user already exists
        if(userRepository.existsByEmail(user.getEmail()))
            return "Email already exists";
        //Validate if user already exists
        if(userRepository.existsByNickname(user.getNickname()))
            return  "Nickname already exists";
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setCreateDate(new Date(System.currentTimeMillis()));
        user.setUpdateDate(new Date(System.currentTimeMillis()));
        user.setStatus("Pending");
        UserEntity newUser = userRepository.save(user);
        verificationMailBl.createToken(newUser);
        LOGGER.info("User saved");
        return "User created";
    }
}
