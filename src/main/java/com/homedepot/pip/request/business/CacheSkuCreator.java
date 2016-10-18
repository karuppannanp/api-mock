package com.homedepot.pip.request.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.homedepot.pip.cache.sku.ItemCache;
import com.homedepot.pip.enums.ItemAvailabilityType;
import com.homedepot.pip.enums.ItemType;
import com.homedepot.pip.input.Attribute;
import com.homedepot.pip.input.Fulfillment;
import com.homedepot.pip.input.Info;
import com.homedepot.pip.input.ItemAvail;
import com.homedepot.pip.input.ItemInput;
import com.homedepot.pip.input.Price;
import com.homedepot.pip.input.PromoInput;
import com.homedepot.pip.input.Rating;
import com.homedepot.pip.input.Shipping;
import com.homedepot.pip.input.StoreSkuInput;

@Component
public class CacheSkuCreator {
	
	public void createItemAvailability(String itemId, boolean buyable, boolean inventoryStatus, boolean backorderable,
			boolean published, boolean discontinued, String backorderDate) {
		ItemAvail itemAvailability = new ItemAvail();
		itemAvailability.setBuyable(buyable);
		itemAvailability.setInventoryStatus(inventoryStatus);
		itemAvailability.setBackorderable(backorderable);
		itemAvailability.setPublished(published);
		itemAvailability.setDiscontinued(discontinued);
		ItemCache.setItemAvailabilityToItemCache(itemId, itemAvailability);
	}
	
	public void createPrice(Price price, String itemId) {
		StoreSkuInput storeSku = ItemCache.getStoreSkuFromCache(itemId);
		if (storeSku == null) {
			storeSku = new StoreSkuInput();
		}
		storeSku.setItemPrice(price);
		ItemCache.setStoreSkuToItemCache(itemId, storeSku);
	}
	
	public void createAttributeGroup(String itemId, String groupName, String guid, String value, Boolean bulleted) {
		Map<String, List<Attribute>> attrGroups = ItemCache.getAttrGroupsFromCache(itemId);
		if (attrGroups == null) {
			attrGroups = new HashMap<>();
		}
		
		if (attrGroups.containsKey(groupName)) {
			attrGroups.get(groupName).add(createAttribute(guid, value, bulleted));
		} else {
			List<Attribute> attrs = new ArrayList<>();
			attrs.add(createAttribute(guid, value, bulleted));
			attrGroups.put(groupName, attrs);
		}

		ItemCache.setAttrGroupsToItemCache(itemId, attrGroups);
	}
	
	public void deleteAttributeGroupByName(String itemId, String groupName) {
		List<String> attrGroupNames = ItemCache.getAttributeGroupNamesFromCache(itemId);
		
		if (attrGroupNames == null) {
			attrGroupNames = new ArrayList<>();
		}
		
		for (String attrGroupName : attrGroupNames) {
			if (StringUtils.equalsIgnoreCase(groupName, attrGroupName)) {
				return;
			}
		}
		
		attrGroupNames.add(groupName);
		ItemCache.setAttributeGroupNamesIntoCache(itemId, attrGroupNames);
	}
	
	private Attribute createAttribute(String guid, String value, Boolean bulleted) {
		Attribute attr = new Attribute();
		if (bulleted != null && bulleted) {
			attr.setBulleted(bulleted);
		}
		attr.setGuid(guid);
		attr.setValue(value);
		return attr;
	}
	
	public void createRating(String itemId, String rating, String count) {
		Rating ratingReview = new Rating();
		ratingReview.setRating(rating);
		ratingReview.setTotalReviews(count);
		ItemCache.setRatingToItemCache(itemId, ratingReview);
	}
	
	public void createPromotion(String itemId, String code, String description, String startDate, String endDate,
			String longDescription) {
		PromoInput promotion = new PromoInput();
		promotion.setCode(code);
		promotion.setDescription(longDescription);
		promotion.setStartDate(startDate);
		promotion.setEndDate(endDate);
		promotion.setLongDescription(longDescription);
		ItemCache.setPromotionToItemCache(itemId, promotion);
	}
	
	public void createInfo(String itemId, Info info) {
		ItemCache.setInfoToItemCache(itemId, info);
	}
	
	public void createShipping(String itemId, String messageNumber, String sthStartDate, String sthEndDate,
			String bossStartDate, String bossEndDate, Boolean dynamicEta, String timeLeftHrs, String timeLeftMins,
			String threshold, String excludedShipStates) {
		Shipping shipping = new Shipping();
		shipping.setMessageNumber(messageNumber);
		// TODO
		/*shipping.setSthStartDate(sthStartDate);
		shipping.setSthEndDate(sthEndDate);
		shipping.setBossStartDate(bossStartDate);
		shipping.setBossEndDate(bossEndDate);*/
		shipping.setDynamicEta(dynamicEta);
		shipping.setTimeLeftHrs(timeLeftHrs);
		shipping.setTimeLeftMins(timeLeftMins);
		shipping.setThreshold(threshold);
		shipping.setExcludedShipStates(excludedShipStates);
		ItemCache.setShippingToItemCache(itemId, shipping);
	}
	
	public void createFulfillment(String itemId, boolean sthStatus, boolean bopisStatus, boolean bopisCheckNearby,
			boolean bossStatus, boolean bodfsStatus, String bodfsCharge, String alphaPrompt) {
		Fulfillment fulfillment = new Fulfillment();
		fulfillment.setSthStatus(sthStatus);
		fulfillment.setBopisStatus(bopisStatus);
		fulfillment.setBopisCheckNearby(bopisCheckNearby);
		fulfillment.setBossStatus(bossStatus);
		fulfillment.setBodfsStatus(bodfsStatus);
		fulfillment.setBodfsCharge(bodfsCharge);
		fulfillment.setAlphaPrompt(alphaPrompt);

		StoreSkuInput storeSku = ItemCache.getStoreSkuFromCache(itemId);
		if (storeSku == null) {
			storeSku = new StoreSkuInput();
		}
		storeSku.setFulfillment(fulfillment);
		ItemCache.setStoreSkuToItemCache(itemId, storeSku);
	}
	
	public void createInventory(String itemId, String inventory) {
		StoreSkuInput storeSku = ItemCache.getStoreSkuFromCache(itemId);
		if (storeSku == null) {
			storeSku = new StoreSkuInput();
		}
		storeSku.setInventory(inventory);
		ItemCache.setStoreSkuToItemCache(itemId, storeSku);
	}
	
	public void createRebate(String itemId, boolean rebate) {
		ItemCache.setRebatesToItemCache(itemId, rebate);
	}

	public void createBasicItem(String itemId, boolean appliance, String storeId, String storeSkuId,
			String protectionPlanSku, String itemType, String availabilityType, String parentId) {
		ItemInput basicItem = new ItemInput();
		basicItem.setItemId(itemId);
		basicItem.setAppliance(appliance);
		basicItem.setStoreId(storeId);
		basicItem.setStoreSkuId(storeSkuId);
		basicItem.setProtectionPlanSku(protectionPlanSku);
		// Basic validation and override wrong combination
		if (appliance) {
			availabilityType = ItemAvailabilityType.ONLINE;
			itemType = ItemType.MAJOR_APPLIANCE.getItemType();
		} else {
			if (!ItemType.CONFIGURABLE_BLINDS.getItemType().equals(itemType)) {
				itemType = ItemType.MERCHANDISE.getItemType();
			}
		}
		basicItem.setItemType(itemType);
		basicItem.setAvailabilityType(availabilityType);
		basicItem.setParentId(parentId);
		ItemCache.keepItemInCache(basicItem);
	}
}