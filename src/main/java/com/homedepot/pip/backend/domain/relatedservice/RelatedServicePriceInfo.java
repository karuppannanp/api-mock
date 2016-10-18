package com.homedepot.pip.backend.domain.relatedservice;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RelatedServicePriceInfo {
    private Double price;

    public Double getPrice() {
        return price;
    }

    @JacksonXmlProperty
    public void setPrice(Double price) {
        this.price = price;
    }
}
