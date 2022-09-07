package ucb.edu.bo.tallersoftware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.tallersoftware.bl.UserBl;
import ucb.edu.bo.tallersoftware.model.User;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class UserApi {

    private UserBl userBl;

    @Autowired
    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listAll() {
        System.out.println("Invocando al metodo GET");
        return userBl.findAll();
    }

    @GetMapping(value = "/user/type={typeUser}/status={status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findUserByTypeAndStatus(@PathVariable("typeUser") Integer tipo,@PathVariable("status") Integer status) {
        System.out.println("Invocando al metodo GET");
        return userBl.findUserByTypeAndStatus(tipo,status);
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo GET");
        return userBl.findUserById(id);
    }
    
    @PutMapping(path="/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        System.out.println("Invocando al metodo PUT");
        return userBl.updateUser(user,id);
    }
}
