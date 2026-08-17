package com.microservice.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
public class AdminController {
  
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Value("${spring.mongodb.uri}")
	private String mongoUri;
	
	
	@PostConstruct
	public void testConnection() {
	    System.out.println("Database Name: " + mongoTemplate.getDb().getName());
	    System.out.println("uri name " + mongoUri);
	}
}
