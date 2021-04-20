package com.example.crud.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.crud.domain.Address;
import com.example.crud.domain.Country;
import com.example.crud.domain.Customer;
import com.example.crud.domain.Nationality;
import com.example.crud.domain.State;
import com.example.crud.domain.User;

import lombok.Data;

@Data
@Component
public class DataBase {
	private Map<Integer, State> states;
	private Map<Integer, Country> contries;
	private Map<Integer, Address> addresses;
	private Map<Integer, User> users;
	private Map<Integer, Nationality> nationalities;
	private Map<Integer, Customer> customers;
	private int userSequence;

	public DataBase() {
		init();
	}

	private void init() {

		contries = new HashMap<>();
		contries.put(1, new Country(1, "Mexico"));
		contries.put(2, new Country(2, "Estados Unidos"));

		states = new HashMap<>();
		states.put(1, new State(1, contries.get(1), "Ciudad de Mexico"));
		states.put(2, new State(2, contries.get(1), "Queretaro"));
		states.put(3, new State(3, contries.get(1), "Puebla"));

		addresses = new HashMap<>();
		addresses.put(1, new Address(1, states.get(1), "Avenida mexico", "Colonia verde", "Cuauhtemoc"));
		addresses.put(2, new Address(1, states.get(2), "Avenida por ahi", "Colonia azul", "Cayetano Rubio"));

		users = new HashMap<>();
		users.put(1, new User(nextUserSequence(), "usr001", "pass1"));
		users.put(2, new User(nextUserSequence(), "usr002", "pass2"));

		nationalities = new HashMap<>();
		nationalities.put(1, new Nationality(1, Arrays.asList(contries.get(1))));
		nationalities.put(2, new Nationality(2, Arrays.asList(contries.get(1), contries.get(2))));

		customers = new HashMap<>();
		customers.put(1, new Customer(1, 1, contries.get(1), 1, addresses.get(1), "Nombre1", "Apellido1", "curp1",
				"rfc1", 'm', 1, nationalities.get(1)));
		customers.put(2, new Customer(2, 1, contries.get(1), 2, addresses.get(2), "Nombre2", "Apellido2", "curp2",
				"rfc2", 'f', 2, nationalities.get(2)));

	}

	public int nextUserSequence() {
		return ++userSequence;
	}
}
