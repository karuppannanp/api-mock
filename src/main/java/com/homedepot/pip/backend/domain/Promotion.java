package com.homedepot.pip.backend.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Promotion {

	private String promoCatentryId;
    private String promoCode;
    private String promoDescription;
    private String promoUrl;
    private String discountStartDate;
    private String discountEndDate;
    private String promoType;
    private String promoLongDescription;

    public String getPromoLongDescription() {
        return promoLongDescription;
    }

    @JacksonXmlProperty
    public void setPromoLongDescription(String promoLongDescription) {
        this.promoLongDescription = promoLongDescription;
    }

    public String getPromoType() {
        return promoType;
    }

    @JacksonXmlProperty
    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public String getPromoCode() {
        return promoCode;
    }

    @JacksonXmlProperty
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    @JacksonXmlProperty
    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    public String getPromoUrl() {
        return promoUrl;
    }

    @JacksonXmlProperty
    public void setPromoUrl(String promoUrl) {
        this.promoUrl = promoUrl;
    }

    public String getDiscountStartDate() {
        return discountStartDate;
    }

    @JacksonXmlProperty
    public void setDiscountStartDate(String discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public String getDiscountEndDate() {
        return discountEndDate;
    }

    @JacksonXmlProperty
    public void setDiscountEndDate(String discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public String getPromoCatentryId() {
        return promoCatentryId;
    }

    @JacksonXmlProperty
    public void setPromoCatentryId(String promoCatentryId) {
        this.promoCatentryId = promoCatentryId;
    }
}