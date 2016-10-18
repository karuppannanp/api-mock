package com.homedepot.pip.backend.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import com.homedepot.pip.backend.domain.fullfillment.FulfillmentOptions;
import com.homedepot.pip.backend.domain.item.ItemInventory;
import com.homedepot.pip.backend.domain.item.ItemPrice;
import com.homedepot.pip.enums.StoreStatusType;

public class StoreSku {

    //API Sku call fields
    private String storeId;
    private Boolean storeStatus;
    private StorePromotion storePromotion;
    private FulfillmentOptions fulfillmentOptions;
    private ItemPrice itemPrice;
    private StoreAvailability storeAvailability;
    private ItemInventory itemInventory;
    private AisleInfo aisleInfo;
    private String itemId;

    //Other API call fields
    private String storeSkuNumber;
    private boolean lowerPriceFlag = false;
    private StoreStatusType storeStatusType;
    private Boolean inventoryAvailable;

    public String getStoreId() {
        return storeId;
    }

    @JacksonXmlProperty
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Boolean getStoreStatus() {
        return storeStatus;
    }

    @JacksonXmlProperty
    public void setStoreStatus(Boolean storeStatus) {
        this.storeStatus = storeStatus;
    }

    public StorePromotion getStorePromotion() {
        return storePromotion;
    }

    @JacksonXmlProperty
    public void setStorePromotion(StorePromotion storePromotion) {
        this.storePromotion = storePromotion;
    }

    public FulfillmentOptions getFulfillmentOptions() {
        return fulfillmentOptions;
    }

    @JacksonXmlProperty
    public void setFulfillmentOptions(FulfillmentOptions fulfillmentOptions) {
        this.fulfillmentOptions = fulfillmentOptions;
    }

    public ItemPrice getItemPrice() {
        return itemPrice;
    }

    @JacksonXmlProperty(localName = "pricing")
    public void setItemPrice(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;
    }

    public StoreAvailability getStoreAvailability() {
        return storeAvailability;
    }

    @JacksonXmlProperty
    public void setStoreAvailability(StoreAvailability storeAvailability) {
        this.storeAvailability = storeAvailability;
    }

    public ItemInventory getItemInventory() {
        return itemInventory;
    }

    @JacksonXmlProperty(localName = "inventory")
    public void setItemInventory(ItemInventory itemInventory) {
        this.itemInventory = itemInventory;
    }

    public AisleInfo getAisleInfo() {
        return aisleInfo;
    }

    @JacksonXmlProperty(localName = "aisleBinInfo")
    public void setAisleInfo(AisleInfo aisleInfo) {
        this.aisleInfo = aisleInfo;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getStoreSkuNumber() {
        return storeSkuNumber;
    }

    public void setStoreSkuNumber(String storeSkuNumber) {
        this.storeSkuNumber = storeSkuNumber;
    }

    public boolean isLowerPriceFlag() {
        return lowerPriceFlag;
    }

    public void setLowerPriceFlag(boolean lowerPriceFlag) {
        this.lowerPriceFlag = lowerPriceFlag;
    }

    public StoreStatusType getStoreStatusType() {
        return storeStatusType;
    }

    @JacksonXmlProperty
    public void setStoreStatusType(StoreStatusType storeStatusType) {
        this.storeStatusType = storeStatusType;
    }

    public Boolean getInventoryAvailable() {
        return inventoryAvailable;
    }

    public void setInventoryAvailable(Boolean inventoryAvailable) {
        this.inventoryAvailable = inventoryAvailable;
    }
}