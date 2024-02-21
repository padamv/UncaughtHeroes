package com.npe.pet.uncaughtHeroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateway {
	// TODO: Implement actuator and use that to check for the health of the service
	public static void main(String... args) {
		SpringApplication.run(ApiGateway.class, args);
	}

}
