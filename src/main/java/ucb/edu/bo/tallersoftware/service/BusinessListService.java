package ucb.edu.bo.tallersoftware.service;

import ucb.edu.bo.tallersoftware.model.BusinessList;

import java.util.List;

public interface BusinessListService {
    BusinessList updateBusiness(BusinessList business, Integer businessId);
    BusinessList findAdminBusinessById(Integer businessId);
    List<BusinessList> findAll();
}

