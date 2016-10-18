/**
 * 
 */
package com.homedepot.pip.backend.store.fulfillment;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author KXP8101
 *
 */
public class PrimaryStore {

	private String name;
	private String storeId;
	private String hours;
	private String phone;
	private String unit;
	private Double distance;
	private Address address;
	private FulfillmentOptions fulfillmentOptions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("storeId")
	public String getStoreId() {
		return storeId;
	}

	@JsonProperty("storeId")
	public void setStoreId(String storeId) {
		if (StringUtils.startsWith(storeId, "0")) {
			storeId = storeId.replaceFirst("0", "");
		}
		this.storeId = storeId;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public FulfillmentOptions getFulfillmentOptions() {
		return fulfillmentOptions;
	}

	public void setFulfillmentOptions(FulfillmentOptions fulfillmentOptions) {
		this.fulfillmentOptions = fulfillmentOptions;
	}

	@JsonProperty("storeHours")
	public void setStoreHours(StoreHours storeHours) {
		hours = getStoreHoursString(storeHours);
	}
	
	private String getStoreHoursString(StoreHours storeHours) {
		StringBuilder storeHoursBuilder = new StringBuilder();
		if (storeHours == null) {
			return "";
		}
		try {
			storeHoursBuilder.append("1;").append(storeHours.getMonday().getOpen()).append("-").append(storeHours.getMonday().getClose());
			storeHoursBuilder.append(";2;").append(storeHours.getTuesday().getOpen()).append("-").append(storeHours.getTuesday().getClose());
			storeHoursBuilder.append(";3;").append(storeHours.getWednesday().getOpen()).append("-").append(storeHours.getWednesday().getClose());
			storeHoursBuilder.append(";4;").append(storeHours.getThursday().getOpen()).append("-").append(storeHours.getThursday().getClose());
			storeHoursBuilder.append(";5;").append(storeHours.getFriday().getOpen()).append("-").append(storeHours.getFriday().getClose());
			storeHoursBuilder.append(";6;").append(storeHours.getSaturday().getOpen()).append("-").append(storeHours.getSaturday().getClose());
			storeHoursBuilder.append(";7;").append(storeHours.getSunday().getOpen()).append("-").append(storeHours.getSunday().getClose());
		} catch (Exception exception) {
		}
		return storeHoursBuilder.toString();
	}
}