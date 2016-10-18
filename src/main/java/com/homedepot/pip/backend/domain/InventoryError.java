package com.homedepot.pip.backend.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class InventoryError {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    @JacksonXmlProperty
    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    @JacksonXmlProperty
    public void setMessage(String message) {
        this.message = message;
    }
}
