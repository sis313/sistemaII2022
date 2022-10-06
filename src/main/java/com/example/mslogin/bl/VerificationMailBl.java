package com.example.mslogin.bl;

import com.example.mslogin.dao.UserRepository;
import com.example.mslogin.dao.VerificationTokenRepository;
import com.example.mslogin.dto.UserEntity;
import com.example.mslogin.dto.VerificationTokenEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class VerificationMailBl {
    private final VerificationTokenRepository verificationTokenRepository;
    private final UserRepository userRepository;

    private final EmailSenderService emailSenderService;

    Logger LOGGER = LoggerFactory.getLogger(UserBl.class);


    public VerificationMailBl(EmailSenderService emailSenderService,VerificationTokenRepository verificationTokenRepository, UserRepository userRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.userRepository = userRepository;
        this.emailSenderService = emailSenderService;
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

    public int confirmUserAccount(String confirmationToken) {
        VerificationTokenEntity token = verificationTokenRepository.findToken(confirmationToken);
        Calendar cal = Calendar.getInstance();

        if(token != null && (token.getExpiryDate().getTime() - cal.getTime().getTime())>=0)
        {
            UserEntity user = userRepository.findUserByID(token.getIdUser());
            user.setStatus("Active");
            userRepository.save(user);
            LOGGER.info("confirmUserAccount from VerificationMailBl-if");
            return user.getIdUser();
        }
        else
        {
            LOGGER.info("confirmUserAccount from VerificationMailBl-else");
            return -1;
        }
    }

    public int resendMail(String email) {
        UserEntity currentUser = userRepository.findUserByEmail(email);
        VerificationTokenEntity currentToken = verificationTokenRepository.findTokenByIdUser(currentUser.getIdUser());
        Calendar cal = Calendar.getInstance();

        if(currentToken != null && currentUser!=null)
        {
            if((currentToken.getExpiryDate().getTime() - cal.getTime().getTime())<=0){
                currentToken = new VerificationTokenEntity(currentUser.getIdUser());
                verificationTokenRepository.save(currentToken);
            }

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(currentUser.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:80/confirm-account?token="+currentToken.getToken());

            emailSenderService.sendEmail(mailMessage);
            LOGGER.info("resendMail from VerificationMailBl-if");
        } else {
            if(currentUser!=null){
                createToken(currentUser);
                LOGGER.info("resendMail from VerificationMailBl-else");
            }else {
                return -1;
            }

        }

        return currentUser.getIdUser();
    }
}
