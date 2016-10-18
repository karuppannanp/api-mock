package com.homedepot.pip.backend.domain;

import com.homedepot.pip.backend.domain.item.Item;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;


public class Product {
    private String productId;
    private Boolean superSku;
    private String defaultItemId;
    private ArrayList<Item> items = new ArrayList<Item>();

    public String getDefaultItemId() {
        return defaultItemId;
    }

    @JacksonXmlProperty(localName = "defaultSku")
    public void setDefaultItemId(String defaultItemId) {
        this.defaultItemId = defaultItemId;
    }

    public String getProductId() {
        return productId;
    }

    @JacksonXmlProperty
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @JacksonXmlProperty(localName = "sku")
    @JacksonXmlElementWrapper(localName = "skus")
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Boolean getSuperSku() {
        return superSku;
    }

    @JacksonXmlProperty
    public void setSuperSku(Boolean superSku) {
        this.superSku = superSku;
    }
}