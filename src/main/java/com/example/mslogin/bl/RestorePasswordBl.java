package com.example.mslogin.bl;

import com.example.mslogin.dao.UserRepository;
import com.example.mslogin.dao.VerificationTokenRepository;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RestorePasswordBl {
    private final VerificationTokenRepository verificationTokenRepository;
    private final UserRepository userRepository;

    private final EmailSenderService emailSenderService;
    private PasswordEncoder passwordEncoder;

    Logger LOGGER = LoggerFactory.getLogger(RestorePasswordBl.class);

    public RestorePasswordBl(PasswordEncoder passwordEncoder,VerificationTokenRepository verificationTokenRepository, UserRepository userRepository, EmailSenderService emailSenderService) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.userRepository = userRepository;
        this.emailSenderService = emailSenderService;
        this.passwordEncoder = passwordEncoder;
    }

    public int sendMailToRestorePass(String email) {
        UserEntity currentUser = this.userRepository.findUserByEmail(email);

        if(currentUser!=null){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(currentUser.getEmail());
            mailMessage.setSubject("Password reset request");
            mailMessage.setText("Hi: "+currentUser.getNickname()+"\n"
                    +"Someone has requested a new password for the following account. Please click the link below. " +
                    "\nhttp://localhost:80/reset-password?user="+currentUser.getNickname());

            emailSenderService.sendEmail(mailMessage);
            LOGGER.info("sendMailToRestorePass from RestorePasswordBl");
            return currentUser.getIdUser();
        }

        return -1;
    }

    public int confirmUser(String user) {
        UserEntity currentUser = this.userRepository.findUserByUser(user);

        if(currentUser!=null){
            return currentUser.getIdUser();
        }

        return -1;
    }

    public int saveNewPassword(UserEntity userEntity) {
        UserEntity currentUser = this.userRepository.findUserByUser(userEntity.getNickname());

        if(currentUser!=null){
            currentUser.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));
            userRepository.save(currentUser);
            return currentUser.getIdUser();
        }

        return -1;
    }
}
