package com.microservice.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.microservice.job.service.DashboardService;

@RestController
public class DashboardController {
		
   @Autowired
   DashboardService dashboardService;
	
   @GetMapping(value="/get/latest/jobs")
   public Object getLatestJobs() {
		
	   try {
		  return new ResponseEntity<>(dashboardService.getRecommendedJobs(),HttpStatus.OK);  
	   }catch(Exception ex) {
		  throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage()) ;
	   }
	   
  
   }
}
