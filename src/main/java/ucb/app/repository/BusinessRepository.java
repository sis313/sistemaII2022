package ucb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Business;

public interface BusinessRepository extends JpaRepository<Business, Integer> {

}
