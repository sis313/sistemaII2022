package ucb.app.mslogin.api;

import ucb.app.mslogin.dto.LoginDto;
import ucb.app.mslogin.jwt.JwtProvider;
import ucb.app.mslogin.jwt.JwtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginDto login) {
        LOGGER.info("lll");
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),
                        login.getPassword()));
        LOGGER.info("111");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        LOGGER.info("333");
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

}
