package com.digrazia.FlightsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.digrazia.FlightsService.integration.database.repository")
@EntityScan(basePackages = "com.digrazia.FlightsService.integration.database.entity")
public class FlightsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsServiceApplication.class, args);
	}
}
