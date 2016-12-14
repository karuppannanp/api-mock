/**
 * 
 */
package com.homedepot.pip.data.proxy;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homedepot.pip.config.BeansConfig;
import com.homedepot.pip.util.http.Connection;

/**
 * @author KXP8101
 *
 */
@Component
public class ProxyService {
	
	@Autowired
	private Connection connection;

	@Autowired
	private BeansConfig beansConfig;

	public String optionsRegistry() throws Exception {
		String url = beansConfig.getOnPremApiHost() + "/wcs/resources/killswitch/KillSwitchesService/loadoptionsfromdb";
		return connection.makeRequest(url);
	}

	public String storesRegistry() throws Exception {
		String url = beansConfig.getOnPremApiHost() + "/wcs/resources/LoadStoreInfo/StoreInfoService/loadStoreInfo";
		return connection.makeRequest(url);
	}

	public String skuService(String itemId, String storeId, String key, String additionalAttributeGrp, String show)
			throws Exception {
		StringBuilder url = new StringBuilder();

		url.append(beansConfig.getOnPremApiHost()).append("/ProductAPI/v2/products/sku?itemId=")
				.append(itemId);
		if (StringUtils.isNotBlank(storeId)) {
			url.append("&storeId=").append(storeId);
		}
		if (StringUtils.isNotBlank(show)) {
			url.append("&show=").append(show);
		}
		if (StringUtils.isNotBlank(additionalAttributeGrp)) {
			url.append("&additionalAttributeGrp=").append(additionalAttributeGrp);
		}
		url.append("&key=").append(key);
		return connection.makeRequest(url.toString());
	}

	public String aisleBayService(String storeSkuId, String storeId, String key) throws Exception {
		String url = beansConfig.getOnPremApiHost() + "/ProductAPI/v2/aisleBay?storeSkuid=" + storeSkuId
				+ "&storeid=" + storeId + "&key=" + key;
		return connection.makeRequest(url);
	}

	public String storeFulfillmentService(String itemId, String localStoreId, String keyword, String key)
			throws Exception {
		String url = beansConfig.getOnPremApiHost() + "/ProductAPI/v2/products/sku/" + itemId
				+ "/storefulfillment?itemId=" + itemId + "&keyword=" + keyword + "&localStoreId=" + localStoreId
				+ "&key=" + key;
		return connection.makeRequest(url);
	}

	public String metadataService(String productId, String key) throws Exception {
		String url = beansConfig.getOnPremApiHost() + "/ProductAPI/v2/products/sku/" + productId
				+ "/storefulfillment?type=json&key=" + key;
		return connection.makeRequest(url);
	}

	public boolean checkSkuInProductApi(String itemId) {
		try {
			String url = beansConfig.getOnPremApiHost() + "/ProductAPI/v2/products/sku?itemId=" + itemId
					+ "&show=info" + "&key=tRXWvUBGuAwEzFHScjLw9ktZ0Bw7a335";
			connection.makeRequest(url);
		} catch (Exception exception) {
			return false;
		}
		return true;
	}

	public String parentIrgService(String itemId, String storeId, String irgCount, String key) throws Exception {
		String url = beansConfig.getGcpApiHost() + "/irg/v1?itemId=" + itemId
				+ "&storeId=" + storeId + "&irgCount=" + irgCount + "&key=" + key;
		return connection.makeRequest(url);
	}

	public String childIrgService(String irgIds, String storeId, String key) throws Exception {
		String url = beansConfig.getGcpApiHost() + "/irg/v1?irgIds=" + irgIds
				+ "&storeId=" + storeId + "&key=" + key;
		return connection.makeRequest(url);
	}

	public String fbtService(String itemId, String storeId, String key) throws Exception {
		StringBuilder url = new StringBuilder();
		url.append(beansConfig.getGcpApiHost()).append("/fbt/v1?itemId=").append(itemId).append("&key=" + key);
		if (StringUtils.isNotBlank(storeId)) {
			url.append("&storeId=").append(storeId);
		}
		return connection.makeRequest(url.toString());
	}

	public String fbrService(String itemId, String storeId, String key) throws Exception {
		StringBuilder url = new StringBuilder();
		url.append(beansConfig.getGcpApiHost()).append("/fbr/v1?itemId=").append(itemId).append("&key=" + key);
		if (StringUtils.isNotBlank(storeId)) {
			url.append("&storeId=").append(storeId);
		}
		return connection.makeRequest(url.toString());
	}
}