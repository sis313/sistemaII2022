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

    // GROUP 2 ROUTE
    public List<BusinessDto> findByStatusDto(Integer status) {
        return businessRepository.findByStatus(status).stream().map(this::businessToBusinessDto)
                .collect(Collectors.toList());
    }

    // GROUP 3 ROUTE
    public List<BusinessDto> findByNameDto(String name) {
        return businessRepository.findByName(name).stream().map(this::businessToBusinessDto)
                .collect(Collectors.toList());
    }

    // GROUP 3 ROUTE
    public List<BusinessDto> findByTypeDto(String type) {
        return businessRepository.findByType(type).stream().map(this::businessToBusinessDto)
                .collect(Collectors.toList());
    }

    // GROUP 3 ROUTE
    public List<BusinessDto> findByNameAndTypeDto(String name, String type) {
        return businessRepository.findByNameAndType(name, type).stream().map(this::businessToBusinessDto)
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

    public BusinessDto deleteByIdDto(Integer businessId) {
        Business businessFound = businessRepository.getReferenceById(businessId);
        businessFound.setStatus(businessFound.getStatus() < 1 ? 1 : 0);
        Business response = businessRepository.save(businessFound);
        return businessToBusinessDto(response);
    }

    private BusinessDto businessToBusinessDto(Business business) {
        BusinessDto businessDto = new BusinessDto(business.getIdBusiness(), business.getName(),
                business.getDescription(), business.getIdTypeBusiness(), business.getIdUser(), business.getCreateDate(),
                business.getUpdateDate(), business.getStatus());
        return businessDto;
    }
}
