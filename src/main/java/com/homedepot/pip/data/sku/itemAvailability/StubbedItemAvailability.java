package com.homedepot.pip.data.sku.itemAvailability;

import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.item.ItemAvailability;
import com.homedepot.pip.enums.ItemAvailabilityType;
import com.homedepot.pip.input.ItemAvail;

@Component
public class StubbedItemAvailability {

	private ItemAvailability createItemAvailability(Boolean buyable, Boolean inventoryStatus, Boolean backorderable,
			Boolean published, Boolean discontinuedItem, String availabilityType, boolean appliance) {
		ItemAvailability itemAvailability = new ItemAvailability();

		boolean availableOnlineStore = false;
		boolean availableInStore = false;
		if (ItemAvailabilityType.BROWSE_ONLY.equals(availabilityType)) {
			availableInStore = true;
		} else if (ItemAvailabilityType.ONLINE.equals(availabilityType)) {
			availableOnlineStore = true;
		} else if (ItemAvailabilityType.SHARED.equals(availabilityType)) {
			availableInStore = true;
			availableOnlineStore = true;
		}
		itemAvailability.setAvailableInStore(availableInStore);
		itemAvailability.setAvailableOnlineStore(availableOnlineStore);
		if (appliance) {
			itemAvailability.setBackorderable(false);
			itemAvailability.setInventoryStatus(true);
		} else {
			itemAvailability.setBackorderable(backorderable);
			itemAvailability.setInventoryStatus(inventoryStatus);
		}
		itemAvailability.setBuyable(buyable);
		itemAvailability.setDiscontinuedItem(discontinuedItem);
		itemAvailability.setPublished(published);
		return itemAvailability;
	}

	public ItemAvailability createItemAvailability(ItemAvail itemAvail, String availabilityType, boolean appliance) {
		return createItemAvailability(itemAvail.isBuyable(), itemAvail.isInventoryStatus(), itemAvail.isBackorderable(),
				itemAvail.isPublished(), itemAvail.isDiscontinued(), availabilityType, appliance);
	}

	public ItemAvailability createDefaultItemAvailability(String availabilityType) {
		return createItemAvailability(true, true, false, true, false, availabilityType, false);
	}

	public boolean isItemAvailableOnline(ItemAvailability itemAvailability) {
		if (itemAvailability == null) {
			return false;
		}
		if (itemAvailability.getInventoryStatus() != null && !itemAvailability.getInventoryStatus()
				&& itemAvailability.getBackorderable() != null && itemAvailability.getBackorderable()) {
			return true;
		}
		if (itemAvailability.getInventoryStatus() != null && itemAvailability.getInventoryStatus()) {
			return true;
		}
		return false;
	}
}