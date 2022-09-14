package ucb.edu.bo.tallersoftware.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.tallersoftware.dto.StoreRequest;
import ucb.edu.bo.tallersoftware.dto.UserRequest;
import ucb.edu.bo.tallersoftware.model.BusinessList;

import java.util.List;
@Repository
public interface StoreAreaDao extends JpaRepository<BusinessList, Integer> {
    @Query(
            value = "SELECT new ucb.edu.bo.tallersoftware.dto.StoreRequest(a.name, COUNT (c.id)) " +
                    "FROM Zone a, Branch b, BusinessList c " +
                    "WHERE a.id_zone=b.id_zone and b.id_business = c.id GROUP BY a.name ORDER BY c.id DESC"
    )
    public List<StoreRequest> findStoreList();
}
