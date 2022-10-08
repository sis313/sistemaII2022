package ucb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Business;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
    public List<Business> findByIdUser(Integer idUser);

    // GROUP 2 ROUTE
    public List<Business> findByStatus(Integer status);

    // GROUP 3 ROUTE
    public List<Business> findByName(String name);

    // GROUP 3 ROUTE
    public List<Business> findByType(String type);

    // GROUP 3 ROUTE
    public List<Business> findByNameAndType(String name, String type);
}
