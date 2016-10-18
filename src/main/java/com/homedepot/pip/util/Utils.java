package com.homedepot.pip.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Utils {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat TIME_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss z"); 

	public static int convertStringToInt(String value) {
		if (StringUtils.isBlank(value)) {
			return -1;
		}
		try {
			return Integer.parseInt(value);
		} catch (Exception exception) {
			return -100;
		}
	}
	
	public static String generateOverlayBossDate(int daysToIncrement) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, daysToIncrement);
		return DATE_FORMAT.format(cal.getTime());
	}
	
	public static String getCurrentTime() {
		return TIME_DATE_FORMAT.format(new Date());
	}
}