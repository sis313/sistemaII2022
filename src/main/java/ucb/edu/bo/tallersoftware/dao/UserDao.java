package ucb.edu.bo.tallersoftware.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.tallersoftware.dto.UserRequest;
import ucb.edu.bo.tallersoftware.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    
    @Query(value = "select new ucb.edu.bo.tallersoftware.dto.UserRequest(" +
            "user.name, user.email, user.nickname, user.password, " +
            "typeUser.name, user.createDate, user.updateDate ) " +
            "from User user, TypeUser typeUser " +
            "where user.status=1 " +
            "and user.id=?1 ")
    public UserRequest getUserById(Integer userId);
    
}
