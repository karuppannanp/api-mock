/**
 * 
 */
package com.homedepot.pip.request.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.homedepot.pip.cache.sku.ItemCache;
import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.util.Utils;

/**
 * @author KXP8101
 *
 */

@Component
public class RequestValidator {

	public boolean isItemInCache(String itemId) {
		return ItemCache.checkItemInCache(itemId);
	}
	
	public boolean isKeyValid(String key) {
		return StringUtils.equals("tRXWvUBGuAwEzFHScjLw9ktZ0Bw7a335", key);
	}
	
	public boolean isItemIdValid(String itemId) {
		return StringUtils.isNotBlank(itemId) && StringUtils.isNumeric(itemId) && itemId.length() == 9;
	}
	
	public boolean isStoreSkuIdValid(String storeSkuId) {
		return StringUtils.isNotBlank(storeSkuId) && StringUtils.isNumeric(storeSkuId)
				&& (storeSkuId.length() > 5 || storeSkuId.length() < 12);
	}
	
	public boolean isStoreIdValid(String storeId) {
		return StoreCache.checkStoreInCache(storeId);
	}
	
	public boolean isItemMerchandise(String itemId) {
		return ItemCache.isMerchandiseItem(itemId);
	}
	
	public boolean isOnlineStoreIdValid(String storeId) {
		return StringUtils.equals("8119", storeId);
	}
	
	public boolean isStoreAndOnlineStoreIdValid(String storeId) {
		return (isStoreIdValid(storeId) || isOnlineStoreIdValid(storeId));
	}
	
	public boolean isRatingsParameterValid(String itemId, String rating, String count) {
		return isItemIdValid(itemId) && count != null && rating != null;
	}
	
	public boolean isInventoryParameterValid(String itemId, String inventory) {
		return isItemIdValid(itemId) && inventory != null
				&& ("limited".equalsIgnoreCase(inventory) || "comDown".equalsIgnoreCase(inventory) || Utils.convertStringToInt(inventory) >=0);
	}
	
	public boolean isOverlayPrimaryParamValid(String primary) {
		if (primary == null) {
			return false;
		}
		
		primary = primary.toLowerCase();
		if (primary.startsWith("bopis") || primary.startsWith("boss")) {
			return true;
		}
		return false;
	}
	
	public boolean isDynamicEtaParameterValid(Boolean dynamicEta, String timeLeftHrs, String timeLeftMins) {
		if (dynamicEta != null && dynamicEta) {
			int hours = Utils.convertStringToInt(timeLeftHrs);
			int mins = Utils.convertStringToInt(timeLeftMins);
			if (hours == -100 || mins == -100) {
				return false;
			}
			if (hours < 0 || mins < 0) {
				return false;
			}
		}
		return true;
	}
}