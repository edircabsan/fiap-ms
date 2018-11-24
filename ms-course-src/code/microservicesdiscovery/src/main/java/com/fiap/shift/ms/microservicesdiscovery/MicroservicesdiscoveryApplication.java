package com.fiap.shift.ms.microservicesdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservicesdiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesdiscoveryApplication.class, args);
	}
}
