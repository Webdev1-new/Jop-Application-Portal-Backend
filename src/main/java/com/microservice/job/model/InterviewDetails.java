package com.microservice.job.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="interviewdetails")
public class InterviewDetails {

	 @Id
	 String interviewId;
	 String applicantId;
	 String jobId;
     String interviewRound; 
	 String interviewDate;
	 String interviewTime;
     String interviewMode;
	 String meetingLink;
     String interviewerName;
	 String interviewerEmail;
	 String remarks;
     String interviewStatus;
     String interviewResult;
	 String feedback;
	 
	 public InterviewDetails() {
		 
	 }
	 public String getApplicantId() {
		return applicantId;
	 }
	 public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	 }
	 public String getJobId() {
		return jobId;
	 }
	 public void setJobId(String jobId) {
		this.jobId = jobId;
	 }
	 public String getInterviewRound() {
		return interviewRound;
	 }
	 public void setInterviewRound(String interviewRound) {
		this.interviewRound = interviewRound;
	 }
	 public String getInterviewDate() {
		return interviewDate;
	 }
	 public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	 }
	 public String getInterviewTime() {
	 	return interviewTime;
	 }
	 public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	 }
	 public String getInterviewMode() {
		return interviewMode;
	 }
	 public void setInterviewMode(String interviewMode) {
		this.interviewMode = interviewMode;
	 }
	 public String getMeetingLink() {
		return meetingLink;
	 }
	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getInterviewerEmail() {
		return interviewerEmail;
	}
	public void setInterviewerEmail(String interviewerEmail) {
		this.interviewerEmail = interviewerEmail;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getInterviewResult() {
		return interviewResult;
	}
	public void setInterviewResult(String interviewResult) {
		this.interviewResult = interviewResult;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	 
	 
	 
}
	 
	 
	 
	 
