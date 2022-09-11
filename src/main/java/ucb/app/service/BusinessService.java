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

    public Boolean saveDto(Business business) {
        return businessRepository.save(business).equals(business) ? true : false;
    }

    public Boolean updateDto(Integer businessId, Business business) {
        Business businessFound = businessRepository.getReferenceById(businessId);
        return businessRepository.save(businessFound).equals(business) ? true : false;
    }

    public String deleteByIdDto(Integer businessId) {
        businessRepository.deleteById(businessId);
        return "Business deleted successfully";
    }

    private BusinessDto businessToBusinessDto(Business business) {
        BusinessDto businessDto = new BusinessDto(business.getIdBusiness(), business.getName(),
                business.getDescription(), business.getIdTypeBusiness(), business.getCreateDate(),
                business.getUpdateDate(), business.getStatus(), business.getUserIdUser());
        return businessDto;
    }
}
