package ucb.edu.bo.tallersoftware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.edu.bo.tallersoftware.bl.TypeUserBl;
import ucb.edu.bo.tallersoftware.model.TypeUser;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class BusinessListApi {
/*
    private TypeUserBl typeUserBl;

    @Autowired
    public TypeuserApi(TypeUserBl typeUserBl) {
        this.typeUserBl = typeUserBl;
    }

    @GetMapping(value = "/adminTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TypeUser> listAll() {
        System.out.println("Invocando al metodo GET");
        return typeUserBl.findAll();
    }*/
}

