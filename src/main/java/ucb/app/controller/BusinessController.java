package ucb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.app.dto.BusinessDto;
import ucb.app.model.Business;
import ucb.app.service.BusinessService;

@CrossOrigin
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

    @PostMapping
    public ResponseEntity<BusinessDto> postBusiness(@RequestBody Business business) {
        BusinessDto response = businessService.saveDto(business);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{businessId}")
    public ResponseEntity<BusinessDto> putBusiness(@PathVariable("businessId") Integer businessId,
            @RequestBody Business business) {
        BusinessDto response = businessService.updateDto(businessId, business);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{businessId}")
    public ResponseEntity<String> deleteBusiness(@PathVariable("businessId") Integer businessId) {
        String response = businessService.deleteByIdDto(businessId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
