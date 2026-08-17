package com.microservice.job.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="interviewdetails")
public class Interview {

	
	    @Id
	    private String interviewId = UUID.randomUUID().toString();
	    private String applicantId;
	    private String jobId;	    
	    private String applicantName;
	    private String applicantEmail;
	    private String interviewRound;
	    private LocalDate interviewDate;
	    private String interviewTime;	   
		private String interviewMode;
	    private String meetingLink;
	    private String interviewerName;
	    private String interviewerEmail;
	    private String remarks;
	    private String interviewStatus;

	    private InterviewFeedback technicalFeedback;
	    private InterviewFeedback managerialFeedback;
	    private InterviewFeedback hrFeedback;

	    private String finalResult;
	    
	    public Interview(String interviewId, String applicantId, String jobId, String interviewRound,
				LocalDate interviewDate, String interviewTime, String interviewMode, String meetingLink,
				String interviewerName, String interviewerEmail, String remarks, String interviewStatus,
				InterviewFeedback technicalFeedback, InterviewFeedback managerialFeedback, InterviewFeedback hrFeedback,
				String finalResult, String applicantName , String applicantEmail) {
			super();
			this.interviewId = interviewId;
			this.applicantId = applicantId;
			this.jobId = jobId;
			this.interviewRound = interviewRound;
			this.interviewDate = interviewDate;
			this.interviewTime = interviewTime;
			this.interviewMode = interviewMode;
			this.meetingLink = meetingLink;
			this.interviewerName = interviewerName;
			this.interviewerEmail = interviewerEmail;
			this.remarks = remarks;
			this.interviewStatus = interviewStatus;
			this.technicalFeedback = technicalFeedback;
			this.managerialFeedback = managerialFeedback;
			this.hrFeedback = hrFeedback;
			this.finalResult = finalResult;
			this.applicantName = applicantName;
			this.applicantEmail  = applicantEmail;
		}


	    public Interview() {
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

	    public LocalDate getInterviewDate() {
	        return interviewDate;
	    }

	    public void setInterviewDate(LocalDate interviewDate) {
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

	    public InterviewFeedback getTechnicalFeedback() {
	        return technicalFeedback;
	    }

	    public void setTechnicalFeedback(InterviewFeedback technicalFeedback) {
	        this.technicalFeedback = technicalFeedback;
	    }

	    public InterviewFeedback getManagerialFeedback() {
	        return managerialFeedback;
	    }

	    public void setManagerialFeedback(InterviewFeedback managerialFeedback) {
	        this.managerialFeedback = managerialFeedback;
	    }

	    public InterviewFeedback getHrFeedback() {
	        return hrFeedback;
	    }

	    public void setHrFeedback(InterviewFeedback hrFeedback) {
	        this.hrFeedback = hrFeedback;
	    }

	    public String getFinalResult() {
	        return finalResult;
	    }
	    public String getInterviewId() {
			return interviewId;
		}

		public void setInterviewId(String interviewId) {
			this.interviewId = interviewId;
		}

		public String getApplicantName() {
			return applicantName;
		}

		public void setApplicantName(String applicantName) {
			this.applicantName = applicantName;
		}

		public String getApplicantEmail() {
			return applicantEmail;
		}

		public void setApplicantEmail(String applicantEmail) {
			this.applicantEmail = applicantEmail;
		}


		public void setFinalResult(String finalResult) {
	        this.finalResult = finalResult;
	    }
	    
	    
	}

