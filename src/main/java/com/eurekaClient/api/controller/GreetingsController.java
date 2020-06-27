package com.eurekaClient.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class GreetingsController {


	@Autowired
	EurekaClient eurekaClient;
	
	@Value("${spring.application.name}")
    private String appName;
	
	@GetMapping("/message")
	String message() {
		 return "Hello from "+ eurekaClient.getApplication(appName).getName()+"!";
	}
}
