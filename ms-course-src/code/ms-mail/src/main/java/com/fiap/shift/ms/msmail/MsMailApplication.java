package com.fiap.shift.ms.msmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMailApplication.class, args);
	}
}
