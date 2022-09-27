package ucb.edu.bo.demo.bl;

import ucb.edu.bo.demo.dto.Business;
import ucb.edu.bo.demo.dto.Type;
import ucb.edu.bo.demo.dao.BusinessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessBl {
    private final BusinessDao businessDao;

    @Autowired
    public BusinessBl(BusinessDao businessDao) {this.businessDao = businessDao;}

    public List<Business> getAll (){
        return businessDao.getAll();
    }

    public List<Business> getById (int id){
        return businessDao.getById(id);
    }

    public List<Business> findByName (String name){
        return businessDao.findByName(name);
    }

    public List<Business> getAllTypes(){
        return businessDao.getAllTypes();
    }

    public List<Business> findByType (String name){
        return businessDao.findByType(name);
    }

    public List<Business> findByNameAndType (String type_name, String business_name){
        return businessDao.findByNameAndType(type_name, business_name);
    }
    
}
