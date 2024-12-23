package com.sst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("demo")
public class SstServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SstServicesApplication.class, args);
	}
}