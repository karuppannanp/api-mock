package com.homedepot.pip.backend.domain.irg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "itemRelatedGroups")
public class ItemRelatedGroups {

    private String itemId;
    private Accessory accessory;
    private Collection collection;
    private Coordinating coordinating;
    private Combination combination;


    public String getItemId() {
        return itemId;
    }

    @XmlElement
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    @XmlElement
    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public Collection getCollection() {
        return collection;
    }

    @XmlElement
    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Coordinating getCoordinating() {
        return coordinating;
    }

    @XmlElement
    public void setCoordinating(Coordinating coordinating) {
        this.coordinating = coordinating;
    }

    public Combination getCombination() {
        return combination;
    }

    @XmlElement
    public void setCombination(Combination combination) {
        this.combination = combination;
    }

}
