package com.microservice.job.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.job.model.CandidateFeedbackDTO;
import com.microservice.job.model.CandidateInterviewFeedback;
import com.microservice.job.model.HrFeedaback;
import com.microservice.job.model.InterviewDetails;
import com.microservice.job.model.InterviewFeedback;
import com.microservice.job.model.InterviewFeedbackStatus;
import com.microservice.job.model.MrFeedback;
import com.microservice.job.model.Trfeedback;
import com.microservice.job.repository.InterviewFeedbackRepository;
import com.microservice.job.repository.InterviewRepository;
import com.microservice.job.repository.JobApplicationRepo;

@Service
public class CandidateInterviewFeedbackService {

	@Autowired
	InterviewFeedbackRepository interviewFeedbackRepo;
	
	@Autowired
	JobApplicationRepo jobApplicationRepo;
	
	@Autowired
	InterviewRepository interviewRepository;
	
	
	
	public void saveCandidateInterviewFeedback(CandidateFeedbackDTO candidateFeedback , String feedback) {
		
		Optional<CandidateInterviewFeedback> opts = interviewFeedbackRepo.findByApplicationIdAndJobId(candidateFeedback.getApplicationId(), candidateFeedback.getJobId());	
		Optional<InterviewDetails>  interviewDetails = interviewRepository.findByApplicationIdAndJobId(candidateFeedback.getApplicationId(), candidateFeedback.getJobId());
		if(!interviewDetails.isPresent()) {
			throw new RuntimeException("No job has been scheduled");
		}
		if(opts.isPresent() ) {
			interviewFeedbackRepo.save(dtoToEntityMapper(candidateFeedback,feedback,opts.get()));
		}else {
			interviewFeedbackRepo.save(dtoToEntityMapper(candidateFeedback,feedback,new CandidateInterviewFeedback()));
		}
				
	}
	
	public CandidateInterviewFeedback dtoToEntityMapper(CandidateFeedbackDTO candidateFeedback, String feedbackby,CandidateInterviewFeedback candidateInterviewFeedback) {		
				
		candidateInterviewFeedback.setCanidateName(candidateFeedback.getApplicantName());		
		candidateInterviewFeedback.setApplicationId(candidateFeedback.getApplicationId());
		candidateInterviewFeedback.setJobId(candidateFeedback.getJobId());
		candidateInterviewFeedback.setCurrentApplicationStatus("PENDING");		
		if(feedbackby.equals("TR")) {
			Trfeedback trfeedback = new Trfeedback();
			trfeedback.setDecision(candidateFeedback.getDecision());
			trfeedback.setRating(candidateFeedback.getRating());
			trfeedback.setFeedback(candidateFeedback.getFeedback());
			trfeedback.setTrName(candidateFeedback.getMrname());
			candidateInterviewFeedback.setTrFeedback(trfeedback);
			if(candidateFeedback.getDecision().equalsIgnoreCase("Rejected")) {
				candidateInterviewFeedback.setCurrentApplicationStatus("PENDING");
				candidateInterviewFeedback.setCurrentApplicationStatus(InterviewFeedbackStatus.TR_REJECT.name());	
			}else {
				candidateInterviewFeedback.setCurrentApplicationStatus(InterviewFeedbackStatus.TR_SELECT.name());
			}
			
						
		}else if(feedbackby.equals("MR")) {
			MrFeedback mrfeedback = new MrFeedback();
			mrfeedback.setDecision(candidateFeedback.getDecision());
			mrfeedback.setRating(candidateFeedback.getRating());
			mrfeedback.setFeedback(candidateFeedback.getFeedback());
			mrfeedback.setMrName(candidateFeedback.getMrname());
			candidateInterviewFeedback.setMrFeedback(mrfeedback);
			if(candidateFeedback.getDecision().equalsIgnoreCase("Rejected")) {
				candidateInterviewFeedback.setCurrentApplicationStatus(InterviewFeedbackStatus.MR_REJECT.name());	
			}else {
				candidateInterviewFeedback.setCurrentApplicationStatus(InterviewFeedbackStatus.MR_SELECT.name());
			}
			
		}else if(feedbackby.equals("HR")) {
			HrFeedaback hrfeedback = new HrFeedaback();
			hrfeedback.setDecision(candidateFeedback.getDecision());
			hrfeedback.setRating(candidateFeedback.getRating());
			hrfeedback.setFeedback(candidateFeedback.getFeedback());
			hrfeedback.setHrName(candidateFeedback.getMrname());
			candidateInterviewFeedback.setHrfeedback(hrfeedback);
			candidateInterviewFeedback.setCurrentApplicationStatus(candidateFeedback.getDecision());
			if(candidateFeedback.getDecision().equalsIgnoreCase("Rejected")) {
				candidateInterviewFeedback.setCurrentApplicationStatus(InterviewFeedbackStatus.HR_REJECT.name());	
			}else {
				candidateInterviewFeedback.setCurrentApplicationStatus(InterviewFeedbackStatus.HR_SELECT.name());
			}
		}		
		
		return candidateInterviewFeedback;
				
		
	}
	
	
}
