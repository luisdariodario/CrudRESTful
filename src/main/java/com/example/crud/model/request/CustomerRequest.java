package com.example.crud.model.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomerRequest {
	
	@NotNull
	private CustomerProfile customerProfile;

}
