package ucb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
