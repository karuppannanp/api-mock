package com.homedepot.pip.data.sku.info;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.homedepot.pip.backend.domain.item.ItemInfo;
import com.homedepot.pip.input.Fulfillment;
import com.homedepot.pip.input.Info;
import com.homedepot.pip.input.ItemAvail;
import com.homedepot.pip.input.ItemInput;
import com.homedepot.pip.util.Utils;

@Service
public class StubbedInfo {
	
	private static final Map<String, String> SAVING_CENTER = new HashMap<>();
	static {
		SAVING_CENTER.put("New Lower Prices", "New Lower Prices");
		SAVING_CENTER.put("Overstock", "Overstock");
		SAVING_CENTER.put("Special Buys", "Special Buys");
		// Not used right now
		//SAVING_CENTER.put("Bulk Pricing", "Bulk Pricing");
		//SAVING_CENTER.put("Temporary Price Reduction", "Temporary Price Reduction");
		//SAVING_CENTER.put("Clearance", "Clearance");
		//SAVING_CENTER.put("Rebates", "Rebates");
	}

	public ItemInfo createDefaultItemInfo() {
		ItemInfo itemInfo = new ItemInfo();
		itemInfo.setBackorderFlag(false);
		itemInfo.setBrandName("The Home Depot");
		itemInfo.setBopisEligible(true);
		itemInfo.setBossEligible(true);
		itemInfo.setProductClass("10");
		itemInfo.setProductSubClass("8");
		itemInfo.setProductDepartment("26");
		itemInfo.setProductDescription(
				"Use the 5-gal. Orange Homer Bucket to haul parts, paint, topsoil and other household and work-site items. This orange, plastic bucket holds up to a 9 in. bucket grid and features the orange Home Depot logo on its side.");
		itemInfo.setGenericBrandFlag(false);
		itemInfo.setAppliance(false);
		itemInfo.setTopSeller(false);
		itemInfo.setModelNumber("05GLHD2");
		itemInfo.setOnlineStatus(true);
		itemInfo.setLabel("5-gal. Homer Bucket");
		itemInfo.setShipType(33);
		itemInfo.setShowLocalPrice(false);
		itemInfo.setShowProduct(false);
		itemInfo.setStoreSkuNumber("131227");
		itemInfo.setUpcCode("084305355546");
		itemInfo.setVendorNumber("72792");

		itemInfo.setHasIrgItems(false);
		itemInfo.setHasFbtItems(false);
		itemInfo.setHasFbrItems(false);
		
		itemInfo.setHidePrice(false);
		return itemInfo;
	}

	public ItemInfo createItemInfo(ItemInput itemInput) {
		ItemInfo itemInfo = createDefaultItemInfo();
		return modifyItemInfo(itemInput, itemInfo);
	}
	
	public ItemInfo modifyItemInfo(ItemInput itemInput, ItemInfo itemInfo) {
		Info info = itemInput.getInfo();
		// product description
		if (StringUtils.isNotBlank(info.getDescription())) {
			itemInfo.setProductDescription(info.getDescription());
		}

		// title
		if (StringUtils.equals("null", info.getTitle())) {
			itemInfo.setProductTitle(null);
		} else if (StringUtils.isNotBlank(info.getTitle())) {
			itemInfo.setProductTitle(info.getTitle());
		}

		// brand name
		if (StringUtils.equals("null", info.getBrandName())) {
			itemInfo.setBrandName(null);
		} else if (StringUtils.isNotBlank(info.getBrandName())) {
			itemInfo.setBrandName(info.getBrandName());
		}

		// label
		if (StringUtils.equals("null", info.getLabel())) {
			itemInfo.setLabel(null);
		} else if (StringUtils.isNotBlank(info.getLabel())) {
			itemInfo.setLabel(info.getLabel());
		}

		// model #
		if (StringUtils.equals("null", info.getModelNumber())) {
			itemInfo.setModelNumber(null);
		} else if (StringUtils.isNotBlank(info.getModelNumber())) {
			itemInfo.setModelNumber(info.getModelNumber());
		}

		// upc
		if (StringUtils.equals("null", info.getUpcCode())) {
			itemInfo.setUpcCode(null);
		} else if (StringUtils.isNotBlank(info.getUpcCode())) {
			itemInfo.setUpcCode(info.getUpcCode());
		}

		// vendor #
		if (StringUtils.equals("null", info.getVendorNumber())) {
			itemInfo.setBrandName(null);
		} else if (StringUtils.isNotBlank(info.getVendorNumber())) {
			itemInfo.setBrandName(info.getVendorNumber());
		}

		// store sku #
		if (SAVING_CENTER.containsKey(info.getSavingsCenter())) {
			itemInfo.setSavingsCenter(info.getSavingsCenter());
		}

		// ship type
		if (StringUtils.isNotBlank(info.getShipType())) {
			itemInfo.setShipType(Utils.convertStringToPositiveIntIgnoreException(info.getShipType()));
		}

		// class
		if (StringUtils.isNotBlank(info.getProdClass())) {
			itemInfo.setProductClass(info.getProdClass());
		}

		// sub class
		if (StringUtils.isNotBlank(info.getSubClass())) {
			itemInfo.setProductSubClass(info.getSubClass());
		}

		// department
		if (StringUtils.isNotBlank(info.getDepartment())) {
			itemInfo.setProductDepartment(info.getDepartment());
		}

		// Appliance flag
		itemInfo.setAppliance(itemInput.getAppliance());

		// BO flag
		if (itemInput.getItemAvailability() != null) {
			ItemAvail itemAvailability = itemInput.getItemAvailability();
			if (itemAvailability.isBackorderable()) {
				itemInfo.setBackorderFlag(true);
				itemInfo.setBackorderExpectedShipDate(Utils.convertStringToLocalDate(itemAvailability.getBackorderDate()));
			}
		}

		// generic brand flag
		itemInfo.setGenericBrandFlag(info.getGenericBrandFlag());
		
		// BOPIS/BOSS flags
		if (itemInput.getStoreSku() != null && itemInput.getStoreSku().getFulfillment() != null) {
			Fulfillment fm = itemInput.getStoreSku().getFulfillment();
			if (!fm.isBopisStatus()) {
				itemInfo.setBopisEligible(false);
			}
			if (!fm.isBossStatus()) {
				itemInfo.setBossEligible(false);
			}
		}
		
		// IRG
		if (info.getHasIrgItems() != null && info.getHasIrgItems()) {
			itemInfo.setHasIrgItems(true);
		}
		
		// FBR
		if (info.getHasFbrItems() != null && info.getHasFbrItems()) {
			itemInfo.setHasFbrItems(true);
		}
		
		// FBT
		if (info.getHasFbtItems() != null && info.getHasFbtItems()) {
			itemInfo.setHasFbtItems(true);
		}
		
		// Hide Price
		if (info.getHidePrice() != null && info.getHidePrice()) {
			itemInfo.setHidePrice(true);
		}
		return itemInfo;
	}
}