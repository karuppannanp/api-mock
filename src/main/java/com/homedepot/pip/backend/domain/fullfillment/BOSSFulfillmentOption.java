package com.homedepot.pip.backend.domain.fullfillment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.sql.Date;

public class BOSSFulfillmentOption {

    private Date estStartDeliveryDate;
    private Date estEndDeliveryDate;

    private boolean eligibilityStatus;

    private boolean checkStoreLink;

    public BOSSFulfillmentOption() {
    }

    public BOSSFulfillmentOption(boolean eligibilityStatus, boolean checkStoreLink) {
        this.eligibilityStatus = eligibilityStatus;
        this.checkStoreLink = checkStoreLink;
    }

    public BOSSFulfillmentOption(Date estStartDeliveryDate, Date estEndDeliveryDate) {
        this.estStartDeliveryDate = estStartDeliveryDate;
        this.estEndDeliveryDate = estEndDeliveryDate;
    }

    public boolean isCheckStoreLink() {
        return checkStoreLink;
    }

    @JacksonXmlProperty(localName = "checkNearbyStores")
    public void setCheckStoreLink(boolean checkStoreLink) {
        this.checkStoreLink = checkStoreLink;
    }

    public boolean isEligibilityStatus() {
        return eligibilityStatus;
    }

    @JacksonXmlProperty(localName = "status")
    public void setEligibilityStatus(boolean eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    public Date getEstStartDeliveryDate() {
        return estStartDeliveryDate;
    }

    public void setEstStartDeliveryDate(Date estStartDeliveryDate) {
        this.estStartDeliveryDate = estStartDeliveryDate;
    }

    public Date getEstEndDeliveryDate() {
        return estEndDeliveryDate;
    }

    public void setEstEndDeliveryDate(Date estEndDeliveryDate) {
        this.estEndDeliveryDate = estEndDeliveryDate;
    }
}