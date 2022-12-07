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

import ucb.app.dto.ZoneDto;
import ucb.app.service.ZoneService;

@RestController
@RequestMapping("api/zone")
public class ZoneController {
    private ZoneService zoneService;

    @Autowired
    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping
    public ResponseEntity<List<ZoneDto>> getZones() {
        List<ZoneDto> zones = zoneService.findAllDto();
        return new ResponseEntity<>(zones, HttpStatus.OK);
    }

    @GetMapping(path = "/{zoneId}")
    public ResponseEntity<ZoneDto> getZoneById(@PathVariable("zoneId") Integer zoneId) throws Exception {
        ZoneDto zone = zoneService.findByIdDto(zoneId);
        return new ResponseEntity<>(zone, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ZoneDto> postZone(@RequestBody ZoneDto zoneDto) {
        ZoneDto response = zoneService.saveDto(zoneDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{zoneId}")
    public ResponseEntity<ZoneDto> putZone(@PathVariable("zoneId") Integer zoneId, @RequestBody ZoneDto zoneDto) {
        ZoneDto response = zoneService.updateDto(zoneId, zoneDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{zoneId}")
    public ResponseEntity<String> deleteZone(@PathVariable("zoneId") Integer zoneId) {
        String response = zoneService.deleteByIdDto(zoneId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
