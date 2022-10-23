package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.LogDto;
import ucb.app.model.Log;
import ucb.app.repository.LogRepository;

@Service
public class LogService {
    private LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<LogDto> findAllDto() {
        return logRepository.findAll().stream().map(this::logToLogDto).collect(Collectors.toList());
    }

    public LogDto findByIdDto(Integer logId) throws Exception {
        return logRepository.findById(logId).stream().map(this::logToLogDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find city"));
    }

    public LogDto saveDto(Log log) {
        Log response = logRepository.save(log);
        return logToLogDto(response);
    }

    private LogDto logToLogDto(Log log) {
        LogDto logDto = new LogDto(log.getIdLog(), log.getDate(), log.getIdBusiness(), log.getIdBranch(),
                log.getIdUser());
        return logDto;
    }
}
