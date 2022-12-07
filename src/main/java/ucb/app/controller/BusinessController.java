package ucb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import ucb.app.dto.BusinessDto;
import ucb.app.service.BusinessService;

@RestController
@RequestMapping("api/business")
public class BusinessController {
    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping
    public ResponseEntity<List<BusinessDto>> getBusinesses() {
        List<BusinessDto> businesses = businessService.findAllDto();
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    @GetMapping(path = "/{businessId}")
    public ResponseEntity<BusinessDto> getBusinessById(@PathVariable("businessId") Integer businessId)
            throws Exception {
        BusinessDto business = businessService.findByIdDto(businessId);
        return new ResponseEntity<>(business, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<BusinessDto>> getBusinessByUserId(@RequestParam("userId") Integer userId) {
        List<BusinessDto> businesses = businessService.findByUserIdDto(userId);
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    // GROUP 2 ROUTE
    @GetMapping(path = "/status={status}")
    public ResponseEntity<List<BusinessDto>> getBusinessByStatus(@PathVariable("status") Integer status) {
        List<BusinessDto> businesses = businessService.findByStatusDto(status);
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    // GROUP 3 ROUTE
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<BusinessDto>> getBusinessByName(@PathVariable("name") String name) {
        List<BusinessDto> businesses = businessService.findByNameDto(name);
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    // GROUP 3 ROUTE
    @GetMapping(path = "/Type/{name}")
    public ResponseEntity<List<BusinessDto>> getBusinessByType(@PathVariable("name") String name) {
        List<BusinessDto> businesses = businessService.findByTypeDto(name);
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    // GROUP 3 ROUTE
    @GetMapping(path = "/filter/{type_name}/{business_name}")
    public ResponseEntity<List<BusinessDto>> getBusinessByNameAndType(
            @PathVariable("business_name") String business_name, @PathVariable("type_name") String type_name) {
        List<BusinessDto> businesses = businessService.findByNameAndTypeDto(business_name, type_name);
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BusinessDto> postBusiness(@RequestBody BusinessDto businessDto) {
        BusinessDto response = businessService.saveDto(businessDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{businessId}")
    public ResponseEntity<BusinessDto> putBusiness(@PathVariable("businessId") Integer businessId,
            @RequestBody BusinessDto businessDto) {
        BusinessDto response = businessService.updateDto(businessId, businessDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{businessId}")
    public ResponseEntity<BusinessDto> deleteBusiness(@PathVariable("businessId") Integer businessId) {
        BusinessDto response = businessService.deleteByIdDto(businessId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
