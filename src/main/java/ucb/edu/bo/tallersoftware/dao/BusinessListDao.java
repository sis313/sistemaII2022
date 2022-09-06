package ucb.edu.bo.tallersoftware.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.tallersoftware.model.BusinessList;
@Repository
public interface BusinessListDao  extends JpaRepository<BusinessList, Integer> {

}
