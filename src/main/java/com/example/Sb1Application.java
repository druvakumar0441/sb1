package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "My API", version = "1.0.0"))

@SpringBootApplication
public class Sb1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb1Application.class, args);
	}

}
