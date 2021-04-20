package com.example.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private int userId;
	private int countryId;
	private Country country;
	private int addressId;
	private Address address;
	private String first_name;
	private String last_name;
	private String curp;
	private String rfc;
	private char gener;
	private int nationalityId;
	private Nationality nationality;
}
