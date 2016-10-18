package com.homedepot.pip.cache.sku;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.homedepot.pip.input.Attribute;
import com.homedepot.pip.input.Info;
import com.homedepot.pip.input.ItemAvail;
import com.homedepot.pip.input.ItemInput;
import com.homedepot.pip.input.MediaInput;
import com.homedepot.pip.input.PromoInput;
import com.homedepot.pip.input.Rating;
import com.homedepot.pip.input.Shipping;
import com.homedepot.pip.input.StoreSkuInput;

public class ItemCache {

	private static Map<String, ItemInput> ITEM_CACHE = new HashMap<>();

	public static void clearAllItemCache() {
		ITEM_CACHE.clear();
	}

	public static void clearItemCacheByItemId(String itemId) {
		if (checkItemInCache(itemId)) {
			ITEM_CACHE.remove(itemId);
		}
	}

	public static void keepItemInCache(ItemInput item) {
		ITEM_CACHE.put(item.getItemId(), item);
		System.out.println("Size of the cache: " + ITEM_CACHE.size());
	}

	public static boolean checkItemInCache(String itemId) {
		return ITEM_CACHE.containsKey(itemId);
	}

	public static ItemInput getItemFromCache(String itemId) {
		return ITEM_CACHE.get(itemId);
	}

	public static Shipping getShippingFromCache(String itemId) {
		if (checkItemInCache(itemId) && getItemFromCache(itemId).getShipping() != null) {
			return getItemFromCache(itemId).getShipping();
		}
		return null;
	}

	public static MediaInput getMediaFromCache(String itemId) {
		if (checkItemInCache(itemId) && getItemFromCache(itemId).getMedia() != null) {
			return getItemFromCache(itemId).getMedia();
		}
		return null;
	}

	public static Rating getRatingFromCache(String itemId) {
		if (checkItemInCache(itemId) && getItemFromCache(itemId).getRating() != null) {
			return getItemFromCache(itemId).getRating();
		}
		return null;
	}

	public static void setRatingToItemCache(String itemId, Rating rating) {
		if (checkItemInCache(itemId)) {
			getItemFromCache(itemId).setRating(rating);
		}
	}

	public static void setPromotionToItemCache(String itemId, PromoInput promotion) {
		if (checkItemInCache(itemId)) {
			getItemFromCache(itemId).setPromotion(promotion);
		}
	}

	public static void setInfoToItemCache(String itemId, Info info) {
		if (checkItemInCache(itemId)) {
			getItemFromCache(itemId).setInfo(info);
		}
	}

	public static void setShippingToItemCache(String itemId, Shipping shipping) {
		if (checkItemInCache(itemId)) {
			getItemFromCache(itemId).setShipping(shipping);
		}
	}

	public static void setItemAvailabilityToItemCache(String itemId, ItemAvail itemAvailability) {
		if (checkItemInCache(itemId)) {
			getItemFromCache(itemId).setItemAvailability(itemAvailability);
		}
	}

	public static void setRebatesToItemCache(String itemId, boolean rebate) {
		ItemCache.getItemFromCache(itemId).setRebates(rebate);
	}

	public static PromoInput getPromotionFromCache(String itemId) {
		if (checkItemInCache(itemId) && getItemFromCache(itemId).getPromotion() != null) {
			return getItemFromCache(itemId).getPromotion();
		}
		return null;
	}

	public static ItemAvail getItemAvailabilityFromCache(String itemId) {
		if (checkItemInCache(itemId) && getItemFromCache(itemId).getItemAvailability() != null) {
			return getItemFromCache(itemId).getItemAvailability();
		}
		return null;
	}

	public static StoreSkuInput getStoreSkuFromCache(String itemId) {
		if (checkItemInCache(itemId) && getItemFromCache(itemId).getStoreSku() != null) {
			return getItemFromCache(itemId).getStoreSku();
		}
		return null;
	}

	public static Map<String, List<Attribute>> getAttrGroupsFromCache(String itemId) {
		if (checkItemInCache(itemId) && getItemFromCache(itemId).getAttributeGroups() != null) {
			return getItemFromCache(itemId).getAttributeGroups();
		}
		return null;
	}

	public static void setAttrGroupsToItemCache(String itemId, Map<String, List<Attribute>> attributeGroups) {
		if (checkItemInCache(itemId)) {
			getItemFromCache(itemId).setAttributeGroups(attributeGroups);
		}
	}

	public static List<String> getAttributeGroupNamesFromCache(String itemId) {
		if (checkItemInCache(itemId) && getItemFromCache(itemId).getAttributeGroupNames() != null) {
			return getItemFromCache(itemId).getAttributeGroupNames();
		}
		return null;
	}

	public static void setAttributeGroupNamesIntoCache(String itemId, List<String> attributeGroupNames) {
		if (checkItemInCache(itemId)) {
			getItemFromCache(itemId).setAttributeGroupNames(attributeGroupNames);
		}
	}

	public static void setStoreSkuToItemCache(String itemId, StoreSkuInput storeSku) {
		if (checkItemInCache(itemId)) {
			getItemFromCache(itemId).setStoreSku(storeSku);
		}
	}

	public static boolean isMerchandiseItem(String itemId) {
		return !getItemFromCache(itemId).isAppliance();
	}
}