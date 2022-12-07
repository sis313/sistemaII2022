package ucb.app.mslogin.api;

import ucb.app.mslogin.bl.RefreshTokenBl;
import ucb.app.mslogin.dto.LoginDto;
import ucb.app.mslogin.dto.RefreshTokenEntity;
import ucb.app.mslogin.dto.RefreshTokenRequest;
import ucb.app.mslogin.jwt.JwtProvider;
import ucb.app.mslogin.jwt.JwtResponse;
import ucb.app.mslogin.jwt.RefreshTokenException;
import ucb.app.mslogin.jwt.RefreshTokenResponse;
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

    @Autowired
    RefreshTokenBl refreshTokenBl;

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
        RefreshTokenEntity refreshToken = refreshTokenBl.createRefreshToken(login.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken()));
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenBl.findByToken(requestRefreshToken)
                .map(refreshTokenBl::verifyExpiration)
                .map(RefreshTokenEntity::getUserEntity)
                .map(userEntity -> {
                    String token = tokenProvider.generateTokenFromUsername(userEntity.getNickname());
                    return ResponseEntity.ok(new RefreshTokenResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new RefreshTokenException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser(@RequestParam String username) {
        refreshTokenBl.deleteByUsername(username);
        return ResponseEntity.ok("Log out successful!");
    }
}
