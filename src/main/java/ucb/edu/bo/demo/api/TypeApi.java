
package ucb.edu.bo.demo.api;

import ucb.edu.bo.demo.bl.TypeBl;
import ucb.edu.bo.demo.dto.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class TypeApi {

    TypeBl typeBl;

    @Autowired
    public TypeApi(TypeBl typeBl) {
        this.typeBl = typeBl;
    }

    @GetMapping(value = "/Types")
    public List<Type> getAllTypes(){
        return typeBl.getAllTypes();
    }
}

