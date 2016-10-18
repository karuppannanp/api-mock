package com.homedepot.pip.enums;

import java.util.HashMap;
import java.util.Map;

public class ItemAvailabilityType {

	public static final String ONLINE = "Online";
	public static final String SHARED = "Shared";
	public static final String BROWSE_ONLY = "Browse Only";
	
	private static Map<String, String> ITEM_AVAILABILITY_TYPE = new HashMap<>();
	
	static {
		ITEM_AVAILABILITY_TYPE.put(ONLINE, ONLINE);
		ITEM_AVAILABILITY_TYPE.put(SHARED, SHARED);
		ITEM_AVAILABILITY_TYPE.put(BROWSE_ONLY, BROWSE_ONLY);
	}
	
	public static boolean isValidItemAvailabilityType(String itemAvailabilityType) {
		return ITEM_AVAILABILITY_TYPE.containsKey(itemAvailabilityType);
	}
}