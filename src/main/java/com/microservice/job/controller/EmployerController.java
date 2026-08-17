package com.microservice.job.controller;

import java.util.List;

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

import com.microservice.job.model.ApplicantDetails;
import com.microservice.job.model.Interview;
import com.microservice.job.model.InterviewDetails;
import com.microservice.job.model.JobPostRequest;
import com.microservice.job.service.EmployerService;

@RestController
public class EmployerController {

	@Autowired
	EmployerService employerService;
	
	@PostMapping(value="/create/newJob")
	public ResponseEntity<String> postNewJob(@RequestBody JobPostRequest jobPostRequest) {		
		try {
			return new ResponseEntity<String>(employerService.postJob(jobPostRequest),HttpStatus.OK);
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}
	}
	
	@GetMapping(value="/job/{username}")
	public ResponseEntity<List<JobPostRequest>> getEmployerJobs(@PathVariable("username") String userName){
		try {
			return new ResponseEntity<>(employerService.getJobsPosted(userName),HttpStatus.OK);
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}				
	}
	
	@GetMapping(value="/get/applicant/details")
	public ResponseEntity<List<ApplicantDetails>> jobApplicants(@RequestParam("jobId") String jobId){		
		try {
			return new ResponseEntity<>(employerService.getApplicantDetails(jobId),HttpStatus.OK);
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}
	}
	
	@PostMapping(value="/schedule/interview")
	public ResponseEntity<String> scheduleInterview(@RequestBody Interview interviewDetails){
		
		try {
			return new ResponseEntity<>(employerService.scheduleCandidateInterview(interviewDetails),HttpStatus.OK);
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}
	}
	
	
	
}
