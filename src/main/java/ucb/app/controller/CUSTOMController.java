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
import ucb.app.dto.BranchRatingCountDto;
import ucb.app.dto.BusinessBranchActiveCountDto;
import ucb.app.dto.BusinessCountDto;
import ucb.app.dto.BusinessZoneDto;
import ucb.app.dto.LogAnualCountDto;
import ucb.app.dto.LogDayCountDto;
import ucb.app.dto.LogGlobalCountDto;
import ucb.app.dto.LogMonthCountDto;
import ucb.app.dto.LogQuarterCountDto;
import ucb.app.dto.LogSemesterCountDto;

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

    @GetMapping(path = "/branchRatingCount")
    public ResponseEntity<List<BranchRatingCountDto>> getBranchRatingCount() {
        List<BranchRatingCountDto> branchRatingCountDtos = customService.findBranchRatingCountDto();
        return new ResponseEntity<>(branchRatingCountDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/logGlobalCount")
    public ResponseEntity<List<LogGlobalCountDto>> getLogGlobalCount() {
        List<LogGlobalCountDto> logGlobalCountDtos = customService.findLogGlobalCountDto();
        return new ResponseEntity<>(logGlobalCountDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/logAnualCount")
    public ResponseEntity<List<LogAnualCountDto>> getLogAnualCount() {
        List<LogAnualCountDto> logAnualCountDtos = customService.findLogAnualCountDto();
        return new ResponseEntity<>(logAnualCountDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/logSemesterCount")
    public ResponseEntity<List<LogSemesterCountDto>> getLogSemesterCount() {
        List<LogSemesterCountDto> logSemesterCountDtos = customService.findLogSemesterCountDto();
        return new ResponseEntity<>(logSemesterCountDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/logQuarterCount")
    public ResponseEntity<List<LogQuarterCountDto>> getLogQuarterCount() {
        List<LogQuarterCountDto> logQuarterCountDtos = customService.findLogQuarterCountDto();
        return new ResponseEntity<>(logQuarterCountDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/logMonthCount")
    public ResponseEntity<List<LogMonthCountDto>> getLogMonthCount() {
        List<LogMonthCountDto> logMonthCountDtos = customService.findLogMonthCountDto();
        return new ResponseEntity<>(logMonthCountDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/logDayCount")
    public ResponseEntity<List<LogDayCountDto>> getLogDayCount() {
        List<LogDayCountDto> logDayCountDtos = customService.findLogDayCountDto();
        return new ResponseEntity<>(logDayCountDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/logAnualCount/userId/{userId}")
    public ResponseEntity<List<LogAnualCountDto>> getLogAnualCountByUserId(@PathVariable("userId") Integer userId) {
        List<LogAnualCountDto> logAnualCountDtos = customService.findLogAnualCountByUserIdDto(userId);
        return new ResponseEntity<>(logAnualCountDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/businessBranchActiveCount")
    public ResponseEntity<List<BusinessBranchActiveCountDto>> getBusinessBranchActiveCount() {
        List<BusinessBranchActiveCountDto> businessBranchActiveCountDtos = customService
                .findBusinessBranchActiveCountDto();
        return new ResponseEntity<>(businessBranchActiveCountDtos, HttpStatus.OK);
    }
}
