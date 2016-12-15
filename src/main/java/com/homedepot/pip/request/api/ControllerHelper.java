package com.homedepot.pip.request.api;

import org.springframework.stereotype.Component;

@Component
public class ControllerHelper {
	
	public String getGcpApiProductNotFoundJson(String itemId) {
		return "{\"id\":\"NOT_FOUND\",\"description\": \"Record not found for itemId " + itemId + "\"}";
	}
}