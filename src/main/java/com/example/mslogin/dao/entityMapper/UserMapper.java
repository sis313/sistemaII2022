package com.example.mslogin.dao.entityMapper;
import com.example.mslogin.api.AuthController;
import com.example.mslogin.dao.UserPrincipal;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
public class UserMapper {
    private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    public static UserPrincipal userToPrincipal(UserEntity user){
        UserPrincipal userPrincipal = new UserPrincipal();
        boolean status;
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+ role.getName()))
                .collect(Collectors.toList());
        userPrincipal.setUsername(user.getNickname());
        userPrincipal.setPassword(user.getPassword());
        userPrincipal.setAuthorities(authorities);
        status = (Objects.equals(user.getStatus(), "Active")|| Objects.equals(user.getStatus(), "Pending")) ;
        userPrincipal.setEnabled(status);
        LOGGER.info(userPrincipal.getUsername());
        LOGGER.info(userPrincipal.getPassword());
        LOGGER.info(userPrincipal.getAuthorities().toString());
        return userPrincipal;
    }
}
