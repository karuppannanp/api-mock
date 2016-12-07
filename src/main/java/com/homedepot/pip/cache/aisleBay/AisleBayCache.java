/**
 * 
 */
package com.homedepot.pip.cache.aisleBay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.homedepot.pip.config.BeansConfig;
import com.homedepot.pip.input.AisleBay;
import com.homedepot.pip.input.AisleBayInfo;
import com.homedepot.pip.input.SearchReport;
import com.homedepot.pip.input.StoreSkuAisle;

/**
 * @author KXP8101
 *
 */
@Component
public class AisleBayCache {
	private static Map<String, AisleBayInfo> AISLE_BAY_CHACHE = new HashMap<>();
	
	public void putAisleBayIntoCache(String storeSkuId, String storeId, AisleBayInfo aisleBayInfo) {
		AISLE_BAY_CHACHE.put(getKey(storeSkuId, storeId), aisleBayInfo);
	}

	public void putAisleBayIntoCache(String storeId, String storeSkuId, String aisle, String bay,
			String locationDesc) {
		AisleBayInfo aisleBayInfo = createAisleBay(storeId, storeSkuId, aisle, bay, locationDesc);
		putAisleBayIntoCache(storeSkuId, storeId, aisleBayInfo);
	}

	public boolean checkAisleBayInCache(String storeSkuId, String storeId) {
		return AISLE_BAY_CHACHE.containsKey(getKey(storeSkuId, storeId));
	}

	public AisleBayInfo getAisleBayFromCache(String storeId, String storeSkuId) {
		if (checkAisleBayInCache(storeSkuId, storeId)) {
			return AISLE_BAY_CHACHE.get(getKey(storeSkuId, storeId));
		}
		return null;
	}

	public String getAisleBayJson(String storeId, String storeSkuId) throws JsonProcessingException {
		AisleBayInfo aisleBayInfo = getAisleBayFromCache(storeId, storeSkuId);
		if (aisleBayInfo != null) {
			return BeansConfig.getObjectMapper().writeValueAsString(aisleBayInfo);
		}
		return null;
	}

	public AisleBayInfo createAisleBay(String storeId, String storeSkuId, String aisle, String bay,
			String locationDesc) {
		AisleBay aisleBay = new AisleBay();
		aisleBay.setAisle(aisle);
		aisleBay.setBay(bay);
		aisleBay.setLocationDesc(locationDesc);

		StoreSkuAisle storeSku = new StoreSkuAisle();
		storeSku.setAisleBay(aisleBay);
		storeSku.setStoreSkuId(storeSkuId);

		SearchReport searchReport = new SearchReport();
		searchReport.setRecordCount(1);
		searchReport.setStoreId((storeId != null && storeId.length() == 3) ? "0" + storeId : storeId);

		List<StoreSkuAisle> storeSkus = new ArrayList<>();
		AisleBayInfo aisleBayInfo = new AisleBayInfo();
		storeSkus.add(storeSku);
		aisleBayInfo.setStoreSkus(storeSkus);
		aisleBayInfo.setSearchReport(searchReport);
		return aisleBayInfo;
	}
	
	private static String getKey(String storeSkuId, String storeId) {
		return storeSkuId + "-" + storeId;
	}
}