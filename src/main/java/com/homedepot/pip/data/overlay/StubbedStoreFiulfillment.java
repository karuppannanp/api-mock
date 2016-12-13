package com.homedepot.pip.data.overlay;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.store.fulfillment.AlternateStores;
import com.homedepot.pip.backend.store.fulfillment.AvailabilityMessage;
import com.homedepot.pip.backend.store.fulfillment.AvailabilityMessages;
import com.homedepot.pip.backend.store.fulfillment.BuyOnlinePickupInStore;
import com.homedepot.pip.backend.store.fulfillment.BuyOnlineShipToStore;
import com.homedepot.pip.backend.store.fulfillment.FulfillmentOptions;
import com.homedepot.pip.backend.store.fulfillment.Inventory;
import com.homedepot.pip.backend.store.fulfillment.Media;
import com.homedepot.pip.backend.store.fulfillment.MediaEntry;
import com.homedepot.pip.backend.store.fulfillment.PrimaryStore;
import com.homedepot.pip.backend.store.fulfillment.Sku;
import com.homedepot.pip.backend.store.fulfillment.Store;
import com.homedepot.pip.backend.store.fulfillment.StoreFulfillment;
import com.homedepot.pip.backend.store.fulfillment.StoreFulfillmentDetails;
import com.homedepot.pip.backend.store.fulfillment.StoreSearchResponse;
import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.config.BeansConfig;
import com.homedepot.pip.util.Utils;
import com.homedepot.pip.util.http.Connection;

@Component
public class StubbedStoreFiulfillment {

	@Autowired
	private Connection connection;

	@Autowired
	private StoreCache storeCache;

	@Autowired
	private BeansConfig beansConfig;

	public String getStoreFulfillment(String itemId, String storeId) throws Exception {
		return beansConfig.getObjectMapper().writeValueAsString(storeFulfillmentResponse(itemId, storeId));
	}

	private StoreFulfillment storeFulfillmentResponse(String itemId, String storeId) throws Exception {
		String cacheValue = storeCache.getOverlayStoreFromCache(itemId, storeId);
		String[] storesParam = cacheValue.split("~~~~");
		String primary = null;
		String nearby = null;
		if (storesParam != null) {
			if (storesParam.length == 1) {
				primary = storesParam[0];
			} else if (storesParam.length == 2) {
				primary = storesParam[0];
				nearby = storesParam[1];
			}
		}
		List<Store> stores = getStoresBySearch(storeId).getStores();
		StoreFulfillmentDetails storeFulfillmentDetails = new StoreFulfillmentDetails();
		storeFulfillmentDetails.setSku(createSku(itemId, cacheValue));
		storeFulfillmentDetails.setInventoryStatusTimestamp(Utils.getCurrentTime());
		storeFulfillmentDetails.setPrimaryStore(createPrimaryStore(primary, stores.get(0)));
		storeFulfillmentDetails.setAlternateStores(createAlternateStores(nearby, stores));

		StoreFulfillment storeFulfillment = new StoreFulfillment();
		storeFulfillment.setStoreFulfillmentDetails(storeFulfillmentDetails);
		return storeFulfillment;
	}

	private PrimaryStore createPrimaryStore(String primary, PrimaryStore store) {
		if (StringUtils.isBlank(primary)) {
			return null;
		}
		FulfillmentOptions fulfillmentOptions = null;
		if (primary.startsWith("bopis")) {
			fulfillmentOptions = createBopisFulfillmentOptions(primary, true);
		} else if (primary.startsWith("boss")) {
			fulfillmentOptions = createBossFulfillmentOptions();
		}
		if (fulfillmentOptions != null) {
			store.setFulfillmentOptions(fulfillmentOptions);
		}
		return store;
	}

	private AlternateStores createAlternateStores(String nearby, List<Store> stores) {
		if (StringUtils.isBlank(nearby)) {
			return null;
		}
		String[] options = nearby.split("\\|");
		AlternateStores alternateStores = null;
		List<Store> storesFiltered = new ArrayList<>();
		for (int count = 0; count < options.length; count++) {
			String option = options[count];
			Store store = stores.get(count + 1);
			FulfillmentOptions fulfillmentOptions = null;
			if (option != null) {
				if (option.startsWith("bopis")) {
					fulfillmentOptions = createBopisFulfillmentOptions(option, false);
				} else if (option.startsWith("boss")) {
					fulfillmentOptions = createBossFulfillmentOptions();
				}
			}
			if (fulfillmentOptions != null) {
				store.setFulfillmentOptions(fulfillmentOptions);
				storesFiltered.add(store);
			}
			if (storesFiltered.size() > 0) {
				alternateStores = new AlternateStores();
				alternateStores.setStores(storesFiltered);
			}
		}
		return alternateStores;
	}

	private FulfillmentOptions createBossFulfillmentOptions() {
		BuyOnlineShipToStore buyOnlineShipToStore = new BuyOnlineShipToStore();
		buyOnlineShipToStore.setEstStartDeliveryDate(Utils.generateOverlayBossDate(5));
		buyOnlineShipToStore.setEstEndDeliveryDate(Utils.generateOverlayBossDate(7));

		FulfillmentOptions fulfillmentOptions = new FulfillmentOptions();
		fulfillmentOptions.setFulfillable(true);
		fulfillmentOptions.setBuyOnlineShipToStore(buyOnlineShipToStore);
		return fulfillmentOptions;
	}

	private FulfillmentOptions createBopisFulfillmentOptions(String option, boolean primaryStore) {
		String[] params = option.split("-");
		String inventory = "na";
		boolean alphaPrompt = false;
		if (params.length == 2) {
			inventory = params[1];
		} else if (params.length == 3) {
			inventory = params[1];
			alphaPrompt = checkAlphaPromptRestriction(params[2]);
		}

		FulfillmentOptions fulfillmentOptions = null;
		if (checkValidInventory(inventory)) {
			fulfillmentOptions = createInStockBopisFulfillment(Integer.parseInt(inventory), alphaPrompt);
		} else if ("limited".equalsIgnoreCase(inventory)) {
			fulfillmentOptions = createLimitedStockBopisFulfillment(alphaPrompt);
		} else if (primaryStore && "0".equalsIgnoreCase(inventory)) {
			fulfillmentOptions = createOosBopisFulfillment(alphaPrompt);
		} else if (primaryStore) {
			fulfillmentOptions = createEmptyBopisFulfillment();
		}
		return fulfillmentOptions;
	}

	private boolean checkAlphaPromptRestriction(String alphaPromptRestriction) {
		return StringUtils.equalsIgnoreCase("SUPPRESS", alphaPromptRestriction);
	}

	private BuyOnlinePickupInStore getInStockBuyOnlinePickupInStore(int inv, boolean alphaPrompt) {
		Inventory inventory = new Inventory();
		inventory.setExpectedQuantityAvailable(inv);
		inventory.setOnHandQuantity(inv + 1);

		BuyOnlinePickupInStore buyOnlinePickupInStore = new BuyOnlinePickupInStore();
		if (alphaPrompt) {
			setAlphaPromtRestriction(buyOnlinePickupInStore);
		}
		buyOnlinePickupInStore.setInventory(inventory);
		return buyOnlinePickupInStore;
	}

	private BuyOnlinePickupInStore getLimitedStockBuyOnlinePickupInStore(boolean alphaPrompt) {
		Inventory inventory = new Inventory();
		inventory.setExpectedQuantityAvailable(0);
		inventory.setOnHandQuantity(1);

		BuyOnlinePickupInStore buyOnlinePickupInStore = new BuyOnlinePickupInStore();
		if (alphaPrompt) {
			setAlphaPromtRestriction(buyOnlinePickupInStore);
		}
		buyOnlinePickupInStore.setInventory(inventory);
		return buyOnlinePickupInStore;
	}

	private BuyOnlinePickupInStore getOosStockBuyOnlinePickupInStore(boolean alphaPrompt) {
		Inventory inventory = new Inventory();
		inventory.setExpectedQuantityAvailable(0);
		inventory.setOnHandQuantity(0);

		BuyOnlinePickupInStore buyOnlinePickupInStore = new BuyOnlinePickupInStore();
		if (alphaPrompt) {
			setAlphaPromtRestriction(buyOnlinePickupInStore);
		}
		buyOnlinePickupInStore.setInventory(inventory);
		return buyOnlinePickupInStore;
	}

	private AvailabilityMessages getInStockAvailabilityMessage(int quantity) {
		AvailabilityMessages availabilityMessages = new AvailabilityMessages();
		AvailabilityMessage availabilityMessage = new AvailabilityMessage();
		availabilityMessage.setMessageKey("OVERLAY_FULFILLMENT_102");
		availabilityMessage.setMessageValue(quantity + " in stock");
		availabilityMessages.setAvailabilityMessage(availabilityMessage);
		return availabilityMessages;
	}

	private AvailabilityMessages getLimitedStockAvailabilityMessage() {
		AvailabilityMessages availabilityMessages = new AvailabilityMessages();
		AvailabilityMessage availabilityMessage = new AvailabilityMessage();
		availabilityMessage.setMessageKey("OVERLAY_FULFILLMENT_101");
		availabilityMessage.setMessageValue("Limited quantities available");
		availabilityMessages.setAvailabilityMessage(availabilityMessage);
		return availabilityMessages;
	}

	private AvailabilityMessages getOosStockAvailabilityMessage() {
		AvailabilityMessages availabilityMessages = new AvailabilityMessages();
		AvailabilityMessage availabilityMessage = new AvailabilityMessage();
		availabilityMessage.setMessageKey("OVERLAY_FULFILLMENT_100");
		availabilityMessage.setMessageValue("Out of stock");
		availabilityMessages.setAvailabilityMessage(availabilityMessage);
		return availabilityMessages;
	}

	private FulfillmentOptions createEmptyBopisFulfillment() {
		FulfillmentOptions fulfillmentOptions = new FulfillmentOptions();
		fulfillmentOptions.setFulfillable(false);
		return fulfillmentOptions;
	}

	private FulfillmentOptions createInStockBopisFulfillment(int inv, boolean alphaPrompt) {
		FulfillmentOptions fulfillmentOptions = new FulfillmentOptions();
		fulfillmentOptions.setFulfillable(true);
		fulfillmentOptions.setAvailabilityMessages(getInStockAvailabilityMessage(inv));
		fulfillmentOptions.setBuyOnlinePickupInStore(getInStockBuyOnlinePickupInStore(inv, alphaPrompt));
		return fulfillmentOptions;
	}

	private FulfillmentOptions createLimitedStockBopisFulfillment(boolean alphaPrompt) {
		FulfillmentOptions fulfillmentOptions = new FulfillmentOptions();
		fulfillmentOptions.setFulfillable(true);
		fulfillmentOptions.setAvailabilityMessages(getLimitedStockAvailabilityMessage());
		fulfillmentOptions.setBuyOnlinePickupInStore(getLimitedStockBuyOnlinePickupInStore(alphaPrompt));
		return fulfillmentOptions;
	}

	private FulfillmentOptions createOosBopisFulfillment(boolean alphaPrompt) {
		FulfillmentOptions fulfillmentOptions = new FulfillmentOptions();
		fulfillmentOptions.setFulfillable(true);
		fulfillmentOptions.setAvailabilityMessages(getOosStockAvailabilityMessage());
		fulfillmentOptions.setBuyOnlinePickupInStore(getOosStockBuyOnlinePickupInStore(alphaPrompt));
		return fulfillmentOptions;
	}

	private boolean checkValidInventory(String inventory) {
		int parsedInv = -1;
		try {
			parsedInv = Integer.parseInt(inventory);
		} catch (Exception exception) {
			return false;
		}
		if (parsedInv > 0) {
			return true;
		}
		return false;
	}

	private Sku createSku(String itemId, String cacheValue) {
		Sku sku = new Sku();
		sku.setItemId(itemId);
		sku.setTitle("Everbilt 5/8 in. x 7 in. Zinc Hex Bolt");
		sku.setBuyOnlinePickupInStoreEligible(checkBopisEligibility(cacheValue));
		sku.setBuyOnlineShipToStoreEligible(checkBossEligibility(cacheValue));
		setMedia(sku);
		return sku;
	}

	private void setAlphaPromtRestriction(BuyOnlinePickupInStore buyOnlinePickupInStore) {
		buyOnlinePickupInStore.setAlphaPromptRestriction("SUPPRESS");
		buyOnlinePickupInStore.setAlphaPromptMessage("Not available online.Please visit store to Purchase.");
	}

	private String makeStoreSearchCall(String searchVal) throws Exception {
		String storeSearchServicesUrl = "http://origin.api.homedepot.com/StoreSearchServices/v2/storesearch?radius=50&address="
				+ searchVal + "&type=json&pagesize=40";
		return connection.makeRequest(storeSearchServicesUrl);
	}

	private StoreSearchResponse getStoresBySearch(String searchVal) throws Exception {
		return beansConfig.getObjectMapper().readValue(makeStoreSearchCall(searchVal), StoreSearchResponse.class);
	}

	private boolean checkBopisEligibility(String value) {
		return (StringUtils.contains(value, "bopis"));
	}

	private boolean checkBossEligibility(String value) {
		return (StringUtils.contains(value, "boss"));
	}

	private void setMedia(Sku sku) {
		MediaEntry mediaEntry = new MediaEntry();
		mediaEntry.setLocation(
				"http://www.homedepot.com/catalog/productImages/65/6d/6d15344a-3508-4a73-aa02-e71b69ecd12e_65.jpg");
		mediaEntry.setMediaType("IMAGE");

		Media media = new Media();
		media.setMediaEntry(mediaEntry);

		sku.setMedia(media);
	}
}