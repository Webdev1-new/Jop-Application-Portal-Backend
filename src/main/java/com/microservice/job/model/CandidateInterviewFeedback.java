package com.microservice.job.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="interviewfeedback")
public class CandidateInterviewFeedback {

	@Id
	private String interviewId = UUID.randomUUID().toString();
	private String applicationId;
	private String jobId;
	private String canidateName;
	private String currentApplicationStatus;
	private LocalDate modificationDate;
	private MrFeedback mrFeedback;
	private HrFeedaback hrfeedback;
	private Trfeedback trFeedback;
	
	
	public CandidateInterviewFeedback() {
		
	}
	
	
	public CandidateInterviewFeedback(String applicationId, String jobId, String canidateName,
			String currentApplicationStatus, LocalDate modificationDate, MrFeedback mrFeedback, HrFeedaback hrfeedback,
			Trfeedback trFeedback,String interviewId) {
		super();
		this.applicationId = applicationId;
		this.jobId = jobId;
		this.canidateName = canidateName;
		this.currentApplicationStatus = currentApplicationStatus;
		this.modificationDate = modificationDate;
		this.mrFeedback = mrFeedback;
		this.hrfeedback = hrfeedback;
		this.trFeedback = trFeedback;
		this.interviewId = interviewId;
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

	public String getCanidateName() {
		return canidateName;
	}

	public void setCanidateName(String canidateName) {
		this.canidateName = canidateName;
	}

	public String getCurrentApplicationStatus() {
		return currentApplicationStatus;
	}

	public void setCurrentApplicationStatus(String currentApplicationStatus) {
		this.currentApplicationStatus = currentApplicationStatus;
	}

	public LocalDate getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDate modificationDate) {
		this.modificationDate = modificationDate;
	}

	public MrFeedback getMrFeedback() {
		return mrFeedback;
	}

	public void setMrFeedback(MrFeedback mrFeedback) {
		this.mrFeedback = mrFeedback;
	}

	public HrFeedaback getHrfeedback() {
		return hrfeedback;
	}

	public void setHrfeedback(HrFeedaback hrfeedback) {
		this.hrfeedback = hrfeedback;
	}

	public Trfeedback getTrFeedback() {
		return trFeedback;
	}

	public void setTrFeedback(Trfeedback trFeedback) {
		this.trFeedback = trFeedback;
	}
	
	
	
	
}
