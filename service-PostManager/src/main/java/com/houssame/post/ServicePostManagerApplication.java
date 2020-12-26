package com.houssame.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicePostManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePostManagerApplication.class, args);
	}

}
