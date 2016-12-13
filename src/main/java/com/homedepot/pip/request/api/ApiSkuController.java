package com.homedepot.pip.request.api;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.pip.backend.domain.Products;
import com.homedepot.pip.cache.aisleBay.AisleBayCache;
import com.homedepot.pip.cache.sku.ItemCache;
import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.config.BeansConfig;
import com.homedepot.pip.data.deserialization.DeserializationService;
import com.homedepot.pip.data.overlay.StubbedStoreFiulfillment;
import com.homedepot.pip.data.proxy.ProxyService;
import com.homedepot.pip.data.sku.ModifyProductData;
import com.homedepot.pip.data.sku.StubbedProductData;
import com.homedepot.pip.input.ItemInput;
import com.homedepot.pip.request.validator.RequestValidator;
import com.homedepot.pip.util.constant.Constants;

@RestController
@RequestMapping("/ProductAPI/v2/")
public class ApiSkuController {

	@Autowired
	private StubbedProductData stubbedProductData;
	
	@Autowired
	private StoreCache storeCache;
	
	@Autowired
	private ModifyProductData modifyProductData;
	
	@Autowired
	private DeserializationService deserializationService;

	@Autowired
	private RequestValidator requestValidator;
	
	@Autowired
	private StubbedStoreFiulfillment stubbedStoreFiulfillment;
	
	@Autowired
	private ProxyService proxyService;
	
	@Autowired
	private AisleBayCache aisleBayCache;

	@Autowired
	private BeansConfig beansConfig;

	@RequestMapping("test")
	public String index() {
		System.out.println("heyyyyyyyyyyyyyyy");
		return "index";
	}

	@RequestMapping(value = "products/sku", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public String getSku(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "storeId") String storeId,
			@RequestParam(value = "key") String key,
			@RequestParam(value = "additionalAttributeGrp", required = false) String additionalAttributeGrp,
			@RequestParam(value = "show", required = false) String show) throws Exception {
		System.out.println("products/sku");
		if (!requestValidator.isKeyValid(key) || !requestValidator.isStoreAndOnlineStoreIdValid(storeId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "<error>Input parameters are not valid</error>";
		}

		if (!requestValidator.isItemInCache(itemId)) {
			if (Constants.IS_PROXY_ENABLED) {
				return proxyService.skuService(itemId, storeId, key, additionalAttributeGrp, show);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return "<error>Product Not Found</error>";
			}
		} else {
			ItemInput itemInput = ItemCache.getItemFromCache(itemId);
			Products products = null;
			if (itemInput.isModifyRealData() && Constants.IS_PROXY_ENABLED) {
				products = deserializationService.skuService(itemId, storeId, key, additionalAttributeGrp, show);
				products = modifyProductData.modifyProductsFromItemCache(itemInput, products);
			} else {
				products = stubbedProductData.createProducts(itemId, storeId);
			}
			try {
				return beansConfig.getXmlMapper().writeValueAsString(products);
			} catch (Exception exception) {
				System.out.println(exception);
				res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return "<error>Some error occurred. Please try again</error>";
			}
		}
	}

	@RequestMapping(value = "aisleBay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAisleBay(HttpServletResponse res,
			@RequestParam(value = "storeid") String storeId,
			@RequestParam(value = "key") String key,
			@RequestParam(value = "storeSkuid") String storeSkuId,
			@RequestParam(value = "callback", required = false) String callback) throws Exception {
		
		System.out.println("aisleBay");
		String response = "";

		if (!"tRXWvUBGuAwEzFHScjLw9ktZ0Bw7a335".equals(key) || !requestValidator.isStoreSkuIdValid(storeSkuId)
				|| !requestValidator.isStoreIdValid(storeId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "<error>Input parameters are not valid</error>";
		}

		if (!aisleBayCache.checkAisleBayInCache(storeSkuId, storeId)) {
			if (Constants.IS_PROXY_ENABLED) {
				response = proxyService.aisleBayService(storeSkuId, storeId, key);
				if (StringUtils.isNotBlank(callback)) {
					response = callback + "(" + response + ")";
				}
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response = "{\"error\":\"Sku or sku-storeId combination not found\"}";
			}
		} else {
			response = aisleBayCache.getAisleBayJson(storeId, storeSkuId);
			if (StringUtils.isNotBlank(callback)) {
				response = callback + "(" + response + ")";
			}
		}
		return response;
	}

	@RequestMapping(value = "products/sku/{itemId}/storefulfillment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getStoreFulfillment(HttpServletResponse res,
			@PathVariable(value = "itemId") String itemId,
			@RequestParam(value = "keyword") String keyword,
			@RequestParam(value = "key") String key,
			@RequestParam(value = "localStoreId") String localStoreId,
			@RequestParam(value = "callback", required = false) String callback) throws Exception {

		System.out.println("products/sku/{itemId}/storefulfillment");
		String response = "";
		
		if (!"tRXWvUBGuAwEzFHScjLw9ktZ0Bw7a335".equals(key)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "<error>Input parameters are not valid</error>";
		}

		if (!requestValidator.isItemInCache(itemId) || !storeCache.checkOverlayStoreInCache(itemId, localStoreId)) {
			if (Constants.IS_PROXY_ENABLED) {
				response = proxyService.storeFulfillmentService(itemId, localStoreId, keyword, key);
				if (StringUtils.isNotBlank(callback)) {
					response = callback + "(" + response + ")";
				}
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response = "{\"error\":\"Item Id or itemId-storeId combination not found\"}";
			}
		} else {
			response = stubbedStoreFiulfillment.getStoreFulfillment(itemId, localStoreId);
			if (StringUtils.isNotBlank(callback)) {
				response = callback + "(" + response + ")";
			}
		}
		return response;
	}
	
	@RequestMapping(value = "products/{productId}/metadata", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public String getMetadata(HttpServletResponse res,
			@PathVariable(value = "productId") String productId,
			@RequestParam(value = "key") String key) throws Exception {
		System.out.println("products/{productId}/metadata");

		if (!"tRXWvUBGuAwEzFHScjLw9ktZ0Bw7a335".equals(key)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "<error>Input parameters are not valid</error>";
		}
		return proxyService.metadataService(productId, key);
	}
}