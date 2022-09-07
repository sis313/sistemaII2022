package ucb.edu.bo.tallersoftware.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.tallersoftware.dao.BusinessListDao;
import ucb.edu.bo.tallersoftware.model.BusinessList;
import ucb.edu.bo.tallersoftware.service.BusinessListService;

import java.util.List;
@Service
public class BusinessListBl implements BusinessListService {
    private BusinessListDao businessListDao;

    @Autowired
    public BusinessListBl(BusinessListDao businessListDao) {
        this.businessListDao = businessListDao;
    }


    @Override
    public List<BusinessList> findAll() {
        return (List<BusinessList>) businessListDao.findAll();
    }


    public List<BusinessList> findBusinessByStatus(Integer status) {
        return (List<BusinessList>) businessListDao.findBusinessByStatus(status);
    }


    public List<BusinessList> findBusinessById(Integer status) {
        return (List<BusinessList>) businessListDao.findAll();
    }
}
