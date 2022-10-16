package ucb.app.repository.loginRepository.entityMapper;

import ucb.app.controller.loginController.AuthController;
import ucb.app.repository.loginRepository.UserPrincipal;
import ucb.app.model.loginModel.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    public static UserPrincipal userToPrincipal(UserEntity user) {
        UserPrincipal userPrincipal = new UserPrincipal();
        boolean status;
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
        userPrincipal.setUsername(user.getNickname());
        userPrincipal.setPassword(user.getPassword());
        userPrincipal.setAuthorities(authorities);
        if (user.getStatus() == "Active") {
            status = true;
        } else {
            status = false;
        }
        userPrincipal.setEnabled(status);
        LOGGER.info(userPrincipal.getUsername());
        LOGGER.info(userPrincipal.getPassword());
        LOGGER.info(userPrincipal.getAuthorities().toString());
        return userPrincipal;
    }
}
