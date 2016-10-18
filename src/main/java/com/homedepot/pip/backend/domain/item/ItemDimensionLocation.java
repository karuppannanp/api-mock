package com.homedepot.pip.backend.domain.item;

import com.homedepot.pip.backend.domain.DimensionAncestor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class ItemDimensionLocation {

    private String dimensionName;
    private Long dimensionId;
    private ItemDimensionValue itemDimensionValue;
    private ArrayList<DimensionAncestor> ancestors;
    private Boolean isDefaultBreadCrumb;

    public String getDimensionName() {
        return dimensionName;
    }

    @JacksonXmlProperty
    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    public Long getDimensionId() {
        return dimensionId;
    }

    public Boolean getIsDefaultBreadCrumb() {
        return isDefaultBreadCrumb;
    }

    @JacksonXmlProperty
    public void setIsDefaultBreadCrumb(Boolean isDefaultBreadCrumb) {
        this.isDefaultBreadCrumb = isDefaultBreadCrumb;
    }

    @JacksonXmlProperty
    public void setDimensionId(Long dimensionId) {
        this.dimensionId = dimensionId;
    }

    public ItemDimensionValue getItemDimensionValue() {
        return itemDimensionValue;
    }

    @JacksonXmlProperty(localName = "dimensionValue")
    public void setItemDimensionValue(ItemDimensionValue itemDimensionValue) {
        this.itemDimensionValue = itemDimensionValue;
    }

    public ArrayList<DimensionAncestor> getAncestors() {
        return ancestors;
    }

    @JacksonXmlProperty(localName = "entries")
    @JacksonXmlElementWrapper(localName = "ancestors")
    public void setAncestors(ArrayList<DimensionAncestor> ancestors) {
        this.ancestors = ancestors;
    }

}
