package com.example.mslogin.api;

import com.example.mslogin.bl.RestorePasswordBl;
import com.example.mslogin.bl.UserBl;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RestorePasswordAPI {
    private RestorePasswordBl restorePasswordBl;
    private UserEntity userEntity;
    Logger LOGGER = LoggerFactory.getLogger(RestorePasswordAPI.class);

    public RestorePasswordAPI(RestorePasswordBl restorePasswordBl) {
        this.restorePasswordBl = restorePasswordBl;
    }

    @PostMapping(path = "/resetPassword", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> receiveEmail(@RequestBody UserEntity userEntity) {
        LOGGER.info("receiveEmail from RestorePasswordAPI");
        int res = restorePasswordBl.sendMailToRestorePass(userEntity.getEmail());
        if(res>0){
            new ResponseEntity<>("A message to reset your password has been sent to your email.", HttpStatus.OK);
        }
        return new ResponseEntity<>("There is no user with the specified email.", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
