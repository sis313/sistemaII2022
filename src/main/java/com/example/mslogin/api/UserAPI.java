package com.example.mslogin.api;

import com.example.mslogin.bl.UserBl;
import com.example.mslogin.dto.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/user")
public class UserAPI {
    private UserBl userBl;
    private UserEntity userEntity;
    Logger LOGGER = LoggerFactory.getLogger(UserAPI.class);

    public UserAPI(UserBl userBl) {
        this.userBl = userBl;
    }


    @PostMapping("")
    public ResponseEntity<String> addUser(@RequestBody UserEntity userEntity){
        LOGGER.info("addUser from UserAPI");
        String response = String.valueOf(this.userBl.saveUser(userEntity));
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<userEntity>> getOrderById(@PathVariable Integer id){
        LOGGER.info("Invocando al servicio REST para obtener un usuario");
        Optional<userEntity> user = orderRepository.findById(id);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener un usuario {}", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
