package ucb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Municipalities;

public interface MunicipalitiesRepository extends JpaRepository<Municipalities, Integer> {

}
