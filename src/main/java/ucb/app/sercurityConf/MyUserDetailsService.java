package ucb.app.sercurityConf;


/*@Service
public class UserDetailsServiceImpl implements UserDetailsServiceImpl {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
        com.example.mslogin.dto.UserEntity appUser = userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("No existe el usuario"));
        LOGGER.info(appUser.getNickname());
        List grantList = new ArrayList();
        grantList.add("ADMIN");
        grantList.add("USER");
        UserDetails user = (UserDetails) new User (appUser.getNickname(), appUser.getPassword(),grantList);
        LOGGER.info(user.getUsername());
        return user;
    }
}
*/