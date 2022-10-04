package ucb.edu.bo.tallersoftware.service;

import ucb.edu.bo.tallersoftware.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User updateUser(User user, Integer userId);
    User findUserById(Integer userId);
    User updateUserStatus(User user, Integer userId);
}
