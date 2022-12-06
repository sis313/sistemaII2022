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

import ucb.app.dto.LocationDto;
import ucb.app.model.Location;
import ucb.app.service.LocationService;

@RestController
@RequestMapping("api/location")
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> getLocations() {
        List<LocationDto> locations = locationService.findAllDto();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping(path = "/{locationId}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable("locationId") Integer locationId)
            throws Exception {
        LocationDto location = locationService.findByIdDto(locationId);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationDto> postLocation(@RequestBody Location location) {
        LocationDto response = locationService.saveDto(location);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{locationId}")
    public ResponseEntity<LocationDto> putLocation(@PathVariable("locationId") Integer locationId,
            @RequestBody Location location) {
        LocationDto response = locationService.updateDto(locationId, location);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable("locationId") Integer locationId) {
        String response = locationService.deleteByIdDto(locationId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
