package com.nevexis.jtdemo.drivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DriversApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriversApplication.class, args);
	}
}
