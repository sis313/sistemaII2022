package com.example.mslogin.bl;

import com.example.mslogin.dao.UserRepository;
import com.example.mslogin.dao.VerificationTokenRepository;
import com.example.mslogin.dto.UserEntity;
import com.example.mslogin.dto.VerificationTokenEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class VerificationMailBl {
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    private UserRepository userRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    Logger LOGGER = LoggerFactory.getLogger(UserBl.class);


    public VerificationMailBl(VerificationTokenRepository verificationTokenRepository, UserRepository userRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.userRepository = userRepository;
    }

    public void createToken(UserEntity userEntity){
        //Creando Token
        VerificationTokenEntity newToken = new VerificationTokenEntity(userEntity.getIdUser());
        verificationTokenRepository.save(newToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userEntity.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:80/confirm-account?token="+newToken.getToken());

        emailSenderService.sendEmail(mailMessage);
        LOGGER.info("createToken from VerificationMailBl");
    }

    public String confirmUserAccount(String confirmationToken) {
        VerificationTokenEntity token = verificationTokenRepository.findToken(confirmationToken);
        Calendar cal = Calendar.getInstance();

        if(token != null && (token.getExpiryDate().getTime() - cal.getTime().getTime())>=0)
        {
            UserEntity user = userRepository.findUserByID(token.getIdUser());
            user.setStatus("Active");
            userRepository.save(user);
            LOGGER.info("confirmUserAccount from VerificationMailBl-if");
            return "Account verified";
        }
        else
        {
            LOGGER.info("confirmUserAccount from VerificationMailBl-else");
            return "Error";
        }
    }
}
