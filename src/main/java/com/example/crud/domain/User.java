package com.example.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private int userId;
	private String name;
	private String password;
}
