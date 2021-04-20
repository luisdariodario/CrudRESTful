package com.example.crud.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private int userId;
	private Country country;
	private Address address;
	private String first_name;
	private String last_name;
	private String curp;
	private String rfc;
	private char gener;
	private Nationality nationality;
}
