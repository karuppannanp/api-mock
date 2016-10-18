package com.homedepot.pip.backend.domain.relateditem;

import com.homedepot.pip.backend.domain.item.Item;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RelatedItem {
    private Item item;

    public Item getItem() {
        return item;
    }

    @JacksonXmlProperty
    public void setItem(Item item) {
        this.item = item;
    }
}
