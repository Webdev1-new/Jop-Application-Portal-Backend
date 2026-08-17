package com.microservice.job.model;

public class ApplicantDetails{

	String applicationId;
	String name;
	String email;
	String resume;
	String status;
	String skills;
	String jobId;
	
	
	public ApplicantDetails(String applicationId, String name, String email, String resume, String status) {
		super();
		this.applicationId = applicationId;
		this.name = name;
		this.email = email;
		this.resume = resume;
		this.status = status;
	}
	
	public ApplicantDetails() {
		
	}


	public String getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getResume() {
		return resume;
	}


	public void setResume(String resume) {
		this.resume = resume;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	
	
	
	
}
