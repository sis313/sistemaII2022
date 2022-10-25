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

import ucb.app.dto.CityDto;
import ucb.app.service.CityService;

@RestController
@RequestMapping("api/city")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getCities() {
        List<CityDto> cities = cityService.findAllDto();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(path = "/{cityId}")
    public ResponseEntity<CityDto> getCityById(@PathVariable("cityId") Integer cityId) throws Exception {
        CityDto city = cityService.findByIdDto(cityId);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityDto> postCity(@RequestBody CityDto cityDto) {
        CityDto response = cityService.saveDto(cityDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{cityId}")
    public ResponseEntity<CityDto> putCity(@PathVariable("cityId") Integer cityId, @RequestBody CityDto cityDto) {
        CityDto response = cityService.updateDto(cityId, cityDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{cityId}")
    public ResponseEntity<String> deleteCity(@PathVariable("cityId") Integer cityId) {
        String response = cityService.deleteByIdDto(cityId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
