/**
 * 
 */
package com.homedepot.pip.data.deserialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.pip.backend.domain.Products;
import com.homedepot.pip.config.BeansConfig;
import com.homedepot.pip.data.proxy.ProxyService;

/**
 * @author KXP8101
 *
 */
@Service
public class DeserializationService {
	
	@Autowired
	private ProxyService proxyService;

	public Products skuService(String itemId, String storeId, String key, String additionalAttributeGrp, String show)
			throws Exception {
		String productsString = proxyService.skuService(itemId, storeId, key, additionalAttributeGrp, show);
		return BeansConfig.getXmlMapper().readValue(productsString, Products.class);
	}
}