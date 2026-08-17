package com.microservice.job.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.job.model.EmployeeRegistrationRequest;
import com.microservice.job.model.JobSeekerRegistrationRequest;
import com.microservice.job.model.LoginRequest;
import com.microservice.job.model.LoginResponse;
import com.microservice.job.repository.EmployerRegistrationRepo;
import com.microservice.job.repository.JobSeekerRegistrationRepo;

@Service
public class AuthService {

	@Autowired
	EmployerRegistrationRepo employerRegistrationRepo;
	
	@Autowired
	JobSeekerRegistrationRepo jobSeekerRegistrationRepo;
	
	public String registerEmployer(EmployeeRegistrationRequest employerRegistrationRequest) {
		
	   if(null!=employerRegistrationRequest)	{
		   System.out.println("Employer Registration  " + employerRegistrationRequest.getEmployerId() + " "+ employerRegistrationRequest.getUsername());
		   System.out.println(employerRegistrationRepo.save(employerRegistrationRequest).getUsername()) ;
		   return " User successfully registered";
	   }else {
		   throw new RuntimeException("Exception while registration");
	   }
		
	}
	
	public String registerApplicant(JobSeekerRegistrationRequest jobSeekerRegistrationRequest) {
				
		if(null!=jobSeekerRegistrationRequest)	{
			jobSeekerRegistrationRepo.save(jobSeekerRegistrationRequest) ;
			return "User successfully registered";
		 }else {
			   throw new RuntimeException("Exception while registration");
		 }
			
	}
	
	public LoginResponse signIn(LoginRequest loginRequest){		
		Optional<EmployeeRegistrationRequest> opts = employerRegistrationRepo.findByUsername(loginRequest.getUsername());
		Optional<JobSeekerRegistrationRequest> oppts = jobSeekerRegistrationRepo.findByUsername(loginRequest.getUsername());		
		if(opts.isEmpty() && oppts.isEmpty()) {		
			throw new RuntimeException("Please enter valid credentials");			
		}else if(opts.isPresent() && opts.get().getPassword().equalsIgnoreCase(loginRequest.getPassword())) {
			return new LoginResponse(loginRequest.getUsername(),"Employer");
		}else if(oppts.isPresent() && oppts.get().getPassword().equalsIgnoreCase(loginRequest.getPassword())) {
			return new LoginResponse(loginRequest.getUsername(),"Applicant");
		}else {
			throw new RuntimeException("Please enter valid credentials");
		}
	}
}
