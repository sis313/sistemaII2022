package ucb.edu.bo.tallersoftware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.tallersoftware.bl.StoreAreaBl;
import ucb.edu.bo.tallersoftware.dto.StoreRequest;
import ucb.edu.bo.tallersoftware.model.BusinessList;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class StoreAreaApi {
    private StoreAreaBl storeAreaBl;

    @Autowired
    public StoreAreaApi(StoreAreaBl storeAreaBl) {
        this.storeAreaBl = storeAreaBl;
    }

    @RequestMapping(value = "/countBusiness",method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StoreRequest> listAll() {
        System.out.println("Invocando al metodo GET :0");
        return storeAreaBl.getBusinessCount();
    }
}
