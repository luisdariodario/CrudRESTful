package com.example.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Country {
	private int countryId;
	private String name;
}
