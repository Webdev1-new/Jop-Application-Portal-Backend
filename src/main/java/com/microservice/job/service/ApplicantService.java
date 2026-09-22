package com.microservice.job.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.microservice.job.model.JobApplication;
import com.microservice.job.model.JobPostRequest;
import com.microservice.job.repository.InterviewRepository;
import com.microservice.job.repository.JobApplicationRepo;
import com.microservice.job.repository.JobPostingRepository;

@Service
public class ApplicantService {

	@Autowired
	JobPostingRepository jobPostingRepository;
	
	@Autowired
	JobApplicationRepo jobApplicationRepo;
	
	@Autowired
	InterviewRepository interviewRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<JobPostRequest> getAllJobs() {		
		List<JobPostRequest> jobs = jobPostingRepository.findAll();		
		if(CollectionUtils.isEmpty(jobs)) {
			return new ArrayList<>();
		}else {
			return jobs;
		}		
	}
	
	public JobPostRequest getJob(String jobId) {		  
		Optional<JobPostRequest> jobPostRequest	= jobPostingRepository.findById(jobId);	
		if(jobPostRequest.isPresent()) {
			return jobPostRequest.get();
		}else {
			throw new RuntimeException("No jobs found with id");
		}		
	}
	
	
	public String applyForJob(JobApplication jobApplication) {		
		if(null!=jobApplication) {
			jobApplicationRepo.save(jobApplication);
			return "Job Applied Successfully";
		}else {
			throw new RuntimeException("Error while job application");
		}
	}
	
	
	public List<JobPostRequest> searchSpecificJob(String company , String technology , String experience) {
		
		Query query = new Query();			
		if(StringUtils.hasText(company)) {
			query.addCriteria(Criteria.where("companyName").regex(company, "i"));
		}		
		if(StringUtils.hasText(technology)) {
			query.addCriteria(Criteria.where("skills").regex(technology, "i"));
		}
		if(StringUtils.hasText(experience)) {
			query.addCriteria(Criteria.where("experience").regex(experience, "i"));
		}				
	   try {
		   
		  long totalNoOfPages = mongoTemplate.count(query, JobPostRequest.class);		  
		  List<JobPostRequest>	lists = mongoTemplate.find(query, JobPostRequest.class,"jobs");		                               
		  if(CollectionUtils.isEmpty(lists)) {
			  return new ArrayList<>();
		  }else {
			  return lists;
		  }
	   }catch(Exception ex) {
		  ex.printStackTrace();
		  throw new RuntimeException("Exception while fetching jobs");
	   }	  		
	}
	
	 //Paginated version of above code
     public Page<JobPostRequest> searchSpecificJobs(String company , String technology , String experience,
    		 int pageNo, int pageSize) {
		
		Query query = new Query();			
		if(StringUtils.hasText(company)) {
			query.addCriteria(Criteria.where("companyName").regex(company, "i"));
		}		
		if(StringUtils.hasText(technology)) {
			query.addCriteria(Criteria.where("skills").regex(technology, "i"));
		}
		if(StringUtils.hasText(experience)) {
			query.addCriteria(Criteria.where("experience").regex(experience, "i"));
		}
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
	   try {
		  long totalCount  = mongoTemplate.count(query, JobPostRequest.class,"jobs"); 
		  query.with(pageable);
		  List<JobPostRequest>	lists = mongoTemplate.find(query, JobPostRequest.class,"jobs");		                               
		  if(CollectionUtils.isEmpty(lists)) {
			  throw new RuntimeException("No data matched your search result");
		  }else {
			  return new PageImpl<>(lists,pageable,totalCount);
		  }
	   }catch(Exception ex) {
		  //ex.printStackTrace();
		  throw new RuntimeException("Exception while fetching jobs",ex);
	   }	  		
	}
     
     
     public List<JobApplication> getApplicationDetails(String username) {
    	 
    	 Pageable pageable =  PageRequest.of(1, 5,Sort.by(Sort.Direction.DESC,"jobApplicationadate"));   	 
    	 Page<JobApplication> application = jobApplicationRepo.findByUsername(username,pageable);
    	 
    	 return application.getContent();
    	 
     }
}
