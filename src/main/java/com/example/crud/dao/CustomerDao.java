package com.example.crud.dao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.crud.domain.Customer;
import com.example.crud.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomerDao {

	private DataBase dataBase;

	@Autowired
	public CustomerDao(DataBase dataBase) {
		this.dataBase = dataBase;
	}

	public List<Customer> findAll() {
		return dataBase.getCustomers().values().stream().collect(Collectors.toList());
	}

	public Customer findById(int customerId) {
		return dataBase.getCustomers().get(customerId);
	}

	public int removeById(int customerId) {
		Customer customer = dataBase.getCustomers().remove(customerId);
		int affectedRecords = 0;
		if (Objects.nonNull(customer)) {
			affectedRecords++;
		}
		log.debug("Se eliminaron {} clientes.", affectedRecords);
		return affectedRecords;
	}

	public int updateRfc(int userId, String rfc) {
		int affectedRecords = 0;
		Customer customer = dataBase.getCustomers().get(userId);
		if (Objects.nonNull(customer)) {
			customer.setRfc(rfc);
			affectedRecords++;
		}
		log.debug("Se actualizo el rfc {} del cliente {}.", rfc, userId);
		return affectedRecords;
	}

	public void save(Customer customer) {
		int userId = dataBase.nextUserSequence();
		dataBase.getUsers().put(userId, new User(userId, "usr00" + userId, "pass" + userId));
		customer.setUserId(userId);
		customer.setCountry(dataBase.getContries().get(customer.getCountryId()));
		customer.setNationality(dataBase.getNationalities().get(customer.getNationalityId()));
		log.debug("Registrando al cliente {}.", customer);
		dataBase.getCustomers().put(userId, customer);
	}

}
