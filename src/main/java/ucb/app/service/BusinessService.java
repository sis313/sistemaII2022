package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.BusinessDto;
import ucb.app.model.Business;
import ucb.app.repository.BusinessRepository;

@Service
public class BusinessService {
    private BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public List<BusinessDto> findAllDto() {
        return businessRepository.findAll().stream().map(this::businessToBusinessDto).collect(Collectors.toList());
    }

    public BusinessDto findByIdDto(Integer businessId) throws Exception {
        return businessRepository.findById(businessId).stream().map(this::businessToBusinessDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find business"));
    }

    public List<BusinessDto> findByUserIdDto(Integer userId) {
        return businessRepository.findByIdUser(userId).stream().map(this::businessToBusinessDto)
                .collect(Collectors.toList());
    }

    public BusinessDto saveDto(Business business) {
        Business response = businessRepository.save(business);
        return businessToBusinessDto(response);
    }

    public BusinessDto updateDto(Integer businessId, Business business) {
        Business businessFound = businessRepository.getReferenceById(businessId);
        businessFound.setName(business.getName());
        businessFound.setDescription(business.getDescription());
        businessFound.setIdTypeBusiness(business.getIdTypeBusiness());
        businessFound.setCreateDate(business.getCreateDate());
        businessFound.setUpdateDate(business.getUpdateDate());
        businessFound.setIdUser(business.getIdUser());
        Business response = businessRepository.save(businessFound);
        return businessToBusinessDto(response);
    }

    public String deleteByIdDto(Integer businessId) {
        businessRepository.deleteById(businessId);
        return "Business deleted successfully";
    }

    private BusinessDto businessToBusinessDto(Business business) {
        BusinessDto businessDto = new BusinessDto(business.getIdBusiness(), business.getName(),
                business.getDescription(), business.getIdTypeBusiness(), business.getIdUser(), business.getCreateDate(),
                business.getUpdateDate(), business.getStatus());
        return businessDto;
    }
}
