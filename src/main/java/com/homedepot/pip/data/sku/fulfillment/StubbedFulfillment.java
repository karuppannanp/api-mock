package com.homedepot.pip.data.sku.fulfillment;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.fullfillment.BODFSFulfillmentOption;
import com.homedepot.pip.backend.domain.fullfillment.BOPISFulfillmentOption;
import com.homedepot.pip.backend.domain.fullfillment.BOSSFulfillmentOption;
import com.homedepot.pip.backend.domain.fullfillment.FulfillmentOptions;
import com.homedepot.pip.backend.domain.fullfillment.STHFulfillmentOption;
import com.homedepot.pip.backend.domain.item.ItemAvailability;
import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.data.sku.itemAvailability.StubbedItemAvailability;
import com.homedepot.pip.input.Fulfillment;
import com.homedepot.pip.input.StoreSkuInput;

@Component
public class StubbedFulfillment {

	@Autowired
	StubbedItemAvailability stubbedItemAvailability;

	public FulfillmentOptions createDefaultFulfillmentOptions(String storeId, ItemAvailability itemAvailability) {
		FulfillmentOptions fmOptions = new FulfillmentOptions();
		fmOptions.setBuyOnlinePickupInStore(createBopisFulfillmentOption(true, true, null, storeId));
		fmOptions.setDeliverFromStore(createBodfsFulfillmentOption(null, null, storeId));
		if (itemAvailability.getInventoryStatus() != null
				&& (itemAvailability.getInventoryStatus() || !itemAvailability.getInventoryStatus()
						&& itemAvailability.getBackorderable() != null && itemAvailability.getBackorderable()))
			fmOptions.setShipToHome(createSthFulfillmentOption());
		return fmOptions;
	}

	public FulfillmentOptions createFulfillmentOptions(StoreSkuInput storeSku, String storeId,
			ItemAvailability itemAvailability) {
		FulfillmentOptions fmOptions = new FulfillmentOptions();
		if (storeSku.getFulfillment() != null) {
			fmOptions = createFulfillmentOptions(storeSku.getFulfillment(), storeId, itemAvailability);
		} else {
			fmOptions = createDefaultFulfillmentOptions(storeId, itemAvailability);
		}
		return fmOptions;
	}

	public FulfillmentOptions createFulfillmentOptions(Fulfillment fulfillment, String storeId,
			ItemAvailability itemAvailability) {
		FulfillmentOptions fmOptions = new FulfillmentOptions();

		// BOPIS/BOSS
		if (fulfillment.isBopisStatus() || fulfillment.isBopisCheckNearby()) {
			fmOptions.setBuyOnlinePickupInStore(createBopisFulfillmentOption(fulfillment.isBopisStatus(),
					fulfillment.isBopisCheckNearby(), fulfillment.getAlphaPrompt(), storeId));
		} else if (fulfillment.isBossStatus()) {
			createBossOption(storeId);
		}

		// BODFS
		if (fulfillment.isBodfsStatus()) {
			fmOptions.setDeliverFromStore(
					createBodfsFulfillmentOption(fulfillment.getBodfsCharge(), fulfillment.getAlphaPrompt(), storeId));
		}

		// STH
		if (fulfillment.isSthStatus() && stubbedItemAvailability.isItemAvailableOnline(itemAvailability)) {
			fmOptions.setShipToHome(createSthFulfillmentOption());
		}
		return fmOptions;
	}

	public BOPISFulfillmentOption createBopisFulfillmentOption(boolean eligibilityStatus, boolean checkStoreLink,
			String alphaPromptRestriction, String storeId) {
		BOPISFulfillmentOption bopisOption = null;
		if (StoreCache.checkStoreInCache(storeId)) {
			bopisOption = new BOPISFulfillmentOption();
			bopisOption.setAlphaPromptRestriction(alphaPromptRestriction);
			bopisOption.setCheckStoreLink(checkStoreLink);
			if (StoreCache.checkBopis(storeId)) {
				bopisOption.setEligibilityStatus(eligibilityStatus);
			}
		}
		return bopisOption;
	}

	public STHFulfillmentOption createSthFulfillmentOption() {
		STHFulfillmentOption sthOption = new STHFulfillmentOption();
		sthOption.setEligibilityStatus(true);
		return sthOption;
	}

	public BODFSFulfillmentOption createBodfsFulfillmentOption(String estDeliveryCharge, String alphaPromptRestriction,
			String storeId) {
		BODFSFulfillmentOption bodfsOption = null;
		if (StoreCache.checkBodfs(storeId)) {
			bodfsOption = new BODFSFulfillmentOption();
			bodfsOption.setAlphaPromptRestriction(alphaPromptRestriction);
			bodfsOption.setEligibilityStatus(true);
			if (StringUtils.isBlank(estDeliveryCharge)) {
				estDeliveryCharge = "29.0";
			}
			bodfsOption.setEstDeliveryCharge(estDeliveryCharge);
		}
		return bodfsOption;
	}

	public BOSSFulfillmentOption createBossOption(String storeId) {
		BOSSFulfillmentOption bossOption = null;
		if (StoreCache.checkBoss(storeId)) {
			bossOption = new BOSSFulfillmentOption();
			bossOption.setEligibilityStatus(true);
		}
		return bossOption;
	}
}