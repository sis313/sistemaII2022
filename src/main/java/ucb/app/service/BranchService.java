package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.BranchDto;
import ucb.app.model.Branch;
import ucb.app.repository.BranchRepository;

@Service
public class BranchService {
    private BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<BranchDto> findAllDto() {
        return branchRepository.findAll().stream().map(this::branchToBranchDto).collect(Collectors.toList());
    }

    public BranchDto findByIdDto(Integer branchId) throws Exception {
        return branchRepository.findById(branchId).stream().map(this::branchToBranchDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find branch"));
    }

    public List<BranchDto> findAllByBusinessIdDto(Integer businessId) {
        return branchRepository.findByIdBusiness(businessId).stream().map(this::branchToBranchDto)
                .collect(Collectors.toList());
    }

    public BranchDto saveDto(Branch branch) {
        Branch response = branchRepository.save(branch);
        return branchToBranchDto(response);
    }

    public BranchDto updateDto(Integer branchId, Branch branch) {
        Branch branchFound = branchRepository.getReferenceById(branchId);
        branchFound.setDirection(branch.getDirection());
        branchFound.setOpenHour(branch.getOpenHour());
        branchFound.setCloseHour(branch.getCloseHour());
        branchFound.setAttentionDays(branch.getAttentionDays());
        branchFound.setImage(branch.getImage());
        branchFound.setIdZone(branch.getIdZone());
        branchFound.setIdLocation(branch.getIdLocation());
        branchFound.setIdBusiness(branch.getIdBusiness());
        branchFound.setCreateDate(branch.getCreateDate());
        branchFound.setUpdateDate(branch.getUpdateDate());
        branchFound.setStatus(branch.getStatus());
        Branch response = branchRepository.save(branchFound);
        return branchToBranchDto(response);
    }

    public String deleteByIdDto(Integer branchId) {
        branchRepository.deleteById(branchId);
        return "Branch deleted successfully";
    }

    private BranchDto branchToBranchDto(Branch branch) {
        BranchDto branchDto = new BranchDto(branch.getIdBranch(), branch.getDirection(), branch.getOpenHour(),
                branch.getCloseHour(), branch.getAttentionDays(), branch.getImage(), branch.getIdZone(),
                branch.getIdLocation(), branch.getIdBusiness(), branch.getCreateDate(), branch.getUpdateDate(),
                branch.getStatus());
        return branchDto;
    }
}
