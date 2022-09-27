
package ucb.edu.bo.demo.api;

import ucb.edu.bo.demo.bl.BusinessBl;
import ucb.edu.bo.demo.dto.Business;
import ucb.edu.bo.demo.dto.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class BusinessApi {

    BusinessBl businessBl;

    @Autowired
    public BusinessApi(BusinessBl businessBl) {
        this.businessBl = businessBl;
    }

    @GetMapping(value = "/Business")
    public List<Business> getAll(){
        return businessBl.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/Business/{id}")
    public List<Business> getById(@PathVariable(name = "id") int id){
        return businessBl.getById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/Business/name/{name}"
    )
    public List<Business> findByName(@PathVariable(name = "name") String name){
        return businessBl.findByName(name);
    }

    @GetMapping(value = "/Types")
    public List<Type> getAllTypes(){
        return businessBl.getAllTypes();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/Business/Type/{name}")
    public List<Business> findByType(@PathVariable(name = "name") String name){
        return businessBl.findByType(name);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/Business/filter/{type_name}/{business_name}")
    public List<Business> findByNameAndType(@PathVariable(name = "type_name") String type_name, @PathVariable(name = "business_name") String business_name){
        return businessBl.findByNameAndType(type_name, business_name);
    }
}

