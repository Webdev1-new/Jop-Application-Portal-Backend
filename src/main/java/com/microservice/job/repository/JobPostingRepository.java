package com.microservice.job.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.job.model.JobPostRequest;

@Repository
public interface JobPostingRepository extends MongoRepository<JobPostRequest,String>{
	List<JobPostRequest> findByJobPostedBy(String postedBy);
}
