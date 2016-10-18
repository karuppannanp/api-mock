/**
 * 
 */
package com.homedepot.pip.cache.store;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.homedepot.pip.data.store.flags.Store;
import com.homedepot.pip.data.store.flags.Stores;

/**
 * @author KXP8101
 *
 */
public class StoreCache {
	private static Map<String, Store> STORE_CHACHE = new HashMap<>();
	private static Map<String, String> STORE_OVERLAY_CACHE = new HashMap<>();

	public static void populateStores(String storesXmlResponse) throws Exception {
		Stores stores = parseStoresXmlResponse(storesXmlResponse);
		for (Store store : stores.getStores()) {
			putStoreIntoCache(store);
		}
	}

	/**
	 * Parse Store Info Xml response.
	 * 
	 * @param storesXmlResponse
	 * @return
	 * @throws JAXBException
	 */
	private static Stores parseStoresXmlResponse(String storesXmlResponse) throws Exception {
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		return xmlMapper.readValue(storesXmlResponse, Stores.class);
	}

	public static boolean checkStoreInCache(String storeId) {
		return STORE_CHACHE.containsKey(storeId);
	}

	private static Store getStoreFromCache(String storeId) {
		return STORE_CHACHE.get(storeId);
	}

	private static void putStoreIntoCache(Store store) {
		STORE_CHACHE.put(store.getStoreId(), store);
	}

	public static boolean checkBopis(String storeId) {
		String bopis = null;
		if (checkStoreInCache(storeId)) {
			bopis = getStoreFromCache(storeId).getBopis();
			return StringUtils.equalsIgnoreCase("Y", bopis);
		}
		return false;
	}

	public static boolean checkBoss(String storeId) {
		String boss = null;
		if (checkStoreInCache(storeId)) {
			boss = getStoreFromCache(storeId).getBoss();
			return StringUtils.equalsIgnoreCase("Y", boss);
		}
		return false;
	}

	public static boolean checkBossMsg(String storeId) {
		String bossMsg = null;
		if (checkStoreInCache(storeId)) {
			bossMsg = getStoreFromCache(storeId).getBossMsg();
			return StringUtils.equalsIgnoreCase("Y", bossMsg);
		}
		return false;
	}

	public static boolean checkBodfs(String storeId) {
		String bodfs = null;
		if (checkStoreInCache(storeId)) {
			bodfs = getStoreFromCache(storeId).getBodfs();
			return StringUtils.equalsIgnoreCase("Y", bodfs);
		}
		return false;
	}

	public static String getCity(String storeId) {
		String city = null;
		if (checkStoreInCache(storeId)) {
			city = getStoreFromCache(storeId).getCity();
		}
		return city;
	}

	public static String getZipCode(String storeId) {
		String zipCode = null;
		if (checkStoreInCache(storeId)) {
			zipCode = getStoreFromCache(storeId).getZipCode();
		}
		return zipCode;
	}

	public static void updateStoreFlags(String storeId, Boolean bopis, Boolean boss, Boolean bossMsg, Boolean bodfs) {
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
	
	public static boolean checkOverlayStoreInCache(String itemId, String storeId) {
		return STORE_OVERLAY_CACHE.containsKey(getKey(itemId, storeId));
	}
	
	public static String getOverlayStoreFromCache(String itemId, String storeId) {
		return STORE_OVERLAY_CACHE.get(getKey(itemId, storeId));
	}
	
	public static void putOverlayStoreIntoCache(String itemId, String storeId, String value) {
		STORE_OVERLAY_CACHE.put(getKey(itemId, storeId), value);
	}
	
	private static String getKey(String itemId, String storeId) {
		return itemId + "-" + storeId;
	}
}