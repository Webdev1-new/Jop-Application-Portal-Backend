package com.microservice.job.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HrFeedaback {

	private String hrName;
	private String hrEmpId;
	private String decision;
	private String rating;
	private String feedback;
	private LocalDateTime feedbackDate = LocalDateTime.now();
	
	
	public HrFeedaback(String hrName, String hrEmpId, String decision, String rating, String feedback,
			LocalDateTime feedbackDate) {
		super();
		this.hrName = hrName;
		this.hrEmpId = hrEmpId;
		this.decision = decision;
		this.rating = rating;
		this.feedback = feedback;
		this.feedbackDate = feedbackDate;
	}


	public HrFeedaback() {
		// TODO Auto-generated constructor stub
	}


	public String getHrName() {
		return hrName;
	}


	public void setHrName(String hrName) {
		this.hrName = hrName;
	}


	public String getHrEmpId() {
		return hrEmpId;
	}


	public void setHrEmpId(String hrEmpId) {
		this.hrEmpId = hrEmpId;
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
