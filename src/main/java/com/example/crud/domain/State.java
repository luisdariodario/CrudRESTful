package com.example.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class State {
	private int stateId;
	private Country country;
	private String name;
}
