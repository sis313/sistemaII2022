package ucb.edu.bo.tallersoftware.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.tallersoftware.dao.BusinessListDao;
import ucb.edu.bo.tallersoftware.model.BusinessList;
import ucb.edu.bo.tallersoftware.service.BusinessListService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    @Override
    public BusinessList findAdminBusinessById(Integer businessId) {
        Optional<BusinessList> BusinessOpt = businessListDao.findById(businessId);
        if(BusinessOpt.isPresent()){
            BusinessList Business = BusinessOpt.get();
            return Business;
        }else{
            return null;
        }
    }

    @Override
    public BusinessList updateBusiness(BusinessList businessList, Integer businessListId) {
        BusinessList businessListDB = businessListDao.getById(businessListId);
        if (Objects.nonNull(businessList.getName()) && !"".equalsIgnoreCase(businessList.getName())){
            businessListDB.setName(businessList.getName());
        }
        if (Objects.nonNull(businessList.getDescription()) && !"".equalsIgnoreCase(businessList.getDescription())){
            businessListDB.setDescription(businessList.getDescription());
        }
        if (Objects.nonNull(businessList.getId_type_business())){
            businessListDB.setId_type_business(businessList.getId_type_business());
        }
        if (Objects.nonNull(businessList.getCreate_date())) {
            businessListDB.setCreate_date(businessList.getCreate_date());
        }
        if (Objects.nonNull(businessList.getUpdate_date())) {
            businessListDB.setUpdate_date(businessList.getUpdate_date());
        }
        if (Objects.nonNull(businessList.getStatus())) {
            businessListDB.setStatus(businessList.getStatus());
        }
        if (Objects.nonNull(businessList.getUser_id_user())) {
            businessListDB.setUser_id_user(businessList.getUser_id_user());
        }
        return businessListDao.save(businessListDB);
    }  

    @Override
    public BusinessList updateBusinessStatus(BusinessList businessList, Integer businessListId) {
        BusinessList businessListDB = businessListDao.getById(businessListId);
        if (Objects.nonNull(businessList.getStatus())) {
            businessListDB.setStatus(businessList.getStatus());
        }
        return businessListDao.save(businessListDB);
    }  
}

