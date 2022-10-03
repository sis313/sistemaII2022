package com.example.mslogin.api;

import com.example.mslogin.bl.UserBl;
import com.example.mslogin.bl.VerificationMailBl;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class VerificationMailAPI {
    private VerificationMailBl verificationMailBl;
    Logger LOGGER = LoggerFactory.getLogger(UserAPI.class);

    public VerificationMailAPI(VerificationMailBl verificationMailBl) {
        this.verificationMailBl = verificationMailBl;
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Void> confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        LOGGER.info("confirmUserAccount from VerificationMailAPI");
        int res = verificationMailBl.confirmUserAccount(confirmationToken);
        if(res<0){
            ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).location(URI.create("localhost:4200/error-verificacion")).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:4200/verificacion-exitosa")).build();
    }

    @RequestMapping(value="/resend", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> resendMail(@RequestBody UserEntity userEntity)
    {
        LOGGER.info("confirmUserAccount from VerificationMailAPI");
        String res = verificationMailBl.resendMail(userEntity.getEmail());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
