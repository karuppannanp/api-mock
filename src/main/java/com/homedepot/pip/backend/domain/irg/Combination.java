package com.homedepot.pip.backend.domain.irg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "irgItems")
public class Combination {
    private ArrayList<IRGItem> items = null;

    public ArrayList<IRGItem> getItems() {
        return items;
    }

    @XmlElement(name = "item", type = IRGItem.class)
    @XmlElementWrapper(name = "items")
    public void setItems(ArrayList<IRGItem> items) {
        this.items = items;
    }
}
