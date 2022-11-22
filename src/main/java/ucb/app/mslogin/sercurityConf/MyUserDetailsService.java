package ucb.app.mslogin.sercurityConf;

import ucb.app.mslogin.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static ucb.app.mslogin.bl.UserBl.LOGGER;

/*
 * @Service
 * public class UserDetailsServiceImpl implements UserDetailsServiceImpl {
 * 
 * @Autowired
 * UserRepository userRepository;
 * 
 * 
 * @Override
 * public UserDetails loadUserByUsername(String s) throws
 * UsernameNotFoundException{
 * ucb.app.mslogin.dto.UserEntity appUser =
 * userRepository.findByUsername(s).orElseThrow(() -> new
 * UsernameNotFoundException("No existe el usuario"));
 * LOGGER.info(appUser.getNickname());
 * List grantList = new ArrayList();
 * grantList.add("ADMIN");
 * grantList.add("USER");
 * UserDetails user = (UserDetails) new User (appUser.getNickname(),
 * appUser.getPassword(),grantList);
 * LOGGER.info(user.getUsername());
 * return user;
 * }
 * }
 */