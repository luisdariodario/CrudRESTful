package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.crud")
public class CrudResTfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudResTfulApplication.class, args);
	}

}
