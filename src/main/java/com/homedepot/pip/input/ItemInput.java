/**
 * 
 */
package com.homedepot.pip.input;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author KXP8101
 *
 */
public class ItemInput {

	private String itemId;
	private String storeId;
	private String storeSkuId;
	private String protectionPlanSku;
	private String itemType;
	private String availabilityType;
	private String parentId;
	private Boolean appliance;

	private Boolean rebates;
	private Boolean superSku;
	
	private boolean modifyRealData;

	private Info info;
	private MediaInput media;
	private Rating rating;
	private PromoInput promotion;
	private ItemAvail itemAvailability;
	private Shipping shipping;
	private StoreSkuInput storeSku;
	private Map<String, List<Attribute>> attributeGroups;
	private List<String> attributeGroupNames;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getStoreId() {
		if (StringUtils.isBlank(storeId)) {
			storeId = "8119";
		}
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreSkuId() {
		return storeSkuId;
	}

	public void setStoreSkuId(String storeSkuId) {
		this.storeSkuId = storeSkuId;
	}

	public String getProtectionPlanSku() {
		return protectionPlanSku;
	}

	public void setProtectionPlanSku(String protectionPlanSku) {
		this.protectionPlanSku = protectionPlanSku;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getAvailabilityType() {
		return availabilityType;
	}

	public void setAvailabilityType(String availabilityType) {
		this.availabilityType = availabilityType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public MediaInput getMedia() {
		return media;
	}

	public void setMedia(MediaInput media) {
		this.media = media;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public PromoInput getPromotion() {
		return promotion;
	}

	public void setPromotion(PromoInput promotion) {
		this.promotion = promotion;
	}

	public ItemAvail getItemAvailability() {
		return itemAvailability;
	}

	public void setItemAvailability(ItemAvail itemAvailability) {
		this.itemAvailability = itemAvailability;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public StoreSkuInput getStoreSku() {
		return storeSku;
	}

	public void setStoreSku(StoreSkuInput storeSku) {
		this.storeSku = storeSku;
	}

	public Boolean getRebates() {
		return rebates;
	}

	public void setRebates(Boolean rebates) {
		this.rebates = rebates;
	}

	public Boolean isSuperSku() {
		return superSku;
	}

	public void setSuperSku(Boolean superSku) {
		this.superSku = superSku;
	}

	public Boolean getAppliance() {
		return appliance;
	}

	public void setAppliance(Boolean appliance) {
		this.appliance = appliance;
	}

	public Map<String, List<Attribute>> getAttributeGroups() {
		return attributeGroups;
	}

	public void setAttributeGroups(Map<String, List<Attribute>> attributeGroups) {
		this.attributeGroups = attributeGroups;
	}

	public List<String> getAttributeGroupNames() {
		return attributeGroupNames;
	}

	public void setAttributeGroupNames(List<String> attributeGroupNames) {
		this.attributeGroupNames = attributeGroupNames;
	}

	public boolean isModifyRealData() {
		return modifyRealData;
	}

	public void setModifyRealData(boolean modifyRealData) {
		this.modifyRealData = modifyRealData;
	}
}