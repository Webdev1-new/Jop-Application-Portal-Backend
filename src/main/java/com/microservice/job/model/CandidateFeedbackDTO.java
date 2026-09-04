package com.microservice.job.model;

import java.time.LocalDate;
import java.util.UUID;

public class CandidateFeedbackDTO {

	
	private String applicantName;
	private String applicationId;
	private String jobId;
	private String interviewerName;
	private String feedback;
	private String decision; 
	private String rating;
	private String  mrname ;
	
	
	public CandidateFeedbackDTO() {
		
	}
	
	public CandidateFeedbackDTO(String applicantName, String applicationId, String jobId, String interviewerName,
			String feedback, String decision, String rating, String mrname) {
		super();
		this.applicantName = applicantName;
		this.applicationId = applicationId;
		this.jobId = jobId;
		this.interviewerName = interviewerName;
		this.feedback = feedback;
		this.decision = decision;
		this.rating = rating;
		this.mrname = mrname;
	}
	
	
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getMrname() {
		return mrname;
	}
	public void setMrname(String mrname) {
		this.mrname = mrname;
	}
	
	
	
	
	
}
