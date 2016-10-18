package com.homedepot.pip.data.sku.inventory;

import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.InventoryError;
import com.homedepot.pip.backend.domain.item.ItemInventory;

@Component
public class StubbedInventory {

	public ItemInventory createItemInventory(String inventory) {
		ItemInventory itemInventory = new ItemInventory();
		if ("limited".equalsIgnoreCase(inventory)) {
			itemInventory.setExpectedQuantityAvailable(0);
			itemInventory.setOnHandQuantity(1);			
		} else if ("comDown".equalsIgnoreCase(inventory)) {
			itemInventory.setError(createInventoryError("COM_DOWN", "Inventory service is down"));
		} else if ("0".equals(inventory)) {
			itemInventory.setExpectedQuantityAvailable(0);
			itemInventory.setOnHandQuantity(0);
		} else {
			itemInventory.setExpectedQuantityAvailable(Integer.parseInt(inventory));
			itemInventory.setOnHandQuantity(itemInventory.getExpectedQuantityAvailable() + 1);
		}
		return itemInventory;
	}

	private InventoryError createInventoryError(String code, String message) {
		InventoryError inventoryError = new InventoryError();
		inventoryError.setCode(code);
		inventoryError.setMessage(message);
		return inventoryError;
	}
}