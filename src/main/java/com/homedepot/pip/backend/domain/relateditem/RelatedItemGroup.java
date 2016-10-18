package com.homedepot.pip.backend.domain.relateditem;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

public class RelatedItemGroup {

    private String groupType;

    private List<RelatedItem> groupList;

    public String getGroupType() {
        return groupType;
    }

    @JacksonXmlProperty
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public List<RelatedItem> getGroupList() {
        return groupList;
    }

    @JacksonXmlProperty(localName = "item")
    @JacksonXmlElementWrapper(localName = "groupItemIds")
    public void setGroupList(List<RelatedItem> groupList) {
        this.groupList = groupList;
    }
}
