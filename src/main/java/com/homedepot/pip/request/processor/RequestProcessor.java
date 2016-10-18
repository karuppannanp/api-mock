/**
 * 
 */
package com.homedepot.pip.request.processor;

import org.springframework.stereotype.Component;

import com.homedepot.pip.cache.store.StoreCache;

/**
 * @author KXP8101
 *
 */

@Component
public class RequestProcessor {
	
	public void putOverlayStoreIntoCache(String itemId, String storeId, String primary, String nearby) {
		StoreCache.putOverlayStoreIntoCache(itemId, storeId, primary + "~~~~" + nearby);
	}

	public void parseLocalStore(String localStoreParam) {
		//String localStoreOptions = null;
	}
}