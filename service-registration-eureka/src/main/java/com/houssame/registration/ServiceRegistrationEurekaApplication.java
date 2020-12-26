package com.houssame.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistrationEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistrationEurekaApplication.class, args);
	}

}
