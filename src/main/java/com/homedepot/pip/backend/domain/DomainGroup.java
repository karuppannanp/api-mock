package com.homedepot.pip.backend.domain;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DomainGroup {

    protected String groupType;

    private ArrayList<?> groupList;

    public String getGroupType() {
        return groupType;
    }

    @JacksonXmlProperty
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public ArrayList<?> getGroupList() {
        return groupList;
    }

    @JacksonXmlProperty(localName = "attribute")
    @JacksonXmlElementWrapper(localName = "entries")
    public void setGroupList(ArrayList<?> groupList) {
        this.groupList = groupList;
    }


}
