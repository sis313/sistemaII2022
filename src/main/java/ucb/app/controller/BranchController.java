package ucb.app.controller;

import java.util.List;

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

import ucb.app.dto.BranchDto;
import ucb.app.model.Branch;
import ucb.app.service.BranchService;

@RestController
@RequestMapping("api/branch")
public class BranchController {
    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public ResponseEntity<List<BranchDto>> getBranches() {
        List<BranchDto> branches = branchService.findAllDto();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    @GetMapping(path = "/{branchId}")
    public ResponseEntity<BranchDto> getBranchById(@PathVariable("branchId") Integer branchId) throws Exception {
        BranchDto branch = branchService.findByIdDto(branchId);
        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<BranchDto>> getBranchesByBusinessId(@RequestParam("businessId") Integer businessId) {
        List<BranchDto> branches = branchService.findByBusinessIdDto(businessId);
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BranchDto> postBranch(@RequestBody Branch branch) {
        BranchDto response = branchService.saveDto(branch);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{branchId}")
    public ResponseEntity<BranchDto> putBranch(@PathVariable("branchId") Integer branchId, @RequestBody Branch branch) {
        BranchDto response = branchService.updateDto(branchId, branch);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{branchId}")
    public ResponseEntity<String> deleteBranch(@PathVariable("branchId") Integer branchId) {
        String response = branchService.deleteByIdDto(branchId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
