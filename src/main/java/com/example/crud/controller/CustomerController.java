package com.example.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.request.CustomerRequest;
import com.example.crud.model.request.CustomerRfcOnlyRequest;
import com.example.crud.model.response.AllCustomersResponse;
import com.example.crud.model.response.CustomerResponse;
import com.example.crud.service.CustomerService;

@RestController
@RequestMapping("/api")
@Validated
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customer")
	public ResponseEntity<AllCustomersResponse> getCustomers() {
		return ResponseEntity.ok(customerService.getCustomers());
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerResponse> getCustomer(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(customerService.get(id));
	}

	@DeleteMapping("/customer/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable(name = "id") int id) {
		customerService.remove(id);
	}

	@PostMapping("/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveCustomer(@Valid @RequestBody CustomerRequest requestCustomer) {
		customerService.save(requestCustomer.getCustomerProfile());
	}

	@PatchMapping("/customer/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateCurp(@PathVariable(name = "id") int id,
			@Valid @RequestBody CustomerRfcOnlyRequest customerRfcOnlyRequest) {
		customerService.updateRfc(id, customerRfcOnlyRequest.getRfc());
	}

}
