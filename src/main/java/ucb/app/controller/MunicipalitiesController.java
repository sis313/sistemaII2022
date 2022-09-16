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

import ucb.app.dto.MunicipalitiesDto;
import ucb.app.model.Municipalities;
import ucb.app.service.MunicipalitiesService;

@RestController
@RequestMapping("api/municipalities")
public class MunicipalitiesController {
    private MunicipalitiesService municipalitiesService;

    @Autowired
    public MunicipalitiesController(MunicipalitiesService municipalitiesService) {
        this.municipalitiesService = municipalitiesService;
    }

    @GetMapping
    public ResponseEntity<List<MunicipalitiesDto>> getMunicipalitieses() {
        List<MunicipalitiesDto> municipalitieses = municipalitiesService.findAllDto();
        return new ResponseEntity<>(municipalitieses, HttpStatus.OK);
    }

    @GetMapping(path = "/{municipalitiesId}")
    public ResponseEntity<MunicipalitiesDto> getMunicipalitiesById(
            @PathVariable("municipalitiesId") Integer municipalitiesId) throws Exception {
        MunicipalitiesDto municipalities = municipalitiesService.findByIdDto(municipalitiesId);
        return new ResponseEntity<>(municipalities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MunicipalitiesDto> postMunicipalities(@RequestBody Municipalities municipalities) {
        MunicipalitiesDto response = municipalitiesService.saveDto(municipalities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{municipalitiesId}")
    public ResponseEntity<MunicipalitiesDto> putMunicipalities(
            @PathVariable("municipalitiesId") Integer municipalitiesId, @RequestBody Municipalities municipalities) {
        MunicipalitiesDto response = municipalitiesService.updateDto(municipalitiesId, municipalities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{municipalitiesId}")
    public ResponseEntity<String> deleteCity(@PathVariable("municipalitiesId") Integer municipalitiesId) {
        String response = municipalitiesService.deleteByIdDto(municipalitiesId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
