package com.homedepot.pip.backend.domain.relatedservice;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RelatedServiceGroup {

    private String storeId;
    private String zipCode;
    private ArrayList<RelatedService> relatedServices;
    private String errorCode;
    private String errorMessage;

    public String getStoreId() {
        return storeId;
    }

    @JacksonXmlProperty
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getZipCode() {
        return zipCode;
    }

    @JacksonXmlProperty
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ArrayList<RelatedService> getRelatedServices() {
        return relatedServices;
    }

    @JacksonXmlProperty(localName = "relatedService")
    @JacksonXmlElementWrapper(localName = "relatedServices")
    public void setRelatedServices(ArrayList<RelatedService> relatedServices) {
        this.relatedServices = relatedServices;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @JacksonXmlProperty
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @JacksonXmlProperty
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
