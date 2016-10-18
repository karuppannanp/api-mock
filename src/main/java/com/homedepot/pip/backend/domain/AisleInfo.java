package com.homedepot.pip.backend.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AisleInfo {

    private String itemId;
    private String localStoreId;
    private String aisle;
    private String productLocationText;
    private String bin;
    private String productLocationDesc;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getLocalStoreId() {
        return localStoreId;
    }

    public void setLocalStoreId(String localStoreId) {
        this.localStoreId = localStoreId;
    }

    public String getAisle() {
        return aisle;
    }

    @JacksonXmlProperty
    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getProductLocationText() {
        return productLocationText;
    }

    @JacksonXmlProperty
    public void setProductLocationText(String productLocationText) {
        this.productLocationText = productLocationText;
    }

    public String getBin() {
        return bin;
    }

    @JacksonXmlProperty
    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getProductLocationDesc() {
        return productLocationDesc;
    }

    @JacksonXmlProperty
    public void setProductLocationDesc(String productLocationDesc) {
        this.productLocationDesc = productLocationDesc;
    }


}
