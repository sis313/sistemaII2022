package ucb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

}
