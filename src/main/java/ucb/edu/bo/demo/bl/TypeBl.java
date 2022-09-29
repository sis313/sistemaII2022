package ucb.edu.bo.demo.bl;

import ucb.edu.bo.demo.dto.Type;
import ucb.edu.bo.demo.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeBl {
    private final TypeDao typeDao;

    @Autowired
    public TypeBl(TypeDao typeDao) {this.typeDao = typeDao;}

    public List<Type> getAllTypes(){
        return typeDao.getAllTypes();
    }
    
}
