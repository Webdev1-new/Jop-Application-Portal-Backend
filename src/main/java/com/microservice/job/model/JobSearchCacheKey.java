package com.microservice.job.model;

import java.util.Objects;

public class JobSearchCacheKey {

	private String technology;
    private String location;
    private Integer experience;
    
    public JobSearchCacheKey() {
    	
    }

	public JobSearchCacheKey(String technology, String location, Integer experience) {
		super();
		this.technology = technology;
		this.location = location;
		this.experience = experience;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
    
    public boolean equals(Object o) {    	
    	if( this == o) return true;
    	if(!(o instanceof  JobSearchCacheKey)) return false;
    	
    	JobSearchCacheKey jobSearchCacheKey  = (JobSearchCacheKey) o;
    	
    	return Objects.equals(technology, jobSearchCacheKey.getTechnology()) && Objects.equals(location, jobSearchCacheKey.getLocation())
    	&& Objects.equals(experience, jobSearchCacheKey.getExperience());
    	
    	
    }
    
    public int hashcode(Object o) {   	
    	return Objects.hash(
    			technology,
                location,
                experience               
            );
    }
    
    
    public JobSearchCacheKey createJobSearchKey(String technology,String location , Integer experience) {
    	
    	return new JobSearchCacheKey(technology,location,experience);
    }
}
