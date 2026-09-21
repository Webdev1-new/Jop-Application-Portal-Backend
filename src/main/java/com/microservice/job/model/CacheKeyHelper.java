package com.microservice.job.model;

import org.springframework.stereotype.Component;

@Component("cacheKeyHelper")
public class CacheKeyHelper {

	public String normalize(String input) {
		
		if(input==null || input.trim().isEmpty()) {
			return null;
		}
		
		return input.trim();
	}
}
