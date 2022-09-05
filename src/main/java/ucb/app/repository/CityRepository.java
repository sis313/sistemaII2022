package ucb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
