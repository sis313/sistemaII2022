package ucb.edu.bo.tallersoftware.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.tallersoftware.dto.BusinessRequest;
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

    @Query(value = "select new ucb.edu.bo.tallersoftware.dto.BusinessRequest(" +
    "business.name, business.description, business.id_type_business, " +
    "business.create_date, business.update_date, business.user_id_user) " +
    "from BusinessList business " +
    "where business.status=1 " +
    "and business.id=?1 ")
    public BusinessRequest getBusinessById(Integer businessId);

    @Query(value = "select new ucb.edu.bo.tallersoftware.dto.BusinessRequest(" +
    "business.name, business.description, business.id_type_business, " +
    "business.create_date, business.update_date, business.user_id_user) " +
    "from BusinessList business " +
    "where business.status=0 " +
    "and business.id=?1 ")
    public BusinessRequest getInactiveBusinessById(Integer businessId);

    @Query(
            value = "DELETE b.*" +
                    "   FROM business b" +
                    "   WHERE b.id_business = :id_business",
            nativeQuery = true

    )
    public List<BusinessList> findBusinessById(@Param("id_business") Integer id_business);
}
