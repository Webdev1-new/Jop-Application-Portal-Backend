package com.microservice.job.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.job.model.CandidateInterviewFeedback;

@Repository
public interface InterviewFeedbackRepository extends MongoRepository<CandidateInterviewFeedback,String>{

	Optional<CandidateInterviewFeedback> findByApplicationIdAndJobId(String applicationId,String jobId);
}
