package com.microservice.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.microservice.job.model.CandidateFeedbackDTO;
import com.microservice.job.service.CandidateInterviewFeedbackService;

@RestController
public class InterviewController {
   
	
	@Autowired
	CandidateInterviewFeedbackService candidateInterviewFeedbackService;
	
	@PostMapping(value="/interview/feedback")
	public Object interviewFeedabck(@RequestBody CandidateFeedbackDTO candidateFeedbackDTO
			,@RequestParam("feedbackby") String feedbackBy) {
		
		try {
			candidateInterviewFeedbackService.saveCandidateInterviewFeedback(candidateFeedbackDTO
					,feedbackBy);
			return new ResponseEntity<>("Feedback submitted successfully", HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured while processing request");
		}
		
		
		
	}
}
