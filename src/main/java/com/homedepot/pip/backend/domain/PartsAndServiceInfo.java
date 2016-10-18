package com.homedepot.pip.backend.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PartsAndServiceInfo {
    private String description;
    private String classNumber;
    private String subClassNumber;
    private String vendorNumber;

    public String getDescription() {
        return description;
    }

    @JacksonXmlProperty
    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassNumber() {
        return classNumber;
    }

    @JacksonXmlProperty
    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getSubClassNumber() {
        return subClassNumber;
    }

    @JacksonXmlProperty
    public void setSubClassNumber(String subClassNumber) {
        this.subClassNumber = subClassNumber;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    @JacksonXmlProperty
    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }
}
