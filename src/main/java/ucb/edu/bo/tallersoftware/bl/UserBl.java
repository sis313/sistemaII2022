package ucb.edu.bo.tallersoftware.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.tallersoftware.dao.UserDao;
import ucb.edu.bo.tallersoftware.model.User;
import ucb.edu.bo.tallersoftware.service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserBl implements UserService{
    private UserDao userDao;

    @Autowired
    public UserBl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        Optional<User> userOpt = userDao.findById(id);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            return user;
        }else{
            return null;
        }
    }
    
    @Override
    public User updateUser(User user, Integer userId) {
        User userDB = userDao.getById(userId);
        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())){
            userDB.setName(user.getName());
        }
        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            userDB.setEmail(user.getEmail());
        }
        if (Objects.nonNull(user.getNickname()) && !"".equalsIgnoreCase(user.getNickname())){
            userDB.setNickname(user.getNickname());
        }
        if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())){
            userDB.setPassword(user.getPassword());
        }
        if (Objects.nonNull(user.getTypeUserId())) {
            userDB.setTypeUserId(user.getTypeUserId());
        }
        if (Objects.nonNull(user.getCreateDate())) {
            userDB.setCreateDate(user.getCreateDate());
        }
        if (Objects.nonNull(user.getUpdateDate())) {
            LocalDate dateObj = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = dateObj.format(formatter);
            userDB.setUpdateDate(date);
        }
        if (Objects.nonNull(user.getStatus())) {
            userDB.setStatus(user.getStatus());
        }
        return userDao.save(userDB);
    }  
    
    public List<User> findUserByTypeAndStatus(Integer tipo, Integer status) {
        return (List<User>) userDao.findUserByTypeAndStatus(tipo, status);
    }
}
