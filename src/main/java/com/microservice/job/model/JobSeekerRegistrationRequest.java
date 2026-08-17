package com.microservice.job.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employers")
public class JobSeekerRegistrationRequest {

	@Id
	private String username;
    private String password;
    private String email;
    private String resume;
    private String phoneno;
    private String notification;
    private String address;
    
    public JobSeekerRegistrationRequest() {
    	
    }

	public JobSeekerRegistrationRequest(String username, String password, String resume, String phoneno,
			String notification, String address,String email) {
		super();
		this.username = username;
		this.password = password;
		this.resume = resume;
		this.phoneno = phoneno;
		this.notification = notification;
		this.address = address;
		this.email = email;
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

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
    
    
    
}
