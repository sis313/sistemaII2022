package ucb.edu.bo.tallersoftware.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.tallersoftware.dao.StoreAreaDao;
import ucb.edu.bo.tallersoftware.dto.StoreRequest;

import java.util.List;

@Service
public class StoreAreaBl {
    @Autowired
    private StoreAreaDao storeAreaDao;




    public List<StoreRequest> getBusinessCount (){
        System.out.println(storeAreaDao.findStoreList());
        return storeAreaDao.findStoreList();
    }
}
