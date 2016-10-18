package com.homedepot.pip.backend.domain.relatedservice;

import com.homedepot.pip.backend.domain.PartsAndServiceInfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RelatedService {

    private String itemId;
    private RelatedServiceType relatedServiceType;
    private String storeSkuNumber;
    private Double additionalDeliveryHours;
    private String marketNumber;
    private PartsAndServiceInfo partsAndServiceInfo;
    private RelatedServicePriceInfo priceInfo;
    private Boolean isHookup;
    private Boolean isInstall;

    public String getItemId() {
        return itemId;
    }

    @JacksonXmlProperty
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public RelatedServiceType getRelatedServiceType() {
        return relatedServiceType;
    }

    @JacksonXmlProperty
    public void setRelatedServiceType(RelatedServiceType relatedServiceType) {
        this.relatedServiceType = relatedServiceType;
    }

    public String getStoreSkuNumber() {
        return storeSkuNumber;
    }

    @JacksonXmlProperty
    public void setStoreSkuNumber(String storeSkuNumber) {
        this.storeSkuNumber = storeSkuNumber;
    }

    public Double getAdditionalDeliveryHours() {
        return additionalDeliveryHours;
    }

    @JacksonXmlProperty
    public void setAdditionalDeliveryHours(Double additionalDeliveryHours) {
        this.additionalDeliveryHours = additionalDeliveryHours;
    }

    public String getMarketNumber() {
        return marketNumber;
    }

    @JacksonXmlProperty
    public void setMarketNumber(String marketNumber) {
        this.marketNumber = marketNumber;
    }

    public PartsAndServiceInfo getPartsAndServiceInfo() {
        return partsAndServiceInfo;
    }

    @JacksonXmlProperty
    public void setPartsAndServiceInfo(PartsAndServiceInfo partsAndServiceInfo) {
        this.partsAndServiceInfo = partsAndServiceInfo;
    }

    public RelatedServicePriceInfo getPriceInfo() {
        return priceInfo;
    }

    @JacksonXmlProperty
    public void setPriceInfo(RelatedServicePriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    public Boolean getIsHookup() {
        return isHookup;
    }

    @JacksonXmlProperty(localName = "hookup")
    public void setIsHookup(Boolean isHookup) {
        this.isHookup = isHookup;
    }

    public Boolean getIsInstall() {
        return isInstall;
    }

    @JacksonXmlProperty(localName = "install")
    public void setIsInstall(Boolean isInstall) {
        this.isInstall = isInstall;
    }
}
