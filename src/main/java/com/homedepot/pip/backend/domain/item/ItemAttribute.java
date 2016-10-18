package com.homedepot.pip.backend.domain.item;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.HashMap;
import java.util.Map;

public class ItemAttribute {

    private static Map<String, String> itemPropValueMap = new HashMap<String, String>();

    private String name;
    private String value;
    private String guid;
    private Boolean bulletedAttr;
    private String url;

    static {
        itemPropValueMap.put("Assembled Depth (in.)", "depth");
        itemPropValueMap.put("Color Family", "color");
        itemPropValueMap.put("Assembled Height (in.)", "height");
        itemPropValueMap.put("Product Weight (lb.)", "weight");
        itemPropValueMap.put("Assembled Width (in.)", "width");
    }

    public String getItemPropValueMapKey() {
        return itemPropValueMap.get(name);
    }

    @JacksonXmlProperty
    public void setName(String name) {
        this.name = name;
    }

    @JacksonXmlProperty
    public void setValue(String value) {
        this.value = value;
    }

    public String getGuid() {
        return guid;
    }

    @JacksonXmlProperty
    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Boolean isBulletedAttr() {
        return bulletedAttr;
    }

    @JacksonXmlProperty
    public void setBulletedAttr(Boolean bulletedAttr) {
        this.bulletedAttr = bulletedAttr;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getUrl() {
        return url;
    }

    @JacksonXmlProperty
    public void setUrl(String url) {
        this.url = url;
    }
}