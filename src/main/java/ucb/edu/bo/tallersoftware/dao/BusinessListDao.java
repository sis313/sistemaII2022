package ucb.edu.bo.tallersoftware.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.tallersoftware.model.BusinessList;
@Repository
public interface BusinessListDao  extends JpaRepository<BusinessList, Integer> {
    @Query(
            value = "SELECT b.*" +
                    "   FROM business b" +
                    "   WHERE b.status = :status",
            nativeQuery = true
    )
    public List<BusinessList> findBusinessByStatus(@Param("status") Integer status);

}
