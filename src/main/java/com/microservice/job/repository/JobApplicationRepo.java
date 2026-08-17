package com.microservice.job.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.job.model.JobApplication;

@Repository
public interface JobApplicationRepo extends MongoRepository<JobApplication,String>{
   List<JobApplication> findByJobId(String jobId);
}
