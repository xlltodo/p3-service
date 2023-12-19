package com.p3.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class P3WmsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(P3WmsGatewayApplication.class, args);
	}

}
