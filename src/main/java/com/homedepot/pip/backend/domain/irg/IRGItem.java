package com.homedepot.pip.backend.domain.irg;

import com.homedepot.pip.backend.domain.StoreSku;
import com.homedepot.pip.backend.domain.item.ItemAvailability;
import com.homedepot.pip.backend.domain.item.ItemInfo;
import com.homedepot.pip.backend.domain.item.ItemMedia;
import com.homedepot.pip.backend.domain.item.ItemRating;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "item")
public class IRGItem {

    private String itemId;
    private String canonicalURL;
    private ItemInfo itemInfo;
    private ItemMedia itemMedia;
    private ArrayList<StoreSku> storeSkus;
    private ItemAvailability itemAvailability;
    private String availabilityType;
    private ItemRating itemRating;
    private String itemType;

    public ItemRating getItemRating() {
        return itemRating;
    }

    @XmlElement(name = "ratingsReviews")
    public void setItemRating(ItemRating itemRating) {
        this.itemRating = itemRating;
    }

    public String getItemId() {
        return itemId;
    }

    @XmlElement
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCanonicalURL() {
        return canonicalURL;
    }

    @XmlElement
    public void setCanonicalURL(String canonicalURL) {
        this.canonicalURL = canonicalURL;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    @XmlElement(name = "info")
    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }

    public ItemMedia getItemMedia() {
        return itemMedia;
    }

    @XmlElement(name = "media")
    public void setItemMedia(ItemMedia itemMedia) {
        this.itemMedia = itemMedia;
    }

    public ArrayList<StoreSku> getStoreSkus() {
        return storeSkus;
    }

    @XmlElement(name = "storeSku", type = StoreSku.class)
    @XmlElementWrapper(name = "storeSkus")
    public void setStoreSkus(ArrayList<StoreSku> storeSkus) {
        this.storeSkus = storeSkus;
    }

    public ItemAvailability getItemAvailability() {
        return itemAvailability;
    }

    @XmlElement
    public void setItemAvailability(ItemAvailability itemAvailability) {
        this.itemAvailability = itemAvailability;
    }

    public String getAvailabilityType() {
        return availabilityType;
    }

    @XmlElement
    public void setAvailabilityType(String availabilityType) {
        this.availabilityType = availabilityType;
    }

    public String getItemType() {
        return itemType;
    }

    @XmlElement
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}