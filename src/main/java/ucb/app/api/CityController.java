package ucb.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.app.entity.City;
import ucb.app.repository.CityRepository;

@RestController
@RequestMapping("api/city")
public class CityController {
    private CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public ResponseEntity<List<City>> getCities() {
        List<City> cities = cityRepository.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
