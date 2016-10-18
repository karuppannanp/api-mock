package com.homedepot.pip.enums;

import java.util.HashMap;
import java.util.Map;

public class ShippingType {

	public static final String PRICE_INCLUDES_SHIPPING = "1";
	public static final String NOT_QUALIFY = "2";
	public static final String FREE_WITH = "3";
	public static final String FREE = "4";
	public static final String APPL_FREE = "5";
	public static final String APPL_FREE_WITH = "6";

	private static Map<String, String> MESSAGING = new HashMap<>();
	private static Map<String, String> APPLIANCE_MESSAGING = new HashMap<>();
	static {
		MESSAGING.put(PRICE_INCLUDES_SHIPPING, null);
		MESSAGING.put(NOT_QUALIFY, null);
		MESSAGING.put(FREE_WITH, null);
		MESSAGING.put(FREE, null);
		MESSAGING.put(APPL_FREE, null);
		MESSAGING.put(APPL_FREE_WITH, null);
		
		APPLIANCE_MESSAGING.put(APPL_FREE, null);
		APPLIANCE_MESSAGING.put(APPL_FREE_WITH, null);
	}

	public static boolean isValidShippingType(String shippingNum) {
		return MESSAGING.containsKey(shippingNum);
	}

	public static boolean isValidApplianceShippingType(String shippingNum) {
		return APPLIANCE_MESSAGING.containsKey(shippingNum);
	}
}