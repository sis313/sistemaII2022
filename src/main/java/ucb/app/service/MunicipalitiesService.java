package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.MunicipalitiesDto;
import ucb.app.model.Municipalities;
import ucb.app.repository.MunicipalitiesRepository;

@Service
public class MunicipalitiesService {
    private MunicipalitiesRepository municipalitiesRepository;

    @Autowired
    public MunicipalitiesService(MunicipalitiesRepository municipalitiesRepository) {
        this.municipalitiesRepository = municipalitiesRepository;
    }

    public List<MunicipalitiesDto> findAllDto() {
        return municipalitiesRepository.findAll().stream().map(this::municipalitiesToMunicipalitiesDto)
                .collect(Collectors.toList());
    }

    public MunicipalitiesDto findByIdDto(Integer municipalitiesId) throws Exception {
        return municipalitiesRepository.findById(municipalitiesId).stream().map(this::municipalitiesToMunicipalitiesDto)
                .findFirst()
                .orElseThrow(() -> new Exception("Could not find municipalities"));
    }

    public MunicipalitiesDto saveDto(MunicipalitiesDto municipalitiesDto) {
        Municipalities municipalities = new Municipalities(municipalitiesDto.getIdMunicipalities(),
                municipalitiesDto.getName(), municipalitiesDto.getIdCity());
        Municipalities response = municipalitiesRepository.save(municipalities);
        return municipalitiesToMunicipalitiesDto(response);
    }

    public MunicipalitiesDto updateDto(Integer municipalitiesId, MunicipalitiesDto municipalitiesDto) {
        Municipalities municipalitiesFound = municipalitiesRepository.getReferenceById(municipalitiesId);
        municipalitiesFound.setName(municipalitiesDto.getName());
        municipalitiesFound.setIdCity(municipalitiesDto.getIdCity());
        Municipalities response = municipalitiesRepository.save(municipalitiesFound);
        return municipalitiesToMunicipalitiesDto(response);
    }

    public String deleteByIdDto(Integer municipalitiesId) {
        municipalitiesRepository.deleteById(municipalitiesId);
        return "Municipalities deleted successfully";
    }

    private MunicipalitiesDto municipalitiesToMunicipalitiesDto(Municipalities municipalities) {
        MunicipalitiesDto municipalitiesDto = new MunicipalitiesDto(municipalities.getIdMunicipalities(),
                municipalities.getName(), municipalities.getIdCity());
        return municipalitiesDto;
    }
}
