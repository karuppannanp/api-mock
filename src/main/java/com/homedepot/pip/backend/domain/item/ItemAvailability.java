package com.homedepot.pip.backend.domain.item;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonPropertyOrder({ "buyable", "availableOnlineStore", "availableInStore", "inventoryStatus", "backorderable",
		"published", "discontinuedItem" })
public class ItemAvailability {
    private Boolean buyable;
    private Boolean availableOnlineStore;
    private Boolean availableInStore;
    private Boolean inventoryStatus;
    private Boolean backorderable;
    private Boolean published;
    private Boolean discontinuedItem;

    public Boolean getDiscontinuedItem() {
        return discontinuedItem;
    }

    @JacksonXmlProperty
    public void setDiscontinuedItem(Boolean discontinuedItem) {
        this.discontinuedItem = discontinuedItem;
    }

    public Boolean getBuyable() {
        return buyable;
    }

    @JacksonXmlProperty
    public void setBuyable(Boolean buyable) {
        this.buyable = buyable;
    }

    public Boolean getAvailableOnlineStore() {
        return availableOnlineStore;
    }

    @JacksonXmlProperty
    public void setAvailableOnlineStore(Boolean availableOnlineStore) {
        this.availableOnlineStore = availableOnlineStore;
    }

    public Boolean getAvailableInStore() {
        return availableInStore;
    }

    @JacksonXmlProperty
    public void setAvailableInStore(Boolean availableInStore) {
        this.availableInStore = availableInStore;
    }

    public Boolean getInventoryStatus() {
        return inventoryStatus;
    }

    @JacksonXmlProperty
    public void setInventoryStatus(Boolean inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public Boolean getBackorderable() {
        return backorderable;
    }

    @JacksonXmlProperty
    public void setBackorderable(Boolean backorderable) {
        this.backorderable = backorderable;
    }

    public Boolean getPublished() {
        return published;
    }

    @JacksonXmlProperty
    public void setPublished(Boolean published) {
        this.published = published;
    }
}
