package com.homedepot.pip.backend.domain;

import com.homedepot.pip.backend.domain.item.ItemMessage;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;

public class StoreAvailability {
    private Boolean availableInLocalStore;
    private Boolean itemAvailable;
    private ArrayList<ItemMessage> itemAvilabilityMsgs;
    private Boolean bossElgStore;
    private Boolean bossMsgElgStore;
    private Boolean bopisElgStore;

    public Boolean getBossElgStore() {
        return bossElgStore;
    }

    @JacksonXmlProperty
    public void setBossElgStore(Boolean bossElgStore) {
        this.bossElgStore = bossElgStore;
    }

    public Boolean getBossMsgElgStore() {
        return bossMsgElgStore;
    }

    @JacksonXmlProperty
    public void setBossMsgElgStore(Boolean bossMsgElgStore) {
        this.bossMsgElgStore = bossMsgElgStore;
    }

    public Boolean getAvailableInLocalStore() {
        return availableInLocalStore;
    }

    @JacksonXmlProperty
    public void setAvailableInLocalStore(Boolean availableInLocalStore) {
        this.availableInLocalStore = availableInLocalStore;
    }

    public Boolean getItemAvailable() {
        return itemAvailable;
    }

    @JacksonXmlProperty
    public void setItemAvailable(Boolean itemAvailable) {
        this.itemAvailable = itemAvailable;
    }

    public ArrayList<ItemMessage> getItemAvilabilityMsgs() {
        return itemAvilabilityMsgs;
    }

    @JacksonXmlProperty(localName = "availabilityMessageEntry")
    @JacksonXmlElementWrapper(localName = "itemAvilabilityMessages")
    public void setItemAvilabilityMsgs(ArrayList<ItemMessage> itemAvilabilityMsgs) {
        this.itemAvilabilityMsgs = itemAvilabilityMsgs;
    }

    public Boolean getBopisElgStore() {
        return bopisElgStore;
    }

    @JacksonXmlProperty
    public void setBopisElgStore(Boolean bopisElgStore) {
        this.bopisElgStore = bopisElgStore;
    }
}
