package com.homedepot.pip.data.sku.shipping;

import java.sql.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.item.ItemShipping;
import com.homedepot.pip.enums.ItemType;
import com.homedepot.pip.enums.ShippingType;
import com.homedepot.pip.input.ItemInput;
import com.homedepot.pip.input.Shipping;

@Component
public class StubbedShipping {

	public ItemShipping createItemShipping(ItemInput itemInput) {
		Shipping shipping = itemInput.getShipping();
		ItemShipping itemShipping = createDefaultItemShipping(itemInput.getAppliance());
		
		if (StringUtils.isNotBlank(shipping.getThreshold())) {
			itemShipping.setFreeShippingThreshold(shipping.getThreshold());
		}
		
		if (itemInput.getAppliance() && !ShippingType.isValidApplianceShippingType(shipping.getMessageNumber())) {
			shipping.setMessageNumber(ShippingType.APPL_FREE);
		} else if (!itemInput.getAppliance() && ShippingType.isValidApplianceShippingType(shipping.getMessageNumber())) {
			shipping.setMessageNumber(ShippingType.FREE);			
		}
		
		if (ShippingType.isValidShippingType(shipping.getMessageNumber())) {
			itemShipping.setFreeShippingMessageNumber(shipping.getMessageNumber());
		} else {
			if (ItemType.MERCHANDISE.getItemType().equals(itemInput.getItemType())) {
				itemShipping.setFreeShippingMessageNumber(ShippingType.FREE);
			} else if (ItemType.MAJOR_APPLIANCE.getItemType().equals(itemInput.getItemType())) {
				itemShipping.setFreeShippingMessageNumber(ShippingType.APPL_FREE);
			}
		}
		
		if (ShippingType.FREE.equals(itemShipping.getFreeShippingMessageNumber())) {
			itemShipping.setFreeShippingMessage("Free Shipping");
			itemShipping.setItemLevelFreeShip(true);
			itemShipping.setEligibleForFreeShipping(true);
		} else if (ShippingType.FREE_WITH.equals(itemShipping.getFreeShippingMessageNumber())) {
			itemShipping.setFreeShippingMessage("Ships FREE with " + itemShipping.getFreeShippingThreshold() + " Order");
			itemShipping.setEligibleForFreeShipping(true);
		} else if (ShippingType.APPL_FREE.equals(itemShipping.getFreeShippingMessageNumber())) {
			itemShipping.setFreeShippingMessage("Free Delivery");
		} else if (ShippingType.APPL_FREE_WITH.equals(itemShipping.getFreeShippingMessageNumber())) {
			itemShipping.setFreeShippingMessage("");
		} else if (ShippingType.NOT_QUALIFY.equals(itemShipping.getFreeShippingMessageNumber())) {
			itemShipping.setFreeShippingMessage("This item does not qualify for free shipping.");
		} else if (ShippingType.PRICE_INCLUDES_SHIPPING.equals(itemShipping.getFreeShippingMessageNumber())) {
			itemShipping.setFreeShippingMessage("Price includes shipping.");
		}
		
		if (shipping.getSthStartDate() != null) {
			itemShipping.setSthEstimatedShippingStartDate(shipping.getSthStartDate());
			itemShipping.setSthEstimatedShippingEndDate(shipping.getSthEndDate());
		}
		
		if (shipping.getBossStartDate() != null) {
			itemShipping.setBossEstimatedShippingStartDate(shipping.getBossStartDate());
			itemShipping.setBossEstimatedShippingEndDate(shipping.getBossEndDate());
		}
		
		itemShipping.setExcludedShipStates(shipping.getExcludedShipStates());
		return itemShipping;
	}

	public ItemShipping createDefaultItemShipping(boolean appliance) {
		ItemShipping itemShipping = new ItemShipping();
		if (appliance) {
			itemShipping.setSthEstimatedShippingEndDate(Date.valueOf("2017-10-12"));
			itemShipping.setSthEstimatedShippingStartDate(Date.valueOf("2016-10-08"));
			itemShipping.setBossEstimatedShippingEndDate(Date.valueOf("2017-10-14"));
			itemShipping.setBossEstimatedShippingStartDate(Date.valueOf("2016-10-09"));
			itemShipping.setFreeShippingMessage("This item does not qualify for free shipping.");
			itemShipping.setItemLevelFreeShip(false);
			itemShipping.setFreeShippingMessageNumber("2");
			itemShipping.setFreeShippingThreshold("$45.00");
			itemShipping.setEligibleForFreeShipping(false);
		} else {
			
		}
		itemShipping.setExcludedShipStates("AK,GU,HI,PR,VI");
		itemShipping.setFreeShippingMessageNumber("5");
		itemShipping.setFreeShippingThreshold("$445.00");
		return itemShipping;
	}
}