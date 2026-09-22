package com.microservice.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.microservice.job.model.JobApplication;
import com.microservice.job.service.ApplicantService;

@RestController
public class ApplicantController {

	@Autowired
	ApplicantService applicantService;
	
	@GetMapping(value="/get/jobs")
	public Object getAllJobs() {	
		try {
			return new ResponseEntity<>(applicantService.getAllJobs(),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}		
	}
		
	@GetMapping(value="/get/jobss")
	public Object getSpecificJob(@RequestParam("jobId") String jobIds) {		
		try {
			return new ResponseEntity<>(applicantService.getJob(jobIds),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}
	}
	
	@PostMapping(value="/applyForSpecificJob")
	public Object applyForJob(@RequestBody JobApplication jobApplication) {
		
		try {
			return new ResponseEntity<>(applicantService.applyForJob(jobApplication),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}
		
	}
	
	@GetMapping(value="/search/jobs")
	public Object searchSpecificJob(@RequestParam(value = "company" , required = false) String company , @RequestParam(value="technology" , required = false) String technology,
			@RequestParam(value = "experience" , required = false) String experience) {
		
		try {
			System.out.println(company + "::"+ technology + "::" + experience);
			return new ResponseEntity<>(applicantService.searchSpecificJob(company, technology, experience),HttpStatus.OK);
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}
				
	}
	
	@GetMapping(value="/get/applicants/details")
	public Object getApplicationDetails(@PathVariable("username") String username) {
		
		
		
	}
}
