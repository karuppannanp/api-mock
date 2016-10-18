package com.homedepot.pip.backend.domain;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DimensionAncestor {
    private String name;
    private Long id;
    private String url;

    public String getName() {
        return name;
    }

    @JacksonXmlProperty
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @JacksonXmlProperty
    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    @JacksonXmlProperty
    public void setUrl(String url) {
        this.url = url;
    }
}
