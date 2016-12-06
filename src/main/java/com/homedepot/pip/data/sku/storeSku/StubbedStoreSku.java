package com.homedepot.pip.data.sku.storeSku;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.StoreSku;
import com.homedepot.pip.backend.domain.item.ItemAvailability;
import com.homedepot.pip.cache.sku.ItemCache;
import com.homedepot.pip.data.sku.fulfillment.StubbedFulfillment;
import com.homedepot.pip.data.sku.inventory.StubbedInventory;
import com.homedepot.pip.data.sku.itemAvailability.StubbedItemAvailability;
import com.homedepot.pip.data.sku.price.StubbedPrice;
import com.homedepot.pip.data.sku.storeAvailability.StubbedStoreAvailability;
import com.homedepot.pip.enums.ItemAvailabilityType;
import com.homedepot.pip.enums.StoreStatusCode;
import com.homedepot.pip.enums.StoreStatusType;
import com.homedepot.pip.input.ItemInput;
import com.homedepot.pip.input.Price;

@Component
public class StubbedStoreSku {

	@Autowired
	private StubbedStoreAvailability stubbedStoreAvailability;

	@Autowired
	private StubbedFulfillment stubbedFulfillment;

	@Autowired
	private StubbedItemAvailability stubbedItemAvailability;

	@Autowired
	private StubbedPrice stubbedPrice;

	@Autowired
	private StubbedInventory stubbedInventory;

	public ArrayList<StoreSku> createDefaultStoreSku(ItemInput itemInput, String storeId) {
		ArrayList<StoreSku> storeSkus = new ArrayList<>();
		StoreSku storeSku = new StoreSku();
		storeSku.setStoreId(storeId);
		storeSku.setStoreStatus(true);
		storeSku.setStoreStatusType(StoreStatusType.ACTIVE);

		ItemAvailability itemAvailability = null;
		if (itemInput != null && ItemCache.getItemAvailabilityFromCache(itemInput.getItemId()) != null) {
			itemAvailability = stubbedItemAvailability.createItemAvailability(itemInput.getItemAvailability(),
					itemInput.getAvailabilityType(), itemInput.getAppliance());
		} else {
			itemAvailability = stubbedItemAvailability
					.createDefaultItemAvailability(ItemAvailabilityType.SHARED);
		}

		storeSku.setFulfillmentOptions(stubbedFulfillment.createDefaultFulfillmentOptions(storeId, itemAvailability));
		storeSku.setStoreAvailability(stubbedStoreAvailability.createStoreAvailability(itemAvailability, storeId));
		storeSku.setItemPrice(stubbedPrice.createDefaultStorePrice(itemInput.getAppliance()));
		storeSkus.add(storeSku);
		if (!StringUtils.equals("8119", storeId)) {
			StoreSku storeSkuOnline = new StoreSku();
			storeSkuOnline.setStoreId("8119");
			storeSkuOnline.setStoreStatus(true);
			storeSkuOnline.setStoreStatusType(StoreStatusType.ACTIVE);
			storeSkuOnline.setFulfillmentOptions(
					stubbedFulfillment.createDefaultFulfillmentOptions("8119", itemAvailability));
			storeSkuOnline
					.setStoreAvailability(stubbedStoreAvailability.createStoreAvailability(itemAvailability, "8119"));
			storeSkuOnline.setItemPrice(stubbedPrice.createDefaultOnlinePrice(itemInput.getAppliance()));
			storeSkus.add(storeSkuOnline);

		}
		return storeSkus;
	}

	public ArrayList<StoreSku> createStoreSku(ItemInput itemInput) {
		ArrayList<StoreSku> storeSkus = new ArrayList<>();
		StoreSku storeSku = new StoreSku();
		storeSku.setStoreId(itemInput.getStoreId());
		storeSku.setStoreStatus(true);
		storeSku.setStoreStatusType(StoreStatusType.ACTIVE);
		
		int storeStatus = 0;

		// Item Availability part
		boolean appliance = itemInput.getAppliance();
		ItemAvailability itemAvailability = null;
		if (ItemCache.getItemAvailabilityFromCache(itemInput.getItemId()) != null) {
			itemAvailability = stubbedItemAvailability.createItemAvailability(itemInput.getItemAvailability(),
					itemInput.getAvailabilityType(), appliance);
			storeStatus = itemInput.getItemAvailability().getOnlineStatus();
		} else {
			itemAvailability = stubbedItemAvailability
					.createDefaultItemAvailability(ItemAvailabilityType.SHARED);
		}
		setStoreStatus(storeSku, storeStatus);
		
		// Fulfillments part
		storeSku.setFulfillmentOptions(stubbedFulfillment.createFulfillmentOptions(itemInput.getStoreSku(),
				itemInput.getStoreId(), itemAvailability));

		// Store Availability part
		storeSku.setStoreAvailability(
				stubbedStoreAvailability.createStoreAvailability(itemAvailability, itemInput.getStoreId()));

		// Price part
		Price price = itemInput.getStoreSku().getPrice();
		if (price != null) {
			storeSku.setItemPrice(stubbedPrice.createPrice(price, itemInput.getAppliance()));
		} else {
			storeSku.setItemPrice(stubbedPrice.createDefaultStorePrice(itemInput.getAppliance()));
		}
		
		// Inventory part
		if (!"8119".equals(itemInput.getStoreId()) && itemInput.getStoreSku().getInventory() != null) {
			storeSku.setItemInventory(stubbedInventory.createItemInventory(itemInput.getStoreSku().getInventory()));
		}

		storeSkus.add(storeSku);

		if (!StringUtils.equals("8119", itemInput.getStoreId())) {
			StoreSku storeSkuOnline = new StoreSku();
			storeSkuOnline.setStoreId("8119");
			storeSkuOnline.setStoreStatus(true);
			storeSkuOnline.setStoreStatusType(StoreStatusType.ACTIVE);
			storeSkuOnline.setFulfillmentOptions(
					stubbedFulfillment.createFulfillmentOptions(itemInput.getStoreSku(), "8119", itemAvailability));
			storeSkuOnline.setStoreAvailability(
					stubbedStoreAvailability.createStoreAvailability(itemAvailability, "8119"));
			if (price != null) {
				storeSkuOnline.setItemPrice(stubbedPrice.createPrice(price, itemInput.getAppliance()));
			} else {
				storeSkuOnline.setItemPrice(stubbedPrice.createDefaultOnlinePrice(itemInput.getAppliance()));
			}
			storeSkus.add(storeSkuOnline);

		}
		return storeSkus;
	}
	
	private void setStoreStatus(StoreSku storeSku, int storeStatus) {
		if (storeStatus >= 100 && storeStatus <= 400) {
			storeSku.setStoreStatus(true);
		} else {
			storeSku.setStoreStatus(false);
		}
		storeSku.setStoreStatusType(StoreStatusType.valueOf(StoreStatusCode.valueOf("CODE_" + storeStatus).toString()));
	}
}