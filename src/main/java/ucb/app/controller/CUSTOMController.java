package ucb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.app.service.CUSTOMService;
import ucb.app.dto.BusinessCountDto;
import ucb.app.dto.BusinessZoneDto;

@RestController
@RequestMapping("api/custom")
public class CUSTOMController {
    private CUSTOMService customService;

    @Autowired
    public CUSTOMController(CUSTOMService customService) {
        this.customService = customService;
    }

    @GetMapping(path = "/countBusiness")
    public ResponseEntity<List<BusinessCountDto>> getBusinessCounts() {
        List<BusinessCountDto> businessCounts = customService.findBusinessCountDto();
        return new ResponseEntity<>(businessCounts, HttpStatus.OK);
    }

    @GetMapping(path = "/bussinesZone/{zoneId}")
    public ResponseEntity<List<BusinessZoneDto>> getBranchById(@PathVariable("zoneId") Integer zoneId) {
        List<BusinessZoneDto> businessZones = customService.findBusinessByZoneDto(zoneId);
        return new ResponseEntity<>(businessZones, HttpStatus.OK);
    }
}
