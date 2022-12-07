package ucb.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.app.dto.LogDto;
import ucb.app.service.LogService;

@RestController
@RequestMapping("api/log")
public class LogController {
    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<List<LogDto>> getLogs() {
        List<LogDto> logs = logService.findAllDto();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    @GetMapping(path = "/{logId}")
    public ResponseEntity<LogDto> getLogById(@PathVariable("logId") Integer logId) throws Exception {
        LogDto log = logService.findByIdDto(logId);
        return new ResponseEntity<>(log, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LogDto> postLog(@RequestBody LogDto logDto) {
        LogDto response = logService.saveDto(logDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
