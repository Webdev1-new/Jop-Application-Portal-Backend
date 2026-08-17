package com.microservice.job.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.microservice.job.model.EmployeeRegistrationRequest;
import com.microservice.job.model.JobSeekerRegistrationRequest;
import com.microservice.job.model.LoginRequest;
import com.microservice.job.service.AuthService;

@RestController
public class AuthController {
	
	
	Logger logger = LoggerFactory.getLogger(AuthController.class);

   @Autowired
   AuthService authservice;
   
   @PostMapping(value="/signin")	
   public Object signIn(@RequestBody LoginRequest loginRequest) {
	   System.out.println("Inside signin method");
	   logger.debug("Inside signin method");
	   
	   try {
		   return new ResponseEntity<>(authservice.signIn(loginRequest),HttpStatus.OK);
	   }catch(Exception ex) {
		   throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
	   }
   }
   
   @PostMapping(value="/register")
   public void registerEmployer(@RequestBody EmployeeRegistrationRequest employeeRegistrationRequest) {
	   try {
		   authservice.registerEmployer(employeeRegistrationRequest); 
	   }catch(Exception ex) {
		   throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
	   }
   }
   
   @PostMapping(value="/register/applicant")
   public void registerApplicant(@RequestBody JobSeekerRegistrationRequest jobSeekerRegistrationRequest) {
	   
	   try {
		   authservice.registerApplicant(jobSeekerRegistrationRequest); 
	   }catch(Exception ex) {
		  throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage()) ; 
	   }
   }
   
   
}
