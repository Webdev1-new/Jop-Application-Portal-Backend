package com.microservice.job.model;

public class JobRecommened {

    private String jobTitle;    
    private String companyName;
    private String jobId;
    private String location;
    private String employmentType;
    private String experience;
    private String salary;
    private String skills;
    private String jobDescription;
    private String postedAt;
    
    
	public JobRecommened(String jobTitle, String companyName, String jobId, String location, String employmentType,
			String experience, String salary, String skills, String jobDescription, String postedAt) {
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
		this.postedAt = postedAt;
	}
	
	public JobRecommened() {
		
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
	public String getPostedAt() {
		return postedAt;
	}
	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}
        
    
}
