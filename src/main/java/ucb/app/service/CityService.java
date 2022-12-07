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

    public CityDto saveDto(CityDto cityDto) {
        City city = new City(cityDto.getIdCity(), cityDto.getName());
        City response = cityRepository.save(city);
        return cityToCityDto(response);
    }

    public CityDto updateDto(Integer cityId, CityDto cityDto) {
        City cityFound = cityRepository.getReferenceById(cityId);
        cityFound.setName(cityDto.getName());
        City response = cityRepository.save(cityFound);
        return cityToCityDto(response);
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
