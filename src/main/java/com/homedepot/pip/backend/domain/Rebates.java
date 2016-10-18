package com.homedepot.pip.backend.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Rebates {

    private Boolean hasEcoRebates;

    public Boolean getHasEcoRebates() {
        return hasEcoRebates;
    }

    @JacksonXmlProperty
    public void setHasEcoRebates(Boolean hasEcoRebates) {
        this.hasEcoRebates = hasEcoRebates;
    }
}
