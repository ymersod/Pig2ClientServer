package com.registerservice;

import com.persistence.DatabaseAccess;
import com.persistence.RegisterDataAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RegisterServiceApplication {
	public static void main(String... args) {
		SpringApplication.run(RegisterServiceApplication.class, args);
	}

	@Bean
	public RegisterDataAccess registerDataAccess() {
		return new DatabaseAccess();
	}
}
