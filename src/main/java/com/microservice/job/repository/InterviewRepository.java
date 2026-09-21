package com.microservice.job.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.job.model.Interview;
import com.microservice.job.model.InterviewDetails;


@Repository
public interface InterviewRepository extends MongoRepository<Interview,String>{
	
	Optional<InterviewDetails> findByApplicationIdAndJobId(String applicationId , String jobId);

}
