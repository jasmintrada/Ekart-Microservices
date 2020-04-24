package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EkartProductRatingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartProductRatingsApplication.class, args);
	}

}
