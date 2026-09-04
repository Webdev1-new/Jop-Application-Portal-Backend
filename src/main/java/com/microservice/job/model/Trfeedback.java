package com.microservice.job.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Trfeedback {

	private String trName;
	private String trEmpId;
	private String decision;
	private String rating;
	private String feedback;
	private LocalDateTime feedbackDate = LocalDateTime.now();
	
	
	public Trfeedback() {
		
	}
	
	public Trfeedback(String trName, String trEmpId, String decision, String rating, String feedback,
			LocalDateTime feedbackDate) {
		super();
		this.trName = trName;
		this.trEmpId = trEmpId;
		this.decision = decision;
		this.rating = rating;
		this.feedback = feedback;
		this.feedbackDate = feedbackDate;
	}

	public String getTrName() {
		return trName;
	}

	public void setTrName(String trName) {
		this.trName = trName;
	}

	public String getTrEmpId() {
		return trEmpId;
	}

	public void setTrEmpId(String trEmpId) {
		this.trEmpId = trEmpId;
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
