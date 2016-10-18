/**
 * 
 */
package com.homedepot.pip.input;

import java.sql.Date;

/**
 * @author KXP8101
 *
 */
public class Shipping {
	private String messageNumber;
	private Date sthStartDate;
	private Date sthEndDate;
	private Date bossStartDate;
	private Date bossEndDate;
	private Boolean dynamicEta;
	private String timeLeftHrs;
	private String timeLeftMins;
	private String threshold;
	private String excludedShipStates;

	public String getExcludedShipStates() {
		return excludedShipStates;
	}

	public void setExcludedShipStates(String excludedShipStates) {
		this.excludedShipStates = excludedShipStates;
	}

	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	public String getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(String messageNumber) {
		this.messageNumber = messageNumber;
	}

	public Date getSthStartDate() {
		return sthStartDate;
	}

	public void setSthStartDate(Date sthStartDate) {
		this.sthStartDate = sthStartDate;
	}

	public Date getSthEndDate() {
		return sthEndDate;
	}

	public void setSthEndDate(Date sthEndDate) {
		this.sthEndDate = sthEndDate;
	}

	public Date getBossStartDate() {
		return bossStartDate;
	}

	public void setBossStartDate(Date bossStartDate) {
		this.bossStartDate = bossStartDate;
	}

	public Date getBossEndDate() {
		return bossEndDate;
	}

	public void setBossEndDate(Date bossEndDate) {
		this.bossEndDate = bossEndDate;
	}

	public Boolean getDynamicEta() {
		return dynamicEta;
	}

	public void setDynamicEta(Boolean dynamicEta) {
		this.dynamicEta = dynamicEta;
	}

	public String getTimeLeftHrs() {
		return timeLeftHrs;
	}

	public void setTimeLeftHrs(String timeLeftHrs) {
		this.timeLeftHrs = timeLeftHrs;
	}

	public String getTimeLeftMins() {
		return timeLeftMins;
	}

	public void setTimeLeftMins(String timeLeftMins) {
		this.timeLeftMins = timeLeftMins;
	}
}