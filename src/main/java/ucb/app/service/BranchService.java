package ucb.app.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ucb.app.dto.BranchDto;
import ucb.app.dto.BranchLocationDto;
import ucb.app.model.Branch;
import ucb.app.repository.BranchRepository;

@Service
public class BranchService {
    private BranchRepository branchRepository;
    private FileService fileService;

    @Autowired
    public BranchService(BranchRepository branchRepository, FileService fileService) {
        this.branchRepository = branchRepository;
        this.fileService = fileService;
    }

    public List<BranchDto> findAllDto() {
        return branchRepository.findAll().stream().map(this::branchToBranchDto).collect(Collectors.toList());
    }

    public List<BranchLocationDto> findAllWithLocationDto() {
        return branchRepository.findAll().stream().map(this::branchToBranchLocationDto).collect(Collectors.toList());
    }

    public BranchDto findByIdDto(Integer branchId) throws Exception {
        return branchRepository.findById(branchId).stream().map(this::branchToBranchDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find branch"));
    }

    public List<BranchDto> findAllByBusinessIdDto(Integer businessId) {
        return branchRepository.findByIdBusiness(businessId).stream().map(this::branchToBranchDto)
                .collect(Collectors.toList());
    }

    public BranchDto saveDto(String address, Date openHour, Date closeHour, String attentionDays, MultipartFile image,
            int idZone, int idLocation, int idBusiness, int status) {
        String imageName = fileService.uploadFile(image);
        Branch branch = new Branch();
        branch.setAddress(address);
        branch.setOpenHour(openHour);
        branch.setCloseHour(closeHour);
        branch.setAttentionDays(attentionDays);
        branch.setImage(imageName);
        branch.setIdZone(idZone);
        branch.setIdLocation(idLocation);
        branch.setIdBusiness(idBusiness);
        // branch.setCreateDate(createDate);
        // branch.setUpdateDate(updateDate);
        branch.setStatus(status);
        Branch response = branchRepository.save(branch);
        return branchToBranchDto(response);
    }

    public BranchDto updateDto(Integer branchId, String address, Date openHour, Date closeHour, String attentionDays,
            MultipartFile image,
            int idZone, int idLocation, int idBusiness, int status) {
        String imageName = fileService.uploadFile(image);
        Branch branch = new Branch();
        branch.setAddress(address);
        branch.setOpenHour(openHour);
        branch.setCloseHour(closeHour);
        branch.setAttentionDays(attentionDays);
        branch.setImage(imageName);
        branch.setIdZone(idZone);
        branch.setIdLocation(idLocation);
        branch.setIdBusiness(idBusiness);
        // branch.setCreateDate(createDate);
        // branch.setUpdateDate(updateDate);
        branch.setStatus(status);

        Branch branchFound = branchRepository.getReferenceById(branchId);
        branchFound.setAddress(branch.getAddress());
        branchFound.setOpenHour(branch.getOpenHour());
        branchFound.setCloseHour(branch.getCloseHour());
        branchFound.setAttentionDays(branch.getAttentionDays());
        branchFound.setImage(branch.getImage());
        branchFound.setIdZone(branch.getIdZone());
        branchFound.setIdLocation(branch.getIdLocation());
        branchFound.setIdBusiness(branch.getIdBusiness());
        // branchFound.setCreateDate(branch.getCreateDate());
        // branchFound.setUpdateDate(branch.getUpdateDate());
        branchFound.setStatus(branch.getStatus());
        Branch response = branchRepository.save(branchFound);
        return branchToBranchDto(response);
    }

    public BranchDto deleteByIdDto(Integer branchId) {
        Branch branchFound = branchRepository.getReferenceById(branchId);
        branchFound.setStatus(branchFound.getStatus() < 1 ? 1 : 0);
        Branch response = branchRepository.save(branchFound);
        return branchToBranchDto(response);
    }

    private BranchDto branchToBranchDto(Branch branch) {
        BranchDto branchDto = new BranchDto(branch.getIdBranch(), branch.getAddress(), branch.getOpenHour(),
                branch.getCloseHour(), branch.getAttentionDays(), branch.getImage(), branch.getIdZone(),
                branch.getIdLocation(), branch.getIdBusiness(), branch.getCreateDate(), branch.getUpdateDate(),
                branch.getStatus());
        return branchDto;
    }

    private BranchLocationDto branchToBranchLocationDto(Branch branch) {
        BranchLocationDto branchLocationDto = new BranchLocationDto(branch.getIdBranch(), branch.getAddress(),
                branch.getOpenHour(),
                branch.getCloseHour(), branch.getAttentionDays(), branch.getImage(), branch.getIdZone(),
                branch.getIdBusiness(), branch.getCreateDate(), branch.getUpdateDate(),
                branch.getStatus(), branch.getLocation().getLatitude(), branch.getLocation().getLongitude(),
                branch.getBusiness().getName(), branch.getBusiness().getTypeBusiness().getName());
        return branchLocationDto;
    }

}
