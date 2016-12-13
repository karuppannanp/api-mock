/**
 * 
 */
package com.homedepot.pip.cache.store;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.config.BeansConfig;
import com.homedepot.pip.data.store.flags.Store;
import com.homedepot.pip.data.store.flags.Stores;

/**
 * @author KXP8101
 *
 */

@Component
public class StoreCache {

	@Autowired
	private BeansConfig beansConfig;

	private static Map<String, Store> STORE_CHACHE = new HashMap<>();
	private static Map<String, String> STORE_OVERLAY_CACHE = new HashMap<>();

	public void populateStores(String storesXmlResponse) {
		if (storesXmlResponse == null) {
			return;
		}
		Stores stores;
		try {
			stores = parseStoresXmlResponse(storesXmlResponse);
			for (Store store : stores.getStores()) {
				putStoreIntoCache(store);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Parse Store Info Xml response.
	 */
	private Stores parseStoresXmlResponse(String storesXmlResponse) throws Exception {
		return beansConfig.getXmlMapper().readValue(storesXmlResponse, Stores.class);
	}

	public boolean checkStoreInCache(String storeId) {
		return STORE_CHACHE.containsKey(storeId);
	}

	private Store getStoreFromCache(String storeId) {
		return STORE_CHACHE.get(storeId);
	}

	private void putStoreIntoCache(Store store) {
		STORE_CHACHE.put(store.getStoreId(), store);
	}

	public boolean checkBopis(String storeId) {
		String bopis = null;
		if (checkStoreInCache(storeId)) {
			bopis = getStoreFromCache(storeId).getBopis();
			return StringUtils.equalsIgnoreCase("Y", bopis);
		}
		return false;
	}

	public boolean checkBoss(String storeId) {
		String boss = null;
		if (checkStoreInCache(storeId)) {
			boss = getStoreFromCache(storeId).getBoss();
			return StringUtils.equalsIgnoreCase("Y", boss);
		}
		return false;
	}

	public boolean checkBossMsg(String storeId) {
		String bossMsg = null;
		if (checkStoreInCache(storeId)) {
			bossMsg = getStoreFromCache(storeId).getBossMsg();
			return StringUtils.equalsIgnoreCase("Y", bossMsg);
		}
		return false;
	}

	public boolean checkBodfs(String storeId) {
		String bodfs = null;
		if (checkStoreInCache(storeId)) {
			bodfs = getStoreFromCache(storeId).getBodfs();
			return StringUtils.equalsIgnoreCase("Y", bodfs);
		}
		return false;
	}

	public String getCity(String storeId) {
		String city = null;
		if (checkStoreInCache(storeId)) {
			city = getStoreFromCache(storeId).getCity();
		}
		return city;
	}

	public String getZipCode(String storeId) {
		String zipCode = null;
		if (checkStoreInCache(storeId)) {
			zipCode = getStoreFromCache(storeId).getZipCode();
		}
		return zipCode;
	}

	public void updateStoreFlags(String storeId, Boolean bopis, Boolean boss, Boolean bossMsg, Boolean bodfs) {
		Store store = getStoreFromCache(storeId);
		if (bopis != null && bopis) {
			store.setBopis("Y");
		} else if (bopis != null && !bopis) {
			store.setBopis("N");
		}

		if (boss != null && boss) {
			store.setBoss("Y");
		} else if (boss != null && !boss) {
			store.setBoss("N");
		}

		if (bossMsg != null && bossMsg) {
			store.setBossMsg("Y");
		} else if (bossMsg != null && !bossMsg) {
			store.setBossMsg("N");
		}

		if (bodfs != null && bodfs) {
			store.setBodfs("Y");
		} else if (bodfs != null && !bodfs) {
			store.setBodfs("N");
		}
		putStoreIntoCache(store);
	}
	
	public boolean checkOverlayStoreInCache(String itemId, String storeId) {
		return STORE_OVERLAY_CACHE.containsKey(getKey(itemId, storeId));
	}
	
	public String getOverlayStoreFromCache(String itemId, String storeId) {
		return STORE_OVERLAY_CACHE.get(getKey(itemId, storeId));
	}
	
	public void putOverlayStoreIntoCache(String itemId, String storeId, String value) {
		STORE_OVERLAY_CACHE.put(getKey(itemId, storeId), value);
	}
	
	private String getKey(String itemId, String storeId) {
		return itemId + "-" + storeId;
	}
}