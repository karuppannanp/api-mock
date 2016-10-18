package com.homedepot.pip.request.api;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.pip.cache.aisleBay.AisleBayCache;
import com.homedepot.pip.cache.sku.ItemCache;
import com.homedepot.pip.cache.store.StoreCache;
import com.homedepot.pip.input.Info;
import com.homedepot.pip.input.Price;
import com.homedepot.pip.request.business.CacheSkuCreator;
import com.homedepot.pip.request.validator.RequestValidator;

@RestController
@RequestMapping("/data/")
public class SkuCreationController {

	private static final String SUCCESS_JSON = "{\"success\":true}";
	private static final String BAD_REQUEST_JSON = "{\"error\":\"One or more input parameters are invalid\"}";
	private static final String NOT_FOUND_JSON = "{\"error\":\"The item does not exist. Please create one.\"}";
	//private static final String INTERNAL_ERROR_JSON = "{\"error\":\"Internal Server Error\"}";

	@Autowired
	RequestValidator requestValidator;

	@Autowired
	CacheSkuCreator cacheSkuCreator;

	@RequestMapping(value = "sku/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createSku(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "appliance") boolean appliance,
			@RequestParam(value = "storeId", required = false) String storeId,
			@RequestParam(value = "storeSkuId", required = false) String storeSkuId,
			@RequestParam(value = "protectionPlanSku", required = false) String protectionPlanSku,
			@RequestParam(value = "itemType", required = false) String itemType,
			@RequestParam(value = "availabilityType", required = false) String availabilityType,
			@RequestParam(value = "parentId", required = false) String parentId) {

		if (!requestValidator.isItemIdValid(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		cacheSkuCreator.createBasicItem(itemId, appliance, storeId, storeSkuId, protectionPlanSku, itemType, availabilityType, parentId);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/itemAvailability", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createItemAvailability(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "buyable", defaultValue = "true") boolean buyable,
			@RequestParam(value = "discontinued", required = false) boolean discontinued,
			@RequestParam(value = "inventoryStatus", defaultValue = "true") boolean inventoryStatus,
			@RequestParam(value = "backorderable", required = false) boolean backorderable,
			@RequestParam(value = "published", defaultValue = "true") boolean published,
			@RequestParam(value = "backorderDate", required = false) String backorderDate) {
		
		if (!requestValidator.isItemIdValid(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		
		cacheSkuCreator.createItemAvailability(itemId, buyable, inventoryStatus, backorderable, published, discontinued,
				backorderDate);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/promotion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createPromotion(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "longDescription", required = false) String longDescription) {
		
		if (!requestValidator.isItemIdValid(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		cacheSkuCreator.createPromotion(itemId, code, description, startDate, endDate, longDescription);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/rating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createRatings(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId, @RequestParam(value = "rating") String rating,
			@RequestParam(value = "count") String count) {

		if (!requestValidator.isRatingsParameterValid(itemId, rating, count)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		cacheSkuCreator.createRating(itemId, rating, count);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/rebate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createShipping(HttpServletResponse res, @RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "rebate") boolean rebate) {
		
		if (!requestValidator.isItemIdValid(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		cacheSkuCreator.createRebate(itemId, rebate);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/inventory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createInventory(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "inventory") String inventory) {

		if (!requestValidator.isInventoryParameterValid(itemId, inventory)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		
		if (!requestValidator.isItemMerchandise(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "\"error\":\"This item is not Merchandise.\"";
		}
		
		cacheSkuCreator.createInventory(itemId, inventory);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createInfo(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "brandName", required = false) String brandName,
			@RequestParam(value = "label", required = false) String label,
			@RequestParam(value = "modelNumber", required = false) String modelNumber,
			@RequestParam(value = "vendorNumber", required = false) String vendorNumber,
			@RequestParam(value = "upcCode", required = false) String upcCode,
			@RequestParam(value = "shipType", required = false) String shipType,
			@RequestParam(value = "prodClass", required = false) String prodClass,
			@RequestParam(value = "subClass", required = false) String subClass,
			@RequestParam(value = "department", required = false) String department,
			@RequestParam(value = "limitPerOrder", required = false) String limitPerOrder,
			@RequestParam(value = "genericBrandFlag", required = false) Boolean genericBrandFlag,
			@RequestParam(value = "savingsCenter", required = false) String savingsCenter,
			@RequestParam(value = "hidePrice", required = false) Boolean hidePrice,
			@RequestParam(value = "hasIrgItems", required = false) Boolean hasIrgItems,
			@RequestParam(value = "hasFbtItems", required = false) Boolean hasFbtItems,
			@RequestParam(value = "hasFbrItems", required = false) Boolean hasFbrItems) {
		Info info = new Info();
		info.setDescription(description);
		info.setTitle(title);
		info.setBrandName(brandName);
		info.setLabel(label);
		info.setModelNumber(modelNumber);
		info.setVendorNumber(vendorNumber);
		info.setUpcCode(upcCode);
		info.setShipType(shipType);
		info.setProdClass(prodClass);
		info.setSubClass(subClass);
		info.setDepartment(department);
		info.setQtyLimit(limitPerOrder);
		info.setGenericBrandFlag(genericBrandFlag);
		info.setSavingsCenter(savingsCenter);
		info.setHidePrice(hidePrice);
		info.setHasIrgItems(hasIrgItems);
		info.setHasFbtItems(hasFbtItems);
		info.setHasFbrItems(hasFbrItems);
		
		if (!requestValidator.isItemIdValid(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		cacheSkuCreator.createInfo(itemId, info);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/shipping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createShipping(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "messageNumber", required = false) String messageNumber,
			@RequestParam(value = "sthStartDate", required = false) String sthStartDate,
			@RequestParam(value = "sthEndDate", required = false) String sthEndDate,
			@RequestParam(value = "bossStartDate", required = false) String bossStartDate,
			@RequestParam(value = "bossEndDate", required = false) String bossEndDate,
			@RequestParam(value = "dynamicEta", required = false) Boolean dynamicEta,
			@RequestParam(value = "timeLeftHrs", required = false) String timeLeftHrs,
			@RequestParam(value = "timeLeftMins", required = false) String timeLeftMins,
			@RequestParam(value = "threshold", required = false) String threshold,
			@RequestParam(value = "excludedShipStates", required = false) String excludedShipStates) {

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		
		if (!requestValidator.isItemIdValid(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isDynamicEtaParameterValid(dynamicEta, timeLeftHrs, timeLeftMins)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "{\"error\":\"Dynamic ETA parameters are not valid.\"}";
		}
		
		cacheSkuCreator.createShipping(itemId, messageNumber, sthStartDate, sthEndDate, bossStartDate, bossEndDate,
				dynamicEta, timeLeftHrs, timeLeftMins, threshold, excludedShipStates);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/fulfillment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createFulfillment(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "sthStatus", defaultValue = "false") boolean sthStatus,
			@RequestParam(value = "bopisStatus", defaultValue = "false") boolean bopisStatus,
			@RequestParam(value = "bopisCheckNearby", defaultValue = "false") boolean bopisCheckNearby,
			@RequestParam(value = "bossStatus", defaultValue = "false") boolean bossStatus,
			@RequestParam(value = "bodfsStatus", defaultValue = "false") boolean bodfsStatus,
			@RequestParam(value = "bodfsCharge", required = false) String bodfsCharge,
			@RequestParam(value = "alphaPrompt", required = false) String alphaPrompt) {
		
		if (!requestValidator.isItemIdValid(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		
		cacheSkuCreator.createFulfillment(itemId, sthStatus, bopisStatus, bopisCheckNearby, bossStatus, bodfsStatus, bodfsCharge, alphaPrompt);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String deleteItemCache(HttpServletResponse res, String itemId) {

		if (!requestValidator.isItemIdValid(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		
		ItemCache.clearItemCacheByItemId(itemId);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/price", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createPrice(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "storeId", required = false) String storeId,
			@RequestParam(value = "uom", required = false) String uom,
			@RequestParam(value = "originalPrice", required = false) Double originalPrice,
			@RequestParam(value = "specialPrice", required = false) Double specialPrice,
			@RequestParam(value = "specialBuyPrice", required = false) Double specialBuyPrice,
			@RequestParam(value = "mapAboveOriginalPrice", required = false) Boolean mapAboveOriginalPrice,
			@RequestParam(value = "alternatePriceDisplay", defaultValue = "true") boolean alternatePriceDisplay,
			@RequestParam(value = "unitsPerCase", required = false) String unitsPerCase,
			@RequestParam(value = "caseUnitUom", required = false) String caseUnitUom,
			@RequestParam(value = "bulkPrice", required = false) Double bulkPrice,
			@RequestParam(value = "bulkPriceThresholdQty", required = false) Double bulkPriceThresholdQty) {
		
		Price price = new Price();
		price.setUom(uom);
		price.setOriginalPrice(originalPrice);
		price.setSpecialPrice(specialPrice);
		price.setSpecialBuyPrice(specialBuyPrice);
		price.setMapAboveOriginalPrice(mapAboveOriginalPrice);
		
		price.setAlternatePriceDisplay(alternatePriceDisplay);
		price.setUnitsPerCase(unitsPerCase);
		price.setCaseUnitUom(caseUnitUom);
		
		price.setBulkPrice(bulkPrice);
		price.setBulkPriceThresholdQty(bulkPriceThresholdQty);
		
		cacheSkuCreator.createPrice(price, itemId);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/attribute", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createAttribute(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "groupName") String groupName,
			@RequestParam(value = "guid") String guid,
			@RequestParam(value = "value") String value,
			@RequestParam(value = "bulleted", required = false) Boolean bulleted) {
		
		cacheSkuCreator.createAttributeGroup(itemId, groupName, guid, value, bulleted);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/delete/attribute", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String deleteAttributeGroup(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "groupName") String groupName) {
		
		cacheSkuCreator.deleteAttributeGroupByName(itemId, groupName);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/media", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createMedia() {
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/aisleBay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createAisleBay(HttpServletResponse res,
			@RequestParam(value = "storeSkuId") String storeSkuId,
			@RequestParam(value = "aisle") String aisle,
			@RequestParam(value = "bay") String bay,
			@RequestParam(value = "locationDesc", required = false) String locationDesc,
			@RequestParam(value = "storeId") String storeId) {
		
		if (!requestValidator.isStoreIdValid(storeId) || !requestValidator.isStoreSkuIdValid(storeSkuId)) {
			return BAD_REQUEST_JSON;
		}
		AisleBayCache.putAisleBayIntoCache(storeId, storeSkuId, aisle, bay, locationDesc);
		return SUCCESS_JSON;
	}

	@RequestMapping(value = "sku/create/overlay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createInventoryOverlay(HttpServletResponse res,
			@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "storeId") String storeId,
			@RequestParam(value = "primary") String primary,
			@RequestParam(value = "nearby", required = false) String nearby) {

		if (!requestValidator.isItemInCache(itemId)) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return NOT_FOUND_JSON;
		}
		
		if (!requestValidator.isStoreIdValid(storeId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return BAD_REQUEST_JSON;
		}
		
		if (!requestValidator.isItemMerchandise(itemId)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "\"error\":\"This item is not Merchandise.\"";
		}
		
		if (!requestValidator.isOverlayPrimaryParamValid(primary)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "{\"error\":\"The primary and/or nearby parameters are invalid.\"}";
		}
		
		String value = primary;
		if (StringUtils.isNotBlank(nearby)) {
			value += "~~~~" + nearby;
		}
		
		StoreCache.putOverlayStoreIntoCache(itemId, storeId, value.toLowerCase());
		return SUCCESS_JSON;
	}
}