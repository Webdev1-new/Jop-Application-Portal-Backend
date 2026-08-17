package com.microservice.job.model;


import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="jobs")
public class JobPostRequest {
	
    private String jobTitle;
    
    private String companyName;
    
    @Id
    private String jobId;

    private String location;

    private String employmentType;

    private String experience;

    private String salary;

    private String skills;

    private String jobDescription;

    private String lastDate;
    
    private String jobPostedBy;
        
	private LocalDateTime jobPostedDate = LocalDateTime.now() ;
       
    private LocalDateTime jobUpdatedDate;
    
	public JobPostRequest(String jobTitle, String companyName, String jobId, String location, String employmentType,
			String experience, String salary, String skills, String jobDescription, String lastDate, String jobPostedBy) {
		super();
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.jobId = jobId;
		this.location = location;
		this.employmentType = employmentType;
		this.experience = experience;
		this.salary = salary;
		this.skills = skills;
		this.jobDescription = jobDescription;
		this.lastDate = lastDate;
		this.jobPostedBy = jobPostedBy;
	}
	
	public JobPostRequest() {
		
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getJobPostedBy() {
		return jobPostedBy;
	}

	public void setJobPostedBy(String jobPostedBy) {
		this.jobPostedBy = jobPostedBy;
	}
	
	public LocalDateTime getJobPostedDate() {
		return jobPostedDate;
	}

	public void setJobPostedDate(LocalDateTime jobPostedDate) {
		this.jobPostedDate = jobPostedDate;
	}

	public LocalDateTime getJobUpdatedDate() {
		return jobUpdatedDate;
	}

	public void setJobUpdatedDate(LocalDateTime jobUpdatedDate) {
		this.jobUpdatedDate = jobUpdatedDate;
	}

	
	
	
	
    
    
    

}
