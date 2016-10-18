package com.homedepot.pip.backend.domain.item;


import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ItemDefiningAttribute  {

    private String attributeName;
    private String attributeValue;
    private String attributeSwatch;
    private Integer attributeValueSeqNum;

    public String getAttributeName() {
        return attributeName;
    }

    @JacksonXmlProperty
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    @JacksonXmlProperty
    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getAttributeSwatch() {
        return attributeSwatch;
    }

    @JacksonXmlProperty
    public void setAttributeSwatch(String attributeSwatch) {
        // HD_Integration is returning "null" as String in case if swatch is null.
        if (!StringUtils.equals(attributeSwatch, "null"))
            this.attributeSwatch = attributeSwatch;
    }

    public Integer getAttributeValueSeqNum() {
        return attributeValueSeqNum;
    }

    @JacksonXmlProperty
    public void setAttributeValueSeqNum(Integer attributeValueSeqNum) {
        this.attributeValueSeqNum = attributeValueSeqNum;
    }

}
