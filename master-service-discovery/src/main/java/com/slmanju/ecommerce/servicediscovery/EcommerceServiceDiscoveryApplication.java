package com.slmanju.ecommerce.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EcommerceServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceServiceDiscoveryApplication.class, args);
	}

}
