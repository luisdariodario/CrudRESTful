package com.example.crud.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomerProfile {
	@NotNull
	private int userId;
	@NotNull
	private int countryId;
	@NotBlank
	private String first_name;
	@NotBlank
	private String last_name;
	@NotBlank
	private String curp;
	@NotBlank
	private String rfc;
	private char gener;
	@NotNull
	private int nationalityId;
}
