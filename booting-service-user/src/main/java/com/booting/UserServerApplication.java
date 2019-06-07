package com.booting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}
}
