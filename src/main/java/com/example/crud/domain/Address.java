package com.example.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	private int addressId;
	private State state;
	private String street;
	private String suburb;
	private String province;
}
