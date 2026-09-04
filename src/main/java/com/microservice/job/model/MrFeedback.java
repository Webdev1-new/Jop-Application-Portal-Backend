package com.microservice.job.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MrFeedback {

	private String mrName;
	private String mrEmpId;
	private String decision;
	private String rating;
	private String feedback;
	private LocalDateTime feedbackDate = LocalDateTime.now();
		
	public MrFeedback(String mrName, String mrEmpId, String decision, String rating, String feedback,
			LocalDateTime feedbackDate) {
		super();
		this.mrName = mrName;
		this.mrEmpId = mrEmpId;
		this.decision = decision;
		this.rating = rating;
		this.feedback = feedback;
		this.feedbackDate = feedbackDate;
	}


	public MrFeedback() {
		// TODO Auto-generated constructor stub
	}


	public String getMrName() {
		return mrName;
	}


	public void setMrName(String mrName) {
		this.mrName = mrName;
	}


	public String getMrEmpId() {
		return mrEmpId;
	}


	public void setMrEmpId(String mrEmpId) {
		this.mrEmpId = mrEmpId;
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


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public LocalDateTime getFeedbackDate() {
		return feedbackDate;
	}


	public void setFeedbackDate(LocalDateTime feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
	
	
	
	
}
