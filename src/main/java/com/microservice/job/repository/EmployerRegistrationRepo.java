package com.microservice.job.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.job.model.EmployeeRegistrationRequest;

@Repository
public interface EmployerRegistrationRepo extends MongoRepository<EmployeeRegistrationRequest,String>{

	Optional<EmployeeRegistrationRequest> findByUsername(String username);
}
