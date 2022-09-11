package ucb.edu.bo.tallersoftware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.edu.bo.tallersoftware.bl.BusinessListBl;
import ucb.edu.bo.tallersoftware.model.BusinessList;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class BusinessListApi {

    private BusinessListBl businessListBl;

    @Autowired
    public BusinessListApi(BusinessListBl businessListBl) {
        this.businessListBl = businessListBl;
    }

    @GetMapping(value = "/adminBusiness", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessList> listAll() {
        System.out.println("Invocando al metodo GET :0");
        return businessListBl.findAll();
    }

    @GetMapping(value = "/adminBusiness/status={status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessList> findBusinessByStatus(@PathVariable("status") Integer status) {
        System.out.println("Invocando al metodo GET");
        return businessListBl.findBusinessByStatus(status);
    }

    @DeleteMapping(value = "/adminBusiness/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessList> delete(@PathVariable("status") Integer status) {
        System.out.println("Invocando al metodo DELETE");
        return businessListBl.findBusinessById(status);
    }

    @GetMapping(value = "/adminBusiness/{id}")
    public BusinessList getBusinessById(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo GET");
        return businessListBl.findAdminBusinessById(id);
    }
    
    @PutMapping(path="/adminBusiness/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public BusinessList updateBusiness(@PathVariable("id") Integer id, @RequestBody BusinessList business) {
        System.out.println("Invocando al metodo PUT");
        return businessListBl.updateBusiness(business,id);
    }
}
