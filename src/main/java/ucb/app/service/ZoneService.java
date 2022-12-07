package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.ZoneDto;
import ucb.app.model.Zone;
import ucb.app.repository.ZoneRepository;

@Service
public class ZoneService {
    private ZoneRepository zoneRepository;

    @Autowired
    public ZoneService(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public List<ZoneDto> findAllDto() {
        return zoneRepository.findAll().stream().map(this::zoneToZoneDto).collect(Collectors.toList());
    }

    public ZoneDto findByIdDto(Integer zoneId) throws Exception {
        return zoneRepository.findById(zoneId).stream().map(this::zoneToZoneDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find zone"));
    }

    public ZoneDto saveDto(ZoneDto zoneDto) {
        Zone zone = new Zone(zoneDto.getIdZone(), zoneDto.getName(), zoneDto.getIdMunicipalities());
        Zone response = zoneRepository.save(zone);
        return zoneToZoneDto(response);
    }

    public ZoneDto updateDto(Integer zoneId, ZoneDto zoneDto) {
        Zone zoneFound = zoneRepository.getReferenceById(zoneId);
        zoneFound.setName(zoneDto.getName());
        zoneFound.setIdMunicipalities(zoneDto.getIdMunicipalities());
        Zone response = zoneRepository.save(zoneFound);
        return zoneToZoneDto(response);
    }

    public String deleteByIdDto(Integer zoneId) {
        zoneRepository.deleteById(zoneId);
        return "Zone deleted successfully";
    }

    private ZoneDto zoneToZoneDto(Zone zone) {
        ZoneDto zoneDto = new ZoneDto(zone.getIdZone(), zone.getName(), zone.getIdMunicipalities());
        return zoneDto;
    }
}
