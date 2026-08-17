package com.microservice.job.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.microservice.job.model.JobPostRequest;
import com.microservice.job.model.JobRecommened;
import com.microservice.job.repository.JobPostingRepository;

@Service
public class DashboardService {

	
	@Autowired
	JobPostingRepository jobPostingRepository;
	
	public List<JobRecommened> getRecommendedJobs() {
		
		Pageable pageable = PageRequest.of(0,5,Sort.by("jobPostedDate").descending());		
		Page<JobPostRequest> jobPostingRequest = jobPostingRepository.findAll(pageable);		
		if(jobPostingRequest.isEmpty()) {
			return new ArrayList<>();
		}else {
			List<JobPostRequest> jobRequest = jobPostingRequest.getContent();			
			List<JobRecommened> recoomendedJobs = jobRequest.stream()
			          .map(this::convertToDTO)
			          .collect(Collectors.toList());			
			return recoomendedJobs;
		}
				
	}
	
	public JobRecommened convertToDTO(JobPostRequest jobRequest) {		
		JobRecommened jobRecommened = new JobRecommened();
		jobRecommened.setCompanyName(jobRequest.getCompanyName());
		jobRecommened.setJobDescription(jobRequest.getJobDescription());
		jobRecommened.setJobTitle(jobRequest.getJobTitle());
		jobRecommened.setLocation(jobRequest.getLocation());
		jobRecommened.setSkills(jobRequest.getSkills());
		jobRecommened.setExperience(jobRequest.getExperience());		
		jobRecommened.setPostedAt(getJobPostedDate(jobRequest.getJobPostedDate()));
		return jobRecommened;				
	}
	
	public  String getJobPostedDate(LocalDateTime jobPostedDate) {		
		 long months =   ChronoUnit.MONTHS.between(jobPostedDate, LocalDateTime.now());		 
		 if(months>0) {
			 return String.valueOf(months);
		 }else if(ChronoUnit.DAYS.between(jobPostedDate, LocalDateTime.now())> 0) {			 
			 return String.valueOf(ChronoUnit.DAYS.between(jobPostedDate, LocalDateTime.now())) + "days ago";
		 }else if(ChronoUnit.HOURS.between(jobPostedDate, LocalDateTime.now())>0) {
			 return String.valueOf(ChronoUnit.HOURS.between(jobPostedDate, LocalDateTime.now())) + "hours ago";
		 }else if(ChronoUnit.MINUTES.between(jobPostedDate, LocalDateTime.now())>0) {
			 return String.valueOf(ChronoUnit.MINUTES.between(jobPostedDate, LocalDateTime.now())) + "minutes ago";
		 }else {
			 return "now";
		 }
		 		
	}
}
