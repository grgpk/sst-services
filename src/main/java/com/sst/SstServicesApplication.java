package com.sst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.sst.sst_models")
@EnableAspectJAutoProxy
@EnableScheduling
public class SstServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SstServicesApplication.class, args);
	}

}
