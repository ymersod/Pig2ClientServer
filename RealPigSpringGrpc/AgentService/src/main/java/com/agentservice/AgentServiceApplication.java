package com.agentservice;

import com.persistence.AgentDataAccess;
import com.persistence.DatabaseAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgentServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgentServiceApplication.class, args);
	}

	@Bean
	public AgentDataAccess agentDataAccess() {
		return new DatabaseAccess();
	}
}