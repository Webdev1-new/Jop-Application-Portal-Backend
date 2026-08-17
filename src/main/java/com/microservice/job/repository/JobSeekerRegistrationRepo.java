package com.microservice.job.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.job.model.EmployeeRegistrationRequest;
import com.microservice.job.model.JobApplication;
import com.microservice.job.model.JobSeekerRegistrationRequest;

@Repository
public interface JobSeekerRegistrationRepo extends MongoRepository<JobSeekerRegistrationRequest,String>{

	Optional<JobSeekerRegistrationRequest> findByUsername(String username);
}
