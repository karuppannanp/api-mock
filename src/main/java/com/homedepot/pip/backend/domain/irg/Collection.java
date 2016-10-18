package com.homedepot.pip.backend.domain.irg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "collection")
public class Collection {

    private ArrayList<IRGItem> items = null;
    private String[] irgIds = null;

    public String[] getIrgIds() {
        return irgIds;
    }

    @XmlElement(name = "irgId", type = String.class)
    @XmlElementWrapper(name = "irgIds")
    public void setIrgIds(String[] irgIds) {
        this.irgIds = irgIds;
    }

    public ArrayList<IRGItem> getItems() {
        return items;
    }

    @XmlElement(name = "item", type = IRGItem.class)
    @XmlElementWrapper(name = "items")
    public void setItems(ArrayList<IRGItem> items) {
        this.items = items;
    }
}
