package com.homedepot.pip.backend.domain.fullfillment;

import com.homedepot.pip.backend.domain.item.ItemInventory;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BOPISFulfillmentOption {

    private ItemInventory inventory;

    private boolean eligibilityStatus;

    private boolean checkStoreLink;

	private String alphaPromptRestriction;
	
	private String alphaPromptMessage;
	
    public BOPISFulfillmentOption() {
    }

    public BOPISFulfillmentOption(boolean eligibilityStatus, boolean checkStoreLink) {

        this.eligibilityStatus = eligibilityStatus;

        this.checkStoreLink = checkStoreLink;
    }

    public BOPISFulfillmentOption(ItemInventory inventory) {

        this.inventory = inventory;
    }


    public boolean isCheckStoreLink() {
        return checkStoreLink;
    }

    @JacksonXmlProperty(localName ="checkNearbyStores")
    public void setCheckStoreLink(boolean checkStoreLink) {
        this.checkStoreLink = checkStoreLink;
    }

    public boolean isEligibilityStatus() {
        return eligibilityStatus;
    }

    @JacksonXmlProperty(localName ="status")
    public void setEligibilityStatus(boolean eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    public ItemInventory getInventory() {
        return inventory;
    }

    public void setInventory(ItemInventory inventory) {
        this.inventory = inventory;
    }
	public String getAlphaPromptRestriction() {
		return alphaPromptRestriction;
	}

	@JacksonXmlProperty
	public void setAlphaPromptRestriction(String alphaPromptRestriction) {
		this.alphaPromptRestriction = alphaPromptRestriction;
	}

	public String getAlphaPromptMessage() {
		return alphaPromptMessage;
	}

	@JacksonXmlProperty
	public void setAlphaPromptMessage(String alphaPromptMessage) {
		this.alphaPromptMessage = alphaPromptMessage;
	}
}