package com.homedepot.pip.backend.domain.item;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.homedepot.pip.backend.domain.DomainGroup;
import com.homedepot.pip.backend.domain.Rebates;
import com.homedepot.pip.backend.domain.relateditem.RelatedItemGroup;
import com.homedepot.pip.backend.domain.relatedservice.RelatedServiceGroup;
import com.homedepot.pip.backend.domain.StoreSku;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Item {

	private String itemId;
	private String itemType;
	private String availabilityType;
	private String parentId;
	private String partNumber;
	private String webUrl;
	private String canonicalURL;
    private String protectionPlanSku;
	private ItemInfo itemInfo;
	private ItemMedia itemMedia;
	private ItemRating itemRating;
	private ItemPromotion itemPromotion;
	private ItemAvailability itemAvailability;
	private ItemShipping itemShipping;
	private ArrayList<DomainGroup> attributeGroups;
	private ArrayList<ItemDimensionLocation> itemDimensions;
	private ArrayList<ItemDefiningAttribute> itemDefininigAttributes;
	private ArrayList<RelatedItemGroup> relatedItemGroups;
	private ArrayList<RelatedServiceGroup> relatedServiceGroups;
	private ArrayList<StoreSku> storeSkus;
    private Rebates rebates;


    public String getItemId() {
        return itemId;
    }

    @JacksonXmlProperty
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    @JacksonXmlProperty
    public void setItemType(String ItemType) {
        this.itemType = ItemType;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    @JacksonXmlProperty(localName = "info")
    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }

    public ItemRating getItemRating() {
        return itemRating;
    }

    @JacksonXmlProperty(localName = "ratingsReviews")
    public void setItemRating(ItemRating itemRating) {
        this.itemRating = itemRating;
    }

    public ItemPromotion getItemPromotion() {
        return itemPromotion;
    }

    @JacksonXmlProperty(localName = "promotions")
    public void setItemPromotion(ItemPromotion itemPromotion) {
        this.itemPromotion = itemPromotion;
    }

    public String getParentId() {
        return parentId;
    }

    public ItemMedia getItemMedia() {
        return itemMedia;
    }

    @JacksonXmlProperty(localName = "media")
    public void setItemMedia(ItemMedia itemMedia) {
        this.itemMedia = itemMedia;
    }

    @JacksonXmlProperty(localName = "productId")
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public ArrayList<RelatedItemGroup> getRelatedItemGroups() {
        return relatedItemGroups;
    }

    @JacksonXmlProperty(localName = "itemGroup")
    @JacksonXmlElementWrapper(localName = "relatedItemGroups")
    public void setRelatedItemGroups(ArrayList<RelatedItemGroup> relatedItemGroups) {
        this.relatedItemGroups = relatedItemGroups;
    }

    public ItemShipping getItemShipping() {
        return itemShipping;
    }

    @JacksonXmlProperty(localName = "shipping")
    public void setItemShipping(ItemShipping itemShipping) {
        this.itemShipping = itemShipping;
    }

    public ArrayList<DomainGroup> getAttributeGroups() {
        return attributeGroups;
    }

    @JacksonXmlProperty(localName = "group")
    @JacksonXmlElementWrapper(localName = "attributeGroups")
    public void setAttributeGroups(ArrayList<DomainGroup> attributeGroups) {
        this.attributeGroups = attributeGroups;
    }

    public ArrayList<ItemDimensionLocation> getItemDimensions() {
        return itemDimensions;
    }

    @JacksonXmlProperty(localName = "dimensionEntry")
    @JacksonXmlElementWrapper(localName = "dimensions")
    public void setItemDimensions(ArrayList<ItemDimensionLocation> itemDimensions) {
        this.itemDimensions = itemDimensions;
    }

    public ArrayList<ItemDefiningAttribute> getItemDefininigAttributes() {
        return itemDefininigAttributes;
    }

    @JacksonXmlProperty(localName = "definingAttributeEntry")
    @JacksonXmlElementWrapper(localName = "definingAttributes")
    public void setItemDefininigAttributes(ArrayList<ItemDefiningAttribute> itemDefininigAttributes) {
        this.itemDefininigAttributes = itemDefininigAttributes;
    }

    @Override
    public boolean equals(Object item) {
        if (item instanceof Item && StringUtils.equals(this.getItemId(), ((Item) item).getItemId())) {
            return true;
        }
        return false;
    }


    public String getWebUrl() {
        return webUrl;
    }

    @JacksonXmlProperty
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getCanonicalURL() {
        return canonicalURL;
    }

    @JacksonXmlProperty
    public void setCanonicalURL(String canonicalURL) {
        this.canonicalURL = canonicalURL;
    }

    public ArrayList<StoreSku> getStoreSkus() {
        return storeSkus;
    }

    @JacksonXmlProperty(localName = "storeSku")
    @JacksonXmlElementWrapper(localName = "storeSkus")
    public void setStoreSkus(ArrayList<StoreSku> storeSkus) {
        this.storeSkus = storeSkus;
    }

    public String getAvailabilityType() {
        return availabilityType;
    }

    @JacksonXmlProperty
    public void setAvailabilityType(String availabilityType) {
        this.availabilityType = availabilityType;
    }

    public ItemAvailability getItemAvailability() {
        return itemAvailability;
    }

    //    @JacksonXmlProperty
    public void setItemAvailability(ItemAvailability itemAvailability) {
        this.itemAvailability = itemAvailability;
    }

    @JacksonXmlProperty
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getProtectionPlanSku() {
        return protectionPlanSku;
    }

    @JacksonXmlProperty(localName = "protectionPlanSku")
    public void setProtectionPlanSku(String protectionPlanSku) {
        this.protectionPlanSku = protectionPlanSku;
    }

    public ArrayList<RelatedServiceGroup> getRelatedServiceGroups() {
        return relatedServiceGroups;
    }

    @JacksonXmlProperty(localName = "relatedServiceGroup")
    @JacksonXmlElementWrapper(localName = "relatedServiceGroups")
    public void setRelatedServiceGroups(ArrayList<RelatedServiceGroup> relatedServiceGroups) {
        this.relatedServiceGroups = relatedServiceGroups;
    }

    public Rebates getRebates() {
        return rebates;
    }

    public void setRebates(Rebates rebates) {
        this.rebates = rebates;
    }
}
