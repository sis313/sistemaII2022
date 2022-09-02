package ucb.edu.bo.tallersoftware.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.tallersoftware.dao.TypeUserDao;
import ucb.edu.bo.tallersoftware.model.TypeUser;
import ucb.edu.bo.tallersoftware.service.TypeUserService;


import java.util.List;

@Service
public class TypeUserBl implements TypeUserService{
    private TypeUserDao typeUserDao;

    @Autowired
    public TypeUserBl(TypeUserDao typeUserDao) {
        this.typeUserDao = typeUserDao;
    }


    @Override
    public List<TypeUser> findAll() {
        return (List<TypeUser>) typeUserDao.findAll();
    }
    
}
