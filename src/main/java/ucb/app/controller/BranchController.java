package ucb.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ucb.app.dto.BranchDto;
import ucb.app.dto.BranchLocationDto;
import ucb.app.service.BranchService;

@RestController
@RequestMapping("api/branch")
public class BranchController {
    private BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public ResponseEntity<List<BranchDto>> getBranches() {
        List<BranchDto> branches = branchService.findAllDto();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    @GetMapping(path = "/location")
    public ResponseEntity<List<BranchLocationDto>> getBranchesWithLocation() {
        List<BranchLocationDto> branchesWithLocation = branchService.findAllWithLocationDto();
        return new ResponseEntity<>(branchesWithLocation, HttpStatus.OK);
    }

    @GetMapping(path = "/{branchId}")
    public ResponseEntity<BranchDto> getBranchById(@PathVariable("branchId") Integer branchId) throws Exception {
        BranchDto branch = branchService.findByIdDto(branchId);
        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<BranchDto>> getBranchesByBusinessId(@RequestParam("businessId") Integer businessId) {
        List<BranchDto> branches = branchService.findAllByBusinessIdDto(businessId);
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BranchDto> postBranch(
            @RequestParam(value = "address") String address,
            @RequestParam(value = "openHour") @DateTimeFormat(pattern = "HH:mm:ss") Date openHour,
            @RequestParam(value = "closeHour") @DateTimeFormat(pattern = "HH:mm:ss") Date closeHour,
            @RequestParam(value = "attentionDays") String attentionDays,
            @RequestParam(value = "image") MultipartFile image,
            @RequestParam(value = "idZone") int idZone,
            @RequestParam(value = "idLocation") int idLocation,
            @RequestParam(value = "idBusiness") int idBusiness,
            @RequestParam(value = "status") int status) {
        BranchDto response = branchService.saveDto(address, openHour, closeHour, attentionDays, image, idZone,
                idLocation, idBusiness, status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/json")
    public ResponseEntity<BranchDto> postBranchJson(@RequestBody BranchDto branchDto) {
        BranchDto response = branchService.saveJsonDto(branchDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{branchId}")
    public ResponseEntity<BranchDto> putBranch(
            @PathVariable("branchId") Integer branchId,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "openHour") @DateTimeFormat(pattern = "HH:mm:ss") Date openHour,
            @RequestParam(value = "closeHour") @DateTimeFormat(pattern = "HH:mm:ss") Date closeHour,
            @RequestParam(value = "attentionDays") String attentionDays,
            @RequestParam(value = "image") MultipartFile image,
            @RequestParam(value = "idZone") int idZone,
            @RequestParam(value = "idLocation") int idLocation,
            @RequestParam(value = "idBusiness") int idBusiness,
            @RequestParam(value = "status") int status) {
        BranchDto response = branchService.updateDto(branchId, address, openHour, closeHour, attentionDays, image,
                idZone,
                idLocation, idBusiness, status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/json/{branchId}")
    public ResponseEntity<BranchDto> putJsonBranch(@PathVariable("branchId") Integer branchId,
            @RequestBody BranchDto branchDto) {
        BranchDto response = branchService.updateJsonDto(branchId, branchDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{branchId}")
    public ResponseEntity<BranchDto> deleteBranch(@PathVariable("branchId") Integer branchId) {
        BranchDto response = branchService.deleteByIdDto(branchId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
