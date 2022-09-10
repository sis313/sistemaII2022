package ucb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.app.model.City;
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

    @GetMapping(path = "/{cityId}")
    public ResponseEntity<City> getCityById(@PathVariable("cityId") Integer cityId) throws Exception {
        City city = cityRepository.findById(cityId).orElseThrow(() -> new Exception("Could not find city"));
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> postCity(@RequestBody City city) {
        City cityReponse = cityRepository.save(city);
        return new ResponseEntity<>(cityReponse, HttpStatus.OK);
    }

    @PutMapping(path = "/{cityId}")
    public ResponseEntity<City> putCity(@PathVariable("cityId") Integer cityId, @RequestBody City city) {
        City cityFound = cityRepository.getReferenceById(cityId);
        City cityResponse = cityRepository.save(cityFound);
        return new ResponseEntity<>(cityResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{cityId}")
    public ResponseEntity<String> deleteCity(@PathVariable("cityId") Integer cityId) {
        cityRepository.deleteById(cityId);
        return new ResponseEntity<>("City deleted successfully", HttpStatus.OK);
    }
}
