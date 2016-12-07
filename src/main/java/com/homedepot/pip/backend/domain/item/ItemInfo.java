package com.homedepot.pip.backend.domain.item;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


@JsonPropertyOrder({ "productDescription", "productTitle", "brandName", "label", "modelNumber", "upcCode",
		"vendorNumber", "storeSkuNumber", "shipType", "productClass", "productSubClass", "productDepartment",
		"backorderFlag", "genericBrandFlag", "appliance", "showProduct", "bopisEligible", "bossEligible", "topSeller",
		"showLocalPrice", "savingsCenter", "sureFit", "hasIrgItems", "hasFbtItems", "hasFbrItems", "hidePrice" })
public class ItemInfo {

    private String productDescription;
    private String productTitle;
    private String brandName;
    private String label;
    private String modelNumber;
    private String vendorNumber;
    private String upcCode;
    private String productSubClass;
    private String productDepartment;
    private String qtyLimit;
    private int shipType;
    private String primaryCategoryId;
    private String storeSkuNumber;
    private String productClass;
    private String hazardCode;
    private LocalDate backorderExpectedShipDate;
    private String specialOrderSKU;
    private Boolean appliance;
    private Boolean showProduct;
    private Boolean topSeller;
    private Boolean bopisEligible;
    private Boolean bossEligible;
    private boolean onlineStatus;

    private Boolean backorderFlag;
    private Boolean genericBrandFlag;
    private Boolean showLocalPrice;
    private String savingsCenter;
    private Boolean sureFit;
    private Boolean hasIrgItems;
    private Boolean hasFbtItems;
    private Boolean hasFbrItems;
    private Boolean hidePrice;

    public String getProductDescription() {
        return productDescription;
    }

    @JacksonXmlProperty(localName ="description")
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    @JacksonXmlProperty
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    @JacksonXmlProperty
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    @JacksonXmlProperty
    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public String getProductSubClass() {
        return productSubClass;
    }

    @JacksonXmlProperty
    public void setProductSubClass(String productSubClass) {
        this.productSubClass = productSubClass;
    }

    public String getQtyLimit() {
        return qtyLimit;
    }

    @JacksonXmlProperty(localName ="quantityLimit")
    public void setQtyLimit(String qtyLimit) {
        this.qtyLimit = qtyLimit;
    }

    public int getShipType() {
        return shipType;
    }

    @JacksonXmlProperty
    public void setShipType(int shipType) {
        this.shipType = shipType;
    }

    public String getPrimaryCategoryId() {
        return primaryCategoryId;
    }

    @JacksonXmlProperty
    public void setPrimaryCategoryId(String primaryCategoryId) {
        this.primaryCategoryId = primaryCategoryId;
    }

    public String getStoreSkuNumber() {
        return storeSkuNumber;
    }

    @JacksonXmlProperty
    public void setStoreSkuNumber(String storeSkuNumber) {
        this.storeSkuNumber = storeSkuNumber;
    }

    public String getLabel() {
        return label;
    }

    @JacksonXmlProperty(localName ="productLabel")
    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getAppliance() {
        return appliance;
    }

    @JacksonXmlProperty(localName ="isAppliance")
    public void setAppliance(Boolean appliance) {
        this.appliance = appliance;
    }

    public Boolean getTopSeller() {
        return topSeller;
    }

    @JacksonXmlProperty(localName ="isTopSeller")
    public void setTopSeller(Boolean topSeller) {
        this.topSeller = topSeller;
    }

    public Boolean getBopisEligible() {
        return bopisEligible;
    }

    @JacksonXmlProperty(localName ="buyOnlinePickupInStoreEligible")
    public void setBopisEligible(Boolean bopisEligible) {
        this.bopisEligible = bopisEligible;
    }

    public Boolean getBossEligible() {
        return bossEligible;
    }

    @JacksonXmlProperty(localName ="buyOnlineShipToStoreEligible")
    public void setBossEligible(Boolean bossEligible) {
        this.bossEligible = bossEligible;
    }

    public Boolean getGenericBrandFlag() {
        return genericBrandFlag;
    }

    @JacksonXmlProperty
    public void setGenericBrandFlag(Boolean genericBrandFlag) {
        this.genericBrandFlag = genericBrandFlag;
    }

    public LocalDate getBackorderExpectedShipDate() {
        return backorderExpectedShipDate;
    }

    @JacksonXmlProperty(localName ="packorderExpectedShipDate")
    public void setBackorderExpectedShipDate(LocalDate backorderExpectedShipDate) {
        this.backorderExpectedShipDate = backorderExpectedShipDate;
    }

    public String getUpcCode() {
        return upcCode;
    }

    @JacksonXmlProperty(localName ="upc")
    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public String getSavingsCenter() {
        return savingsCenter;
    }

    @JacksonXmlProperty
    public void setSavingsCenter(String savingsCenter) {
        this.savingsCenter = savingsCenter;
    }

    public Boolean getSureFit() {
        return sureFit;
    }

    @JacksonXmlProperty
    public void setSureFit(Boolean sureFit) {
        this.sureFit = sureFit;
    }

    public Boolean getHasIrgItems() {
        return hasIrgItems;
    }

    @JacksonXmlProperty
    public void setHasIrgItems(Boolean hasIrgItems) {
        this.hasIrgItems = hasIrgItems;
    }

    public Boolean getHasFbtItems() {
        return hasFbtItems;
    }

    @JacksonXmlProperty
    public void setHasFbtItems(Boolean hasFbtItems) {
        this.hasFbtItems = hasFbtItems;
    }

    public Boolean getHidePrice() {
        return hidePrice;
    }

    @JacksonXmlProperty
    public void setHidePrice(Boolean hidePrice) {
        this.hidePrice = hidePrice;
    }

    public Boolean getHasFbrItems() {
        return hasFbrItems;
    }

    @JacksonXmlProperty
    public void setHasFbrItems(Boolean hasFbrItems) {
        this.hasFbrItems = hasFbrItems;
    }

    public String getProductTitle() {
        return productTitle;
    }

    @JacksonXmlProperty(localName ="title")
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getHazardCode() {
        return hazardCode;
    }

    @JacksonXmlProperty
    public void setHazardCode(String hazardCode) {
        this.hazardCode = hazardCode;
    }

    public String getSpecialOrderSKU() {
        return specialOrderSKU;
    }

    @JacksonXmlProperty
    public void setSpecialOrderSKU(String specialOrderSKU) {
        this.specialOrderSKU = specialOrderSKU;
    }

    public Boolean getShowProduct() {
        return showProduct;
    }

    @JacksonXmlProperty
    public void setShowProduct(Boolean showProduct) {
        this.showProduct = showProduct;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    @JacksonXmlProperty
    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Boolean getBackorderFlag() {
        return backorderFlag;
    }

    @JacksonXmlProperty(localName ="backOrderFlag")
    public void setBackorderFlag(Boolean backorderFlag) {
        this.backorderFlag = backorderFlag;
    }

    public Boolean getShowLocalPrice() {
        return showLocalPrice;
    }

    @JacksonXmlProperty
    public void setShowLocalPrice(Boolean showLocalPrice) {
        this.showLocalPrice = showLocalPrice;
    }

    public String getProductClass() {
        return productClass;
    }

    @JacksonXmlProperty
    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

	public String getProductDepartment() {
		return productDepartment;
	}

	public void setProductDepartment(String productDepartment) {
		this.productDepartment = productDepartment;
	}
}
