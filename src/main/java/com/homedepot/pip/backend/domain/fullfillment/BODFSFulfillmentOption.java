package com.homedepot.pip.backend.domain.fullfillment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BODFSFulfillmentOption {
    private boolean eligibilityStatus;
    private Boolean sameDayEligibilityStatus;
    private String estDeliveryCharge;
	private String alphaPromptRestriction;
	private String alphaPromptMessage;
	
    public boolean isEligibilityStatus() {
        return eligibilityStatus;
    }

    @JacksonXmlProperty(localName = "status")
    public void setEligibilityStatus(boolean eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    public Boolean getSameDayEligibilityStatus() {
        return sameDayEligibilityStatus;
    }

    @JacksonXmlProperty(localName = "sameDayEligible")
    public void setSameDayEligibilityStatus(Boolean sameDayEligibilityStatus) {
        this.sameDayEligibilityStatus = sameDayEligibilityStatus;
    }

    public String getEstDeliveryCharge() {
        return estDeliveryCharge;
    }

    @JacksonXmlProperty
    public void setEstDeliveryCharge(String estDeliveryCharge) {
        this.estDeliveryCharge = estDeliveryCharge;
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