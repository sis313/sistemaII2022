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

    private String text_message = "<!DOCTYPE html> <html lang=\"en\">"+
    "<head>"+
    " <style>" +
            "body {background-color: #e1e1e1;font-family: Arial, Helvetica, sans-serif;}" +
            ".container {max-width: 680px;width: 100%;margin: auto;}" +
            "main {margin: 0 auto;display: flex;flex-direction: column;color: #555555;}" +
            ".body h2 {font-weight: 300;color: #464646;}" +
            "a {text-decoration: underline;color: #0c99d5;}" +
            ".body {padding: 20px;background-color: white;font-family: Geneva, Tahoma, Verdana, sans-serif;font-size: 16px;line-height: 22px;color: #555555;}" +
            "button { background-color: #0c99d5;border: none;color: white;border-radius: 2px;height: 50px;max-width: 250px;padding: 0px 30px;font-weight: 500;font-family: Geneva, Tahoma, Verdana, sans-serif;font-size: 16px;margin: 10px 0px 30px 0px;}" +
            " </style>" +
            "</head>" +
            "<body>" +
            "<main class=\"container\">" +
            "<div class=\"body\"> " +
            "<h2>Enjoy the silence</h2>" +
            "<p> Websites that autoplay video can be super annoying. You didn't select the video to play &mdash; it was started for you. <i>Hurumph!</i> Firefox will now stop that from happening, putting you in control. If you'd like to hear or see a video, just click on the play button to watch it.</p>" +
            " <p>Firefox with <a>Block Autoplay</a>: the way online video should be</p>" +
            "<button>FIND OUT MORE</button>" +
            "</div>" +
            "</main>" +
            "</body>" +
            "</html>";
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

    public UserEntity confirmUser(String user) {
        UserEntity currentUser = this.userRepository.findUserByUser(user);

        if(currentUser!=null){
            return currentUser;
        }

        return null;
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
