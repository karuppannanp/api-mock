/**
 * 
 */
package com.homedepot.pip.request.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.cache.store.StoreCache;

/**
 * @author KXP8101
 *
 */

@Component
public class RequestProcessor {
	
	@Autowired
	private StoreCache storeCache;
	
	public void putOverlayStoreIntoCache(String itemId, String storeId, String primary, String nearby) {
		storeCache.putOverlayStoreIntoCache(itemId, storeId, primary + "~~~~" + nearby);
	}

	public void parseLocalStore(String localStoreParam) {
		//String localStoreOptions = null;
	}
}