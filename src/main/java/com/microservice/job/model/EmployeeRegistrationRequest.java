package com.microservice.job.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EmployerRegistration")
public class EmployeeRegistrationRequest {
	
    
	private String username;
    private String password;
    @Id
    private String employerId;
    private String companyName;
    private String emailId;
    private String mobileno;
    private String phoneno;
    private String companyAddress;
    private String state;
    private String countrycode;
    private String gstnumber;
    
    
	public EmployeeRegistrationRequest(String username, String password, String employerId, String companyName,
			String emailId, String mobileno, String phoneno, String companyAddress, String state, String countrycode,
			String gstnumber) {
		super();
		this.username = username;
		this.password = password;
		this.employerId = employerId;
		this.companyName = companyName;
		this.emailId = emailId;
		this.mobileno = mobileno;
		this.phoneno = phoneno;
		this.companyAddress = companyAddress;
		this.state = state;
		this.countrycode = countrycode;
		this.gstnumber = gstnumber;
	}
	
	public EmployeeRegistrationRequest() {
		
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployerId() {
		return employerId;
	}
	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getGstnumber() {
		return gstnumber;
	}
	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}
        
    
}
