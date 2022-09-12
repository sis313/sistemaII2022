package com.example.mslogin.bl;

import com.example.mslogin.dao.UserRepository;
import com.example.mslogin.dao.VerificationTokenRepository;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    private UserRepository userRepository;
    private VerificationMailBl verificationMailBl;

    Logger LOGGER = LoggerFactory.getLogger(UserBl.class);

    public UserBl(UserRepository userRepository, VerificationMailBl verificationMailBl) {
        this.userRepository = userRepository;
        this.verificationMailBl = verificationMailBl;
    }

    public String createUser(UserEntity userEntity) {

        userEntity.setStatus("Pending");

        //Buscar coincidencias de correo electronico
        UserEntity foundUser = userRepository.findUserByEmail(userEntity.getEmail());
        if(foundUser!=null){
            LOGGER.info("createUser from UserBl-no es null");
            return "Error, the email entered already has an associated account.";
        }else{
            LOGGER.info("createUser from UserBl-null");
            //Guardando usuario
            UserEntity newUser = this.userRepository.save(userEntity);

            //Enviando a verificacion
            verificationMailBl.createToken(newUser);
            /////

            return "New user added successfully.";
        }
    }


}
