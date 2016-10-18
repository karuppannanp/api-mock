package com.homedepot.pip.backend.domain.item;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.sql.Date;

public class ItemShipping {

    private Boolean eligibleForFreeShipping;
    private Boolean itemLevelFreeShip;
    private String excludedShipStates;
    private String freeShippingMessageNumber;
    private String freeShippingThreshold;
    private String freeShippingMessageKey;
    private String freeShippingMessage;
    private Boolean bossItemLevelFreeShipElg;
    private Date sthEstimatedShippingStartDate;
    private Date sthEstimatedShippingEndDate;
    private Boolean isDynamicEta;
    private String dynamicEtaTimeLeftHrs;
    private String dynamicEtaTimeLeftMins;
    private Date bossEstimatedShippingStartDate;
    private Date bossEstimatedShippingEndDate;

    public String getExcludedShipStates() {
        return excludedShipStates;
    }

    @JacksonXmlProperty
    public void setExcludedShipStates(String excludedShipStates) {
        this.excludedShipStates = excludedShipStates;
    }

    public String getFreeShippingMessageNumber() {
        return freeShippingMessageNumber;
    }

    @JacksonXmlProperty
    public void setFreeShippingMessageNumber(String freeShippingMessageNumber) {
        this.freeShippingMessageNumber = freeShippingMessageNumber;
    }

    public String getFreeShippingThreshold() {
        return freeShippingThreshold;
    }

    @JacksonXmlProperty
    public void setFreeShippingThreshold(String freeShippingThreshold) {
        this.freeShippingThreshold = freeShippingThreshold;
    }

    public Boolean getEligibleForFreeShipping() {
        return eligibleForFreeShipping;
    }

    @JacksonXmlProperty
    public void setEligibleForFreeShipping(Boolean eligibleForFreeShipping) {
        this.eligibleForFreeShipping = eligibleForFreeShipping;
    }

    public Boolean getItemLevelFreeShip() {
        return itemLevelFreeShip;
    }

    @JacksonXmlProperty
    public void setItemLevelFreeShip(Boolean itemLevelFreeShip) {
        this.itemLevelFreeShip = itemLevelFreeShip;
    }

    public String getFreeShippingMessage() {
        return freeShippingMessage;
    }

    @JacksonXmlProperty
    public void setFreeShippingMessage(String freeShippingMessage) {
        this.freeShippingMessage = freeShippingMessage;
    }

    public String getFreeShippingMessageKey() {
        return freeShippingMessageKey;
    }

    public void setFreeShippingMessageKey(String freeShippingMessageKey) {
        this.freeShippingMessageKey = freeShippingMessageKey;
    }

    public Boolean getBossItemLevelFreeShipElg() {
        return bossItemLevelFreeShipElg;
    }

    @JacksonXmlProperty
    public void setBossItemLevelFreeShipElg(Boolean bossItemLevelFreeShipElg) {
        this.bossItemLevelFreeShipElg = bossItemLevelFreeShipElg;
    }

    public Date getSthEstimatedShippingStartDate() {
        return sthEstimatedShippingStartDate;
    }

    @JacksonXmlProperty
    public void setSthEstimatedShippingStartDate(Date sthEstimatedShippingStartDate) {
        this.sthEstimatedShippingStartDate = sthEstimatedShippingStartDate;
    }

    public Date getSthEstimatedShippingEndDate() {
        return sthEstimatedShippingEndDate;
    }

    @JacksonXmlProperty
    public void setSthEstimatedShippingEndDate(Date sthEstimatedShippingEndDate) {
        this.sthEstimatedShippingEndDate = sthEstimatedShippingEndDate;
    }

    public Date getBossEstimatedShippingStartDate() {
        return bossEstimatedShippingStartDate;
    }

    @JacksonXmlProperty
    public void setBossEstimatedShippingStartDate(Date bossEstimatedShippingStartDate) {
        this.bossEstimatedShippingStartDate = bossEstimatedShippingStartDate;
    }

    public Date getBossEstimatedShippingEndDate() {
        return bossEstimatedShippingEndDate;
    }

    @JacksonXmlProperty
    public void setBossEstimatedShippingEndDate(Date bossEstimatedShippingEndDate) {
        this.bossEstimatedShippingEndDate = bossEstimatedShippingEndDate;
    }

    public Boolean getIsDynamicEta() {
        return isDynamicEta;
    }

    @JacksonXmlProperty
    public void setIsDynamicEta(Boolean isDynamicEta) {
        this.isDynamicEta = isDynamicEta;
    }

    public String getDynamicEtaTimeLeftHrs() {
        return dynamicEtaTimeLeftHrs;
    }

    @JacksonXmlProperty
    public void setDynamicEtaTimeLeftHrs(String dynamicEtaTimeLeftHrs) {
        this.dynamicEtaTimeLeftHrs = dynamicEtaTimeLeftHrs;
    }

    public String getDynamicEtaTimeLeftMins() {
        return dynamicEtaTimeLeftMins;
    }

    @JacksonXmlProperty
    public void setDynamicEtaTimeLeftMins(String dynamicEtaTimeLeftMins) {
        this.dynamicEtaTimeLeftMins = dynamicEtaTimeLeftMins;
    }
}
