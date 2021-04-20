package com.example.crud.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CustomerRfcOnlyRequest {

	@NotBlank
	@Pattern(regexp = "[a-zA-Z]{4}\\d{6}(\\w{3})?", message = "RFC invalido.")
	private String rfc;

}
