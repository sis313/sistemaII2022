package com.example.mslogin.api;

import com.example.mslogin.bl.RestorePasswordBl;
import com.example.mslogin.bl.UserBl;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@CrossOrigin(origins = "*")
public class RestorePasswordAPI {
    private RestorePasswordBl restorePasswordBl;
    private UserEntity userEntity;
    Logger LOGGER = LoggerFactory.getLogger(RestorePasswordAPI.class);

    public RestorePasswordAPI(RestorePasswordBl restorePasswordBl) {
        this.restorePasswordBl = restorePasswordBl;
    }

    @PostMapping(path = "/recover", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> receiveEmail(@RequestBody UserEntity userEntity) {
        LOGGER.info("receiveEmail from RestorePasswordAPI");
        int res = restorePasswordBl.sendMailToRestorePass(userEntity.getEmail());

        if(res>0){
            return new ResponseEntity<>("A message to reset your password has been sent to your email.", HttpStatus.OK);
        }
        return new ResponseEntity<>("There is no user with the specified email.", HttpStatus.UNPROCESSABLE_ENTITY);
        //Send to recuperacion
    }

    @PostMapping(path = "/resetPassword", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> receiveNewPassword(@RequestBody UserEntity userEntity) {
        LOGGER.info("receiveNewPassword from RestorePasswordAPI");
        int res = restorePasswordBl.sendUpdatePassword(userEntity);

        if(res>0){
            return new ResponseEntity<>("A message to reset your password has been sent to your email.", HttpStatus.OK);
        }
        return new ResponseEntity<>("There is no user with the specified email.", HttpStatus.UNPROCESSABLE_ENTITY);
        //Send to recuperacion
    }

    @RequestMapping(value="/reset-password", method= RequestMethod.GET)
    public ResponseEntity<Void> resendToResetPass(@RequestParam("user")String user)
    {
        LOGGER.info("resendToResetPass from RestorePasswordAPI");
        int res = restorePasswordBl.confirmUser(user);
        if(res<0){
            ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).location(URI.create("localhost:4200/error-verificacion")).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:4200/recuperacion?user=")).build();
    }




}
