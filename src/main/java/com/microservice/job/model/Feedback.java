package com.microservice.job.model;

public class Feedback {

	private String feedback;
	private String decision; 
	private String  mrname ;
	
	public Feedback() {
		
	}
	
	public Feedback(String feedback, String decision, String mrname) {
		super();
		this.feedback = feedback;
		this.decision = decision;
		this.mrname = mrname;
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
	public String getMrname() {
		return mrname;
	}
	public void setMrname(String mrname) {
		this.mrname = mrname;
	}
	
	
}
