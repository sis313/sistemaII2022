package ucb.app.sercurityConf;


import ucb.app.api.AuthController;
import ucb.app.dao.UserRepository;
import ucb.app.dao.entityMapper.UserMapper;
import ucb.app.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MyUserDetailsServiceImpl implements UserDetailsService {
    private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
        LOGGER.info("222");
        return UserMapper.userToPrincipal(user);
    }
}
