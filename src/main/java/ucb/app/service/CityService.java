package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.CityDto;
import ucb.app.model.City;
import ucb.app.repository.CityRepository;

@Service
public class CityService {
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDto> findAllDto() {
        return cityRepository.findAll().stream().map(this::cityToCityDto).collect(Collectors.toList());
    }

    public CityDto findByIdDto(Integer cityId) throws Exception {
        return cityRepository.findById(cityId).stream().map(this::cityToCityDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find city"));
    }

    public Boolean saveDto(City city) {
        return cityRepository.save(city).equals(city) ? true : false;
    }

    public Boolean updateDto(Integer cityId, City city) {
        City cityFound = cityRepository.getReferenceById(cityId);
        return cityRepository.save(cityFound).equals(city) ? true : false;
    }

    public String deleteByIdDto(Integer cityId) {
        cityRepository.deleteById(cityId);
        return "City deleted successfully";
    }

    private CityDto cityToCityDto(City city) {
        CityDto cityDto = new CityDto(city.getIdCity(), city.getName());
        return cityDto;
    }
}
