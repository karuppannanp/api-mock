package com.homedepot.pip.backend.domain.item;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import org.apache.commons.lang3.ObjectUtils;

public class ItemPrice {

    private String storeId;
    private String skuNumber;
    private String uom;
    private String unitsPerCase;
    private String caseUnitUom;
    private Double originalPrice;
    private Double specialPrice;
    private Double specialBuyPrice;
    private Boolean alternatePriceDisplay;
    private Boolean lowerPrice;
    private String unitOriginalPrice;
    private String unitSpecialPrice;
    private Double bulkPrice;
    private Double bulkPriceThresholdQty;
    private Double dollarOff;
    private Double percentageOff;
    private String pricingMessage;
    private Double specialBuySavings;
    private Double specialBuyDollarOff;
    private Double specialBuyPercentageOff;
    private Boolean mapAboveOriginalPrice;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(String skuNumber) {
        this.skuNumber = skuNumber;
    }

    public String getUom() {
        return uom;
    }

    @JacksonXmlProperty
    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getUnitsPerCase() {
        return unitsPerCase;
    }

    @JacksonXmlProperty
    public void setUnitsPerCase(String unitsPerCase) {
        this.unitsPerCase = unitsPerCase;
    }

    public String getCaseUnitUom() {
        return caseUnitUom;
    }

    @JacksonXmlProperty
    public void setCaseUnitUom(String caseUnitUom) {
        this.caseUnitUom = caseUnitUom;
    }

    // Leave commented out for now.  Two different propery name declarations in products-binding-1.0.xml.
    // @JsonProperty("price")
    public Double getOriginalPrice() {
        return originalPrice;
    }

    @JacksonXmlProperty
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }

    @JacksonXmlProperty
    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Boolean getAlternatePriceDisplay() {
        return alternatePriceDisplay;
    }

    @JacksonXmlProperty(localName = "alternatePricingDisplay")
    public void setAlternatePriceDisplay(Boolean alternatePriceDisplay) {
        this.alternatePriceDisplay = alternatePriceDisplay;
    }

    public Boolean getLowerPrice() {
        return lowerPrice;
    }

    public Boolean getItemOnSale() {
    	return ObjectUtils.compare(originalPrice, specialPrice) > 0;
    }

    @JacksonXmlProperty
    public void setLowerPrice(Boolean lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    // PIP Enhancement - Formatted Price fields
    public String getUnitOriginalPrice() {
        return unitOriginalPrice;
    }

    @JacksonXmlProperty
    public void setUnitOriginalPrice(String unitOriginalPrice) {
        this.unitOriginalPrice = unitOriginalPrice;
    }

    public String getUnitSpecialPrice() {
        return unitSpecialPrice;
    }

    @JacksonXmlProperty
    public void setUnitSpecialPrice(String unitSpecialPrice) {
        this.unitSpecialPrice = unitSpecialPrice;
    }

    public Double getBulkPrice() {
        return bulkPrice;
    }

    @JacksonXmlProperty
    public void setBulkPrice(Double bulkPrice) {
        this.bulkPrice = bulkPrice;
    }

    public Double getBulkPriceThresholdQty() {
        return bulkPriceThresholdQty;
    }

    @JacksonXmlProperty
    public void setBulkPriceThresholdQty(Double bulkPriceThresholdQty) {
        this.bulkPriceThresholdQty = bulkPriceThresholdQty;
    }

    public Double getDollarOff() {
        return dollarOff;
    }

    @JacksonXmlProperty
    public void setDollarOff(Double dollarOff) {
        this.dollarOff = dollarOff;
    }

    public Double getPercentageOff() {
        return percentageOff;
    }

    @JacksonXmlProperty
    public void setPercentageOff(Double percentageOff) {
        this.percentageOff = percentageOff;
    }

    public String getPricingMessage() {
        return pricingMessage;
    }

    @JacksonXmlProperty
    public void setPricingMessage(String pricingMessage) {
        this.pricingMessage = pricingMessage;
    }

    public Double getSpecialBuyPrice() {
        return specialBuyPrice;
    }

    @JacksonXmlProperty
    public void setSpecialBuyPrice(Double specialBuyPrice) {
        this.specialBuyPrice = specialBuyPrice;
    }

    public Double getSpecialBuyDollarOff() {
        return specialBuyDollarOff;
    }

    @JacksonXmlProperty
    public void setSpecialBuyDollarOff(Double specialBuyDollarOff) {
        this.specialBuyDollarOff = specialBuyDollarOff;
    }

    public Double getSpecialBuyPercentageOff() {
        return specialBuyPercentageOff;
    }

    @JacksonXmlProperty
    public void setSpecialBuyPercentageOff(Double specialBuyPercentageOff) {
        this.specialBuyPercentageOff = specialBuyPercentageOff;
    }

    public Double getSpecialBuySavings() {
        return specialBuySavings;
    }

    @JacksonXmlProperty
    public void setSpecialBuySavings(Double specialBuySavings) {
        this.specialBuySavings = specialBuySavings;
    }

    public Boolean getMapAboveOriginalPrice() {
        return mapAboveOriginalPrice;
    }

    @JacksonXmlProperty
    public void setMapAboveOriginalPrice(Boolean mapAboveOriginalPrice) {
        this.mapAboveOriginalPrice = mapAboveOriginalPrice;
    }
}