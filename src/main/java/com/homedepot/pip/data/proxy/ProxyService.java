/**
 * 
 */
package com.homedepot.pip.data.proxy;

import org.springframework.stereotype.Component;

import com.homedepot.pip.util.constant.Constants;
import com.homedepot.pip.util.http.Connection;

/**
 * @author KXP8101
 *
 */
@Component
public class ProxyService {

	public String optionsRegistry() throws Exception {
		String url = "http://" + Constants.ENV_DEPENEDENT_API_HOST + "/wcs/resources/killswitch/KillSwitchesService/loadoptionsfromdb";
		return Connection.INSTANCE.makeRequest(url);
	}

	public String storesRegistry() throws Exception {
		String url = "http://" + Constants.ENV_DEPENEDENT_API_HOST + "/wcs/resources/LoadStoreInfo/StoreInfoService/loadStoreInfo";
		return Connection.INSTANCE.makeRequest(url);
	}

	public String skuService(String itemId, String storeId, String key, String additionalAttributeGrp, String show) throws Exception {
		String url = "http://" + Constants.ENV_DEPENEDENT_API_HOST + "/ProductAPI/v2/products/sku?itemId=" + itemId
				+ "&storeId=" + storeId + "&show=" + show + "&additionalAttributeGrp=" + additionalAttributeGrp + "&key=" + key;
		return Connection.INSTANCE.makeRequest(url);
	}

	public String aisleBayService(String storeSkuId, String storeId, String key) throws Exception {
		String url = "http://" + Constants.ENV_DEPENEDENT_API_HOST + "/ProductAPI/v2/aisleBay?storeSkuid=" + storeSkuId
				+ "&storeid=" + storeId + "&key=" + key;
		return Connection.INSTANCE.makeRequest(url);
	}

	public String storeFulfillmentService(String itemId, String localStoreId, String keyword, String key)
			throws Exception {
		String url = "http://" + Constants.ENV_DEPENEDENT_API_HOST + "/ProductAPI/v2/products/sku/" + itemId
				+ "/storefulfillment?itemId=" + itemId + "&keyword=" + keyword + "&localStoreId=" + localStoreId
				+ "&key=" + key;
		return Connection.INSTANCE.makeRequest(url);
	}

	public String metadataService(String productId, String key) throws Exception {
		String url = "http://" + Constants.ENV_DEPENEDENT_API_HOST + "/ProductAPI/v2/products/sku/" + productId
				+ "/storefulfillment?type=json&key=" + key;
		return Connection.INSTANCE.makeRequest(url);
	}

	public boolean checkSkuInProductApi(String itemId) {
		try {
			String url = "http://" + Constants.ENV_DEPENEDENT_API_HOST + "/ProductAPI/v2/products/sku?itemId=" + itemId
					+ "&show=info" + "&key=tRXWvUBGuAwEzFHScjLw9ktZ0Bw7a335";
			Connection.INSTANCE.makeRequest(url);
		} catch (Exception exception) {
			return false;
		}
		return true;
	}
}