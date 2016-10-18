package com.homedepot.pip.input;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author KXP8101
 *
 */
public class StoreSkuAisle {

	private AisleBay aisleBay;
	private String storeSkuId;

	@JsonProperty("aisleBayInfo")
	public AisleBay getAisleBay() {
		return aisleBay;
	}

	@JsonProperty("aisleBayInfo")
	public void setAisleBay(AisleBay aisleBay) {
		this.aisleBay = aisleBay;
	}

	public String getStoreSkuId() {
		return storeSkuId;
	}

	public void setStoreSkuId(String storeSkuId) {
		this.storeSkuId = storeSkuId;
	}
}