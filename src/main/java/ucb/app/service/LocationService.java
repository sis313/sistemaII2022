package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.LocationDto;
import ucb.app.model.Location;
import ucb.app.repository.LocationRepository;

@Service
public class LocationService {
    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDto> findAllDto() {
        return locationRepository.findAll().stream().map(this::locationToLocationDto).collect(Collectors.toList());
    }

    public LocationDto findByIdDto(Integer locationId) throws Exception {
        return locationRepository.findById(locationId).stream().map(this::locationToLocationDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find location"));
    }

    public LocationDto saveDto(LocationDto locationDto) {
        Location location = new Location(locationDto.getIdLocation(), locationDto.getLatitude(),
                locationDto.getLongitude());
        Location response = locationRepository.save(location);
        return locationToLocationDto(response);
    }

    public LocationDto updateDto(Integer locationId, LocationDto locationDto) {
        Location locationFound = locationRepository.getReferenceById(locationId);
        locationFound.setLatitude(locationDto.getLatitude());
        locationFound.setLongitude(locationDto.getLongitude());
        Location response = locationRepository.save(locationFound);
        return locationToLocationDto(response);
    }

    public String deleteByIdDto(Integer locationId) {
        locationRepository.deleteById(locationId);
        return "Location deleted successfully";
    }

    private LocationDto locationToLocationDto(Location location) {
        LocationDto locationDto = new LocationDto(location.getIdLocation(), location.getLatitude(),
                location.getLongitude());
        return locationDto;
    }
}
