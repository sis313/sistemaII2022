package ucb.edu.bo.tallersoftware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.tallersoftware.bl.TypeUserBl;
import ucb.edu.bo.tallersoftware.model.TypeUser;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class TypeuserApi {

    private TypeUserBl typeUserBl;

    @Autowired
    public TypeuserApi(TypeUserBl typeUserBl) {
        this.typeUserBl = typeUserBl;
    }

    @GetMapping(value = "/adminTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TypeUser> listAll() {
        System.out.println("Invocando al metodo GET");
        return typeUserBl.findAll();
    }
}
