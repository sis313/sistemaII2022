package ucb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Business;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
    public List<Business> findByUserIdUser(Integer userIdUser);
}
