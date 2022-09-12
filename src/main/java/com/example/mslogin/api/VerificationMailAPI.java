package com.example.mslogin.api;

import com.example.mslogin.bl.UserBl;
import com.example.mslogin.bl.VerificationMailBl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VerificationMailAPI {
    private VerificationMailBl verificationMailBl;
    Logger LOGGER = LoggerFactory.getLogger(UserAPI.class);

    public VerificationMailAPI(VerificationMailBl verificationMailBl) {
        this.verificationMailBl = verificationMailBl;
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        LOGGER.info("confirmUserAccount from VerificationMailAPI");
        String res = verificationMailBl.confirmUserAccount(confirmationToken);
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }
}
