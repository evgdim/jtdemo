package com.nevexis.jtdemo.passengers.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nevexis.jtdemo.passengers.domain.Driver;

@RestController
@RequestMapping("/home")
public class HomeController {
	private DiscoveryClient discoveryClient;
	private RestTemplate restTemplate;
	@Autowired
	public HomeController(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
		this.discoveryClient = discoveryClient;
		this.restTemplate = restTemplate;
	}
	@GetMapping("/drivers")
	public Driver[] getAllDrivers(){
		URI driversUri = this.discoveryClient.getInstances("drivers").get(0).getUri();
		
		ResponseEntity<Driver[]> messageResponse = 
				this.restTemplate.exchange(driversUri.toString()+"/custom/drivers",HttpMethod.GET, null, Driver[].class);
		
		return messageResponse.getBody();
	}
}
