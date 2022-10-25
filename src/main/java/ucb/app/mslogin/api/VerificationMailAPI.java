package ucb.app.mslogin.api;

import ucb.app.mslogin.bl.UserBl;
import ucb.app.mslogin.bl.VerificationMailBl;
import ucb.app.mslogin.dto.UserEntity;
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

    @RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<Void> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        LOGGER.info("confirmUserAccount from VerificationMailAPI");
        int res = verificationMailBl.confirmUserAccount(confirmationToken);
        if (res < 0) {
            ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .location(URI.create("localhost:4200/error-verificacion")).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("http://localhost:4200/verificacion-exitosa")).build();
    }

    @RequestMapping(value = "/resend", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> resendMail(@RequestBody UserEntity userEntity) {
        LOGGER.info("confirmUserAccount from VerificationMailAPI");
        int res = verificationMailBl.resendMail(userEntity.getEmail());

        if (res > 0) {
            return new ResponseEntity<>("The message to confirm your email has been resent.", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error. The email entered doesn't have an associated account.",
                HttpStatus.PRECONDITION_FAILED);
    }
}
