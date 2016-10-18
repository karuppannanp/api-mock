package com.homedepot.pip.data.sku.storeAvailability;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.StoreAvailability;
import com.homedepot.pip.backend.domain.item.ItemAvailability;
import com.homedepot.pip.backend.domain.item.ItemMessage;
import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.data.sku.itemAvailability.StubbedItemAvailability;

@Component
public class StubbedStoreAvailability {

	@Autowired
	StubbedItemAvailability stubbedItemAvailability;

	public StoreAvailability createStoreAvailability(ItemAvailability itemAvailability, String storeId) {
		StoreAvailability storeAvailability = new StoreAvailability();
		if ("8119".equals(storeId)) {
			if (stubbedItemAvailability.isItemAvailableOnline(itemAvailability)) {
				storeAvailability.setAvailableInLocalStore(true);
			} else {
				storeAvailability.setAvailableInLocalStore(false);
			}
		} else {
			storeAvailability.setAvailableInLocalStore(true);
			setStoreFlags(storeAvailability, storeId);
		}

		storeAvailability.setItemAvailable(true);
		setAvailabilityMessages(storeAvailability, itemAvailability);

		return storeAvailability;
	}

	private ArrayList<ItemMessage> createAvailabilityMessages(String key, String value) {
		ArrayList<ItemMessage> itemMessages = new ArrayList<>();
		ItemMessage itemMessage = new ItemMessage();
		itemMessage.setMsgKey(key);
		itemMessage.setMsgValue(value);
		itemMessages.add(itemMessage);
		return itemMessages;
	}
	
	private void setStoreFlags(StoreAvailability storeAvailability, String storeId) {
		if (StoreCache.checkBopis(storeId)) {
			storeAvailability.setBopisElgStore(true);
		}
		if (StoreCache.checkBoss(storeId)) {
			storeAvailability.setBossElgStore(true);
		}
		if (StoreCache.checkBossMsg(storeId)) {
			storeAvailability.setBossMsgElgStore(true);
		}
	}
	
	private void setAvailabilityMessages(StoreAvailability storeAvailability, ItemAvailability itemAvailability) {
		ArrayList<ItemMessage> itemAvilabilityMsgs = null;
		if (itemAvailability.getInventoryStatus() != null && !itemAvailability.getInventoryStatus()
				&& itemAvailability.getBackorderable() != null && !itemAvailability.getBackorderable()) {
			itemAvilabilityMsgs = createAvailabilityMessages("out-of-stock", "Out Of Stock Online");
		} else if (itemAvailability.getInventoryStatus() != null && !itemAvailability.getInventoryStatus()
				&& itemAvailability.getBackorderable() != null && itemAvailability.getBackorderable()) {
			itemAvilabilityMsgs = createAvailabilityMessages("backordered", "Backordered Online");
		} else if (itemAvailability.getAvailableOnlineStore() && !itemAvailability.getAvailableInStore()) {
			itemAvilabilityMsgs = createAvailabilityMessages("internet-only", "ONLINE EXCLUSIVE");
		} else if (!itemAvailability.getAvailableOnlineStore() && itemAvailability.getAvailableInStore()) {
			itemAvilabilityMsgs = createAvailabilityMessages("store-only", "STORE EXCLUSIVE");
		} else {
			itemAvilabilityMsgs = createAvailabilityMessages("check_btn", "Sold At Your Local Store");
		}
		storeAvailability.setItemAvilabilityMsgs(itemAvilabilityMsgs);
	}
}