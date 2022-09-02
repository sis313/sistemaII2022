package ucb.edu.bo.tallersoftware.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.tallersoftware.model.TypeUser;

@Repository
public interface TypeUserDao extends JpaRepository<TypeUser, Integer> {
    
}
