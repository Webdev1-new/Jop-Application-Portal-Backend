package com.microservice.job.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="jobApplications")
public class JobApplication {

	@Id
	String applicationId = UUID.randomUUID().toString();
	String jobId;
	String username;
	String jobTitle;
	LocalDate jobApplicationadate = LocalDate.now();
	String result;
	LocalDate interviewprocessingDate;
	
	public JobApplication(String applicationId, String jobId, String username, String jobTitle,
			LocalDate jobApplicationadate, String result, LocalDate interviewprocessingDate) {
		super();
		this.applicationId = applicationId;
		this.jobId = jobId;
		this.username = username;
		this.jobTitle = jobTitle;
		this.jobApplicationadate = jobApplicationadate;
		this.result = result;
		this.interviewprocessingDate = interviewprocessingDate;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public LocalDate getJobApplicationadate() {
		return jobApplicationadate;
	}
	public void setJobApplicationadate(LocalDate jobApplicationadate) {
		this.jobApplicationadate = jobApplicationadate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public LocalDate getInterviewprocessingDate() {
		return interviewprocessingDate;
	}
	public void setInterviewprocessingDate(LocalDate interviewprocessingDate) {
		this.interviewprocessingDate = interviewprocessingDate;
	}
	
	
	
	
	
}

