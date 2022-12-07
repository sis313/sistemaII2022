package ucb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Log;

public interface LogRepository extends JpaRepository<Log, Integer> {

}
