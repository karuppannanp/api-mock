package com.homedepot.pip.backend.domain.fullfillment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FulfillmentOptions {

    private Boolean fulfillable;

    private BOPISFulfillmentOption buyOnlinePickupInStore;

    private BOSSFulfillmentOption buyOnlineShipToStore;

    private BODFSFulfillmentOption deliverFromStore;

    private STHFulfillmentOption shipToHome;

    private FulfillmentAvailabilityMessages availabilityMessages;

    public FulfillmentAvailabilityMessages getAvailabilityMessages() {
        return availabilityMessages;
    }

    @JacksonXmlProperty
    public void setAvailabilityMessages(
            FulfillmentAvailabilityMessages availabilityMessages) {
        this.availabilityMessages = availabilityMessages;
    }

    public BOPISFulfillmentOption getBuyOnlinePickupInStore() {
        return buyOnlinePickupInStore;
    }

    @JacksonXmlProperty
    public void setBuyOnlinePickupInStore(
            BOPISFulfillmentOption buyOnlinePickupInStore) {
        this.buyOnlinePickupInStore = buyOnlinePickupInStore;
    }

    public BOSSFulfillmentOption getBuyOnlineShipToStore() {
        return buyOnlineShipToStore;
    }

    @JacksonXmlProperty
    public void setBuyOnlineShipToStore(BOSSFulfillmentOption buyOnlineShipToStore) {
        this.buyOnlineShipToStore = buyOnlineShipToStore;
    }

    public Boolean getFulfillable() {
        return fulfillable;
    }

    @JacksonXmlProperty
    public void setFulfillable(Boolean fulfillable) {
        this.fulfillable = fulfillable;
    }

    public BODFSFulfillmentOption getDeliverFromStore() {
        return deliverFromStore;
    }

    @JacksonXmlProperty
    public void setDeliverFromStore(BODFSFulfillmentOption deliverFromStore) {
        this.deliverFromStore = deliverFromStore;
    }

    public STHFulfillmentOption getShipToHome() {
        return shipToHome;
    }

    @JacksonXmlProperty
    public void setShipToHome(STHFulfillmentOption shipToHome) {
        this.shipToHome = shipToHome;
    }

}
