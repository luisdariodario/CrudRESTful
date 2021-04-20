package com.example.crud.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dao.CustomerDao;
import com.example.crud.domain.Customer;
import com.example.crud.exception.NotFoundException;
import com.example.crud.model.request.CustomerProfile;
import com.example.crud.model.response.CustomerResponse;
import com.example.crud.model.response.AllCustomersResponse;
import com.example.crud.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	private com.example.crud.model.response.Customer mapDomainToModel(Customer customer) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(customer, com.example.crud.model.response.Customer.class);
	}

	@Override
	public AllCustomersResponse getCustomers() {

		List<Customer> customers = customerDao.findAll();
		if (customers.isEmpty()) {
			throw new NotFoundException("No hay clientes registrados");
		}

		AllCustomersResponse response = new AllCustomersResponse();
		response.setCustomers(customerDao.findAll().stream().map(this::mapDomainToModel).collect(Collectors.toList()));
		log.debug("Response [{}].", response);

		return response;
	}

	public CustomerResponse get(int userId) {

		log.debug("Request [userId={}].", userId);

		CustomerResponse response = new CustomerResponse();
		response.setCustomer(Optional.ofNullable(customerDao.findById(userId)).map(this::mapDomainToModel)
				.orElseThrow(() -> new NotFoundException("Cliente no encontrado.")));

		log.debug("Response [{}].", response);

		return response;
	}

	public void remove(int userId) {

		log.debug("Request [userId={}].", userId);

		int affectedRecords = customerDao.removeById(userId);
		if (affectedRecords != 1) {
			throw new NotFoundException("No se encuentra el cliente a eliminar.");
		}

	}

	public void updateRfc(int userId, String rfc) {

		log.debug("Request [userId={}, rfc={}].", userId, rfc);

		int affectedRecords = customerDao.updateRfc(userId, rfc);
		if (affectedRecords != 1) {
			throw new NotFoundException("No se encuentra el cliente a actualiar.");
		}
	}

	public void save(CustomerProfile customerProfile) {

		log.debug("Request [{}].", customerProfile);

		Customer customer = new Customer();
		BeanUtils.copyProperties(customerProfile, customer);
		customerDao.save(customer);
	}

}
