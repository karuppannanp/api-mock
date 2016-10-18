package com.homedepot.pip.backend.domain.fullfillment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class STHFulfillmentOption {

    private boolean eligibilityStatus;

    public boolean isEligibilityStatus() {
        return eligibilityStatus;
    }

    @JacksonXmlProperty(localName = "status")
    public void setEligibilityStatus(boolean eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }
}
