package com.homedepot.pip.request.api;

import java.text.MessageFormat;

import org.springframework.stereotype.Component;

@Component
public class ControllerHelper {
	
	public String getGcpApiProductNotFoundJson(String itemId) {
		return MessageFormat.format("{\"id\":\"NOT_FOUND\",\"description\": \"Record not found for itemId {0}\"}", itemId);
	}
}