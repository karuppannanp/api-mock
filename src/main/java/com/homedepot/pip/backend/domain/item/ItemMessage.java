package com.homedepot.pip.backend.domain.item;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ItemMessage {

    private String msgKey;
    private String msgValue;

    public String getMsgKey() {
        return msgKey;
    }

    @JacksonXmlProperty(localName = "messageKey")
    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }

    public String getMsgValue() {
        return msgValue;
    }

    @JacksonXmlProperty(localName = "messageValue")
    public void setMsgValue(String msgValue) {
        this.msgValue = msgValue;
    }

}
