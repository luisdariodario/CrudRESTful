package com.example.crud.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Nationality {
	private int nationalityId;
	private List<Country> countries;
}
