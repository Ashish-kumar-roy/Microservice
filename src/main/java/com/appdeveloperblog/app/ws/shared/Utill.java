package com.appdeveloperblog.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Component;
@Component
public class Utill {
	
	public String generateId() {
		
		return UUID.randomUUID().toString();
	}

}
