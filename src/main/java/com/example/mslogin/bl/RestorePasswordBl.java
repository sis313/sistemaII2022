package com.example.mslogin.bl;

import com.example.mslogin.dao.UserRepository;
import com.example.mslogin.dao.VerificationTokenRepository;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class RestorePasswordBl {
    private final VerificationTokenRepository verificationTokenRepository;
    private final UserRepository userRepository;

    private final EmailSenderService emailSenderService;
    Logger LOGGER = LoggerFactory.getLogger(RestorePasswordBl.class);

    public RestorePasswordBl(VerificationTokenRepository verificationTokenRepository, UserRepository userRepository, EmailSenderService emailSenderService) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.userRepository = userRepository;
        this.emailSenderService = emailSenderService;
    }

    public int sendMailToRestorePass(String email) {
        UserEntity currentUser = this.userRepository.findUserByEmail(email);

        if(currentUser!=null){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(currentUser.getEmail());
            mailMessage.setSubject("Password reset request");
            mailMessage.setText("Hi : "+currentUser.getNickname()
                    +"Someone has requested a new password for the following account. Please click the link below. " +
                    "http://localhost:80/reset-password?user="+currentUser.getNickname());

            emailSenderService.sendEmail(mailMessage);
            LOGGER.info("sendMailToRestorePass from RestorePasswordBl");
            return currentUser.getIdUser();
        }

        return -1;
    }
}
