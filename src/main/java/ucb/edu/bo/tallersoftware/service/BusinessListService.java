package ucb.edu.bo.tallersoftware.service;

import ucb.edu.bo.tallersoftware.model.BusinessList;

import java.util.List;

public interface BusinessListService {
    BusinessList updateBusiness(BusinessList business, Integer businessId);
    BusinessList findAdminBusinessById(Integer businessId);
    BusinessList DeleteBusinessById(Integer businessId);
    BusinessList updateBusinessStatus(BusinessList business, Integer businessId);
    List<BusinessList> findAll();
}

