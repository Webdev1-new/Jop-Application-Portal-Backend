package com.microservice.job.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.job.model.Interview;


@Repository
public interface InterviewRepository extends MongoRepository<Interview,String>{
   
}
