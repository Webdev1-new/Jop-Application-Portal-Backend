package com.microservice.job.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.microservice.job.model.ApplicantDetails;
import com.microservice.job.model.Interview;
import com.microservice.job.model.InterviewDetails;
import com.microservice.job.model.JobApplication;
import com.microservice.job.model.JobPostRequest;
import com.microservice.job.model.JobSeekerRegistrationRequest;
import com.microservice.job.repository.InterviewRepository;
import com.microservice.job.repository.JobApplicationRepo;
import com.microservice.job.repository.JobPostingRepository;
import com.microservice.job.repository.JobSeekerRegistrationRepo;

@Service
public class EmployerService {

	@Autowired
	JobPostingRepository jobPostingRepository;
	
	@Autowired
	JobApplicationRepo jobApplicationRepo;
	
	@Autowired
	JobSeekerRegistrationRepo jobSeekerRegistrationRepo;
	
	@Autowired
	InterviewRepository interviewRepository;
	
	@Autowired
	KafkaTemplate<String,Interview> kafkaTemplate;
	
	public String postJob(JobPostRequest jobPostRequest) {
		
		if(null==jobPostRequest) {
			throw new RuntimeException("Error while posting jobs");
		}else {
			jobPostingRepository.save(jobPostRequest);
			return "job successfuly posted";
		}
	}
	
	public List<JobPostRequest> getJobsPosted(String username){
		
		List<JobPostRequest> jobPostRequest = jobPostingRepository.findByJobPostedBy(username);
		if(CollectionUtils.isEmpty(jobPostRequest)) {
			throw new RuntimeException("Exception occured");
		}else {
			return jobPostRequest;
		}
	}

	
	public List<ApplicantDetails> getApplicantDetails(String jobId) {	
		
		List<JobApplication> listApplicants = jobApplicationRepo.findByJobId(jobId);		
		List<ApplicantDetails> applicantDetails = new ArrayList<>();		
		listApplicants.stream()
		              .forEach((ob) -> {
		            	  JobSeekerRegistrationRequest  jobSeekerRegistrationRequest =  jobSeekerRegistrationRepo.findByUsername(ob.getUsername()).get();
		                   if(null!=jobSeekerRegistrationRequest) {
		                	   ApplicantDetails applicantdetails = new ApplicantDetails();
		                	   applicantdetails.setApplicationId(ob.getApplicationId());
		                	   applicantdetails.setName(jobSeekerRegistrationRequest.getUsername());
		                	   applicantdetails.setEmail(jobSeekerRegistrationRequest.getEmail());
		                	   applicantdetails.setResume(jobSeekerRegistrationRequest.getResume());
		                	   applicantdetails.setJobId(jobId);
		                	   applicantDetails.add(applicantdetails);
		                   }		            		  		            	  
		              });		
		return applicantDetails;
	    		              		
	}
	
	public String scheduleCandidateInterview(Interview interviewDetails) {		
		  if(null!=interviewDetails) {
			  Interview interview = interviewRepository.save(interviewDetails);
				//sendNotification(interview) ;
				return "interview scheduled successfully";						  			  
		  }else {
			  throw new RuntimeException("Exception occured while scheduling interview");
		  }
		
	}
	
	/*
	 * public String updateCandidateInterview(InterviewDetails interviewDetails) {
	 * 
	 * if(null!=interviewDetails) {
	 * 
	 * }else {
	 * 
	 * } }
	 */
	
	public void sendNotification(Interview interviewDetails) {		
		CompletableFuture<SendResult<String,Interview>> completableFututre = kafkaTemplate.send("kafkademo", interviewDetails);		
		completableFututre.whenComplete((rexponse,ex)->{
			if(ex==null) {				
				System.out.println("Successfully send message to consumer");
			}else {
				System.out.println("Exception happened while sending message");
			}
		});
	}
	
	
}
