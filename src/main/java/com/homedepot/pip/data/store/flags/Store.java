/**
 * 
 */
package com.homedepot.pip.data.store.flags;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author KXP8101
 *
 */
public class Store {
	@JacksonXmlProperty(localName = "STORENUMBER")
	private String storeId;
	
	@JacksonXmlProperty(localName = "STREETNAME")
	private String street;
	
	@JacksonXmlProperty(localName = "CITYNAME")
	private String city;
	
	@JacksonXmlProperty(localName = "STATECODE")
	private String state;
	
	@JacksonXmlProperty(localName = "zipCode")
	private String zipCode;

	@JacksonXmlProperty(localName = "bopisEligibilityFlag")
	private String bopis;
	
	@JacksonXmlProperty(localName = "bossElgFlg")
	private String boss;
	
	@JacksonXmlProperty(localName = "bossMsgFlg")
	private String bossMsg;
	
	@JacksonXmlProperty(localName = "bodfsEligibilityFlag")
	private String bodfs;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBopis() {
		return bopis;
	}

	public void setBopis(String bopis) {
		this.bopis = bopis;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	public String getBossMsg() {
		return bossMsg;
	}

	public void setBossMsg(String bossMsg) {
		this.bossMsg = bossMsg;
	}

	public String getBodfs() {
		return bodfs;
	}

	public void setBodfs(String bodfs) {
		this.bodfs = bodfs;
	}
}