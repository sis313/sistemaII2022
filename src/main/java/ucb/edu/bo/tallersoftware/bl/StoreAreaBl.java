package ucb.edu.bo.tallersoftware.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.tallersoftware.dao.StoreAreaDao;
import ucb.edu.bo.tallersoftware.dto.StoreRequest;
import ucb.edu.bo.tallersoftware.dto.StoresByZone;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreAreaBl {
    @Autowired
    private StoreAreaDao storeAreaDao;

    public List<StoreRequest> getBusinessCount (){
        List<Integer> list= new ArrayList<>();
        System.out.println(storeAreaDao.findStoreList());
        return storeAreaDao.findStoreList();
    }
    public List<StoresByZone> getBusinessByZone (Integer id_zone){
        System.out.println(storeAreaDao.findStoreByZone(id_zone));
        return storeAreaDao.findStoreByZone(id_zone);
    }

}
