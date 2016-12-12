/**
 * 
 */
package com.homedepot.pip.cache.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.config.BeansConfig;
import com.homedepot.pip.data.store.flags.Store;
import com.homedepot.pip.data.store.flags.Stores;
import com.homedepot.pip.util.constant.Constants;
import com.homedepot.pip.util.http.Connection;

/**
 * @author KXP8101
 *
 */

@Component
public class StoreCache {
	
	@Autowired
	private Connection connection;

	private static Map<String, Store> STORE_CHACHE = new HashMap<>();
	private static Map<String, String> STORE_OVERLAY_CACHE = new HashMap<>();

	private void populateStores() {
		String storesXmlResponse = getStoresResponse();
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
	
	private String getStoresResponse() {
		String storesResponse = null;
		try {
			if (Constants.IS_SIMULATOR_ENABLED) {
				storesResponse = readStoresFromFile();
			} else {
				storesResponse = connection.makeRequest(
						"http://origin.api.homedepot.com/wcs/resources/LoadStoreInfo/StoreInfoService/loadStoreInfo");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return storesResponse;
	}

	/**
	 * Parse Store Info Xml response.
	 */
	private Stores parseStoresXmlResponse(String storesXmlResponse) throws Exception {
		return BeansConfig.getXmlMapper().readValue(storesXmlResponse, Stores.class);
	}

	public boolean checkStoreInCache(String storeId) {
		if (STORE_CHACHE.size() == 0) {
			populateStores();
		}
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

	private static String readStoresFromFile() throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/sample/Stores.xml")));
		String line;
		StringBuilder storesBuilder = new StringBuilder();

		while ((line = br.readLine()) != null) {
			storesBuilder.append(line.trim());
		}
		br.close();
		System.out.println("Total time taken to read Stores xml file: " + (System.currentTimeMillis() - start));
		return storesBuilder.toString();
	}
}