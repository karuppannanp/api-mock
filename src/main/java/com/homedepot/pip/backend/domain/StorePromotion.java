package com.homedepot.pip.backend.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StorePromotion {

    private String longDescription;
    private String shortDescription;

    public String getLongDescription() {
        return longDescription;
    }

    @JacksonXmlProperty
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    @JacksonXmlProperty
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

}
