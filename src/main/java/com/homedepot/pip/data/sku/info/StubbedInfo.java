package com.homedepot.pip.data.sku.info;

import org.springframework.stereotype.Service;

import com.homedepot.pip.backend.domain.item.ItemInfo;
import com.homedepot.pip.input.Info;

@Service
public class StubbedInfo {

	public ItemInfo createDefaultItemInfo() {
		ItemInfo itemInfo = new ItemInfo();
		itemInfo.setBackorderFlag(false);
		itemInfo.setBrandName("The Home Depot");
		itemInfo.setBopisEligible(true);
		itemInfo.setBossEligible(true);
		itemInfo.setProductClass("10");
		itemInfo.setProductDescription(
				"Use the 5-gal. Orange Homer Bucket to haul parts, paint, topsoil and other household and work-site items. This orange, plastic bucket holds up to a 9 in. bucket grid and features the orange Home Depot logo on its side.");
		itemInfo.setGenericBrandFlag(false);
		itemInfo.setHasIrgItems(true);
		itemInfo.setAppliance(false);
		itemInfo.setTopSeller(false);
		itemInfo.setModelNumber("05GLHD2");
		itemInfo.setOnlineStatus(true);
		itemInfo.setLabel("5-gal. Homer Bucket");
		itemInfo.setShipType(33);
		itemInfo.setShowLocalPrice(false);
		itemInfo.setShowProduct(false);
		itemInfo.setStoreSkuNumber("131227");
		itemInfo.setProductSubClass("8");
		itemInfo.setUpcCode("084305355546");
		itemInfo.setVendorNumber("72792");
		return itemInfo;
	}

	public ItemInfo createItemInfo(Info info) {
		ItemInfo itemInfo = new ItemInfo();
		itemInfo.setBackorderFlag(false);
		itemInfo.setBrandName("The Home Depot");
		itemInfo.setBopisEligible(true);
		itemInfo.setBossEligible(true);
		itemInfo.setProductClass("10");
		itemInfo.setProductDescription(
				"Use the 5-gal. Orange Homer Bucket to haul parts, paint, topsoil and other household and work-site items. This orange, plastic bucket holds up to a 9 in. bucket grid and features the orange Home Depot logo on its side.");
		itemInfo.setGenericBrandFlag(false);
		itemInfo.setHasIrgItems(true);
		itemInfo.setAppliance(false);
		itemInfo.setTopSeller(false);
		itemInfo.setModelNumber("05GLHD2");
		itemInfo.setOnlineStatus(true);
		itemInfo.setLabel("5-gal. Homer Bucket");
		itemInfo.setShipType(33);
		itemInfo.setShowLocalPrice(false);
		itemInfo.setShowProduct(false);
		itemInfo.setStoreSkuNumber("131227");
		itemInfo.setProductSubClass("8");
		itemInfo.setUpcCode("084305355546");
		itemInfo.setVendorNumber("72792");
		return itemInfo;
	}
}