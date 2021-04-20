package com.example.crud.service;

import com.example.crud.domain.Customer;
import com.example.crud.model.request.CustomerProfile;
import com.example.crud.model.response.CustomerResponse;
import com.example.crud.model.response.AllCustomersResponse;

public interface CustomerService {
	
	AllCustomersResponse getCustomers();
	
	CustomerResponse get(int customerId);
	
	void remove(int userId);
	
	public void updateRfc(int customerId, String rfc);
	
	void save(CustomerProfile customerProfile);

}
