package com.microservice.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.job.model.CandidateFeedbackDTO;
import com.microservice.job.service.CandidateInterviewFeedbackService;

@RestController
public class InterviewController {
   
	
	@Autowired
	CandidateInterviewFeedbackService candidateInterviewFeedbackService;
	
	@PostMapping(value="/interview/feedback")
	public void interviewFeedabck(@RequestBody CandidateFeedbackDTO candidateFeedbackDTO
			,@RequestParam("feedbackby") String feedbackBy) {		
		candidateInterviewFeedbackService.saveCandidateInterviewFeedback(candidateFeedbackDTO
				,feedbackBy);		
	}
}
