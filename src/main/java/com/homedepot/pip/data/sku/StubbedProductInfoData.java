package com.homedepot.pip.data.sku;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Enums;
import com.homedepot.pip.backend.domain.Product;
import com.homedepot.pip.backend.domain.Products;
import com.homedepot.pip.backend.domain.item.Item;
import com.homedepot.pip.cache.sku.ItemCache;
import com.homedepot.pip.data.sku.attributeGroup.StubbedAttributeGroup;
import com.homedepot.pip.data.sku.info.StubbedInfo;
import com.homedepot.pip.data.sku.itemAvailability.StubbedItemAvailability;
import com.homedepot.pip.data.sku.media.StubbedMedia;
import com.homedepot.pip.data.sku.promotion.StubbedPromotion;
import com.homedepot.pip.data.sku.ratingsAndReviews.StubbedRatingAndReview;
import com.homedepot.pip.data.sku.shipping.StubbedShipping;
import com.homedepot.pip.data.sku.storeSku.StubbedStoreSku;
import com.homedepot.pip.enums.ItemAvailabilityType;
import com.homedepot.pip.enums.ItemType;
import com.homedepot.pip.input.ItemInput;

@Service
public class StubbedProductInfoData {

	@Autowired
	private StubbedMedia stubbedMedia;

	@Autowired
	private StubbedPromotion stubbedPromotion;

	@Autowired
	private StubbedItemAvailability stubbedItemAvailability;

	@Autowired
	private StubbedRatingAndReview stubbedRatingAndReview;

	@Autowired
	private StubbedAttributeGroup stubbedAttributeGroup;

	@Autowired
	private StubbedShipping stubbedShipping;

	@Autowired
	private StubbedInfo stubbedInfo;

	@Autowired
	private StubbedStoreSku stubbedStoreSku;

	public Products createProducts(String itemId, String storeId) {
		Products products = new Products();
		ArrayList<Product> productList = new ArrayList<Product>();
		if (ItemCache.checkItemInCache(itemId)) {
			ItemInput item = ItemCache.getItemFromCache(itemId);
			item.setStoreId(storeId);
			productList.add(createProductsFromItemCache(item));
		} else {
			productList.add(createDefaultNonSuperSkuProduct(itemId, storeId));
		}
		products.setProductList(productList);
		return products;
	}

	public Product createProductsFromItemCache(ItemInput item) {
		Product product = new Product();
		product.setDefaultItemId(item.getItemId());
		product.setSuperSku(item.isSuperSku());
		product.setProductId(item.getItemId());
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(createSkuFromItemCache(item));
		product.setItems(itemList);
		return product;
	}

	public Product createDefaultNonSuperSkuProduct(String itemId, String storeId) {
		Product product = new Product();
		product.setDefaultItemId(itemId);
		product.setSuperSku(false);
		product.setProductId(itemId);
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(createDefaultSku(itemId, storeId));
		product.setItems(itemList);
		return product;
	}

	public Product createProduct(String productId, Boolean superSku, String defaultItemId, ArrayList<Item> items) {
		Product product = new Product();
		product.setDefaultItemId(defaultItemId);
		product.setSuperSku(superSku);
		product.setProductId(productId);
		if (items == null || items.size() == 0) {
			items = new ArrayList<Item>();
			items.add(createDefaultSku(defaultItemId, "8119"));
			product.setItems(items);
		}
		return product;
	}

	public Item createSkuFromItemCache(ItemInput itemInput) {
		Item item = setItemDetails(itemInput.getItemId(), itemInput.getItemType(), itemInput.getAvailabilityType(),
				itemInput.getParentId(), null, itemInput.getProtectionPlanSku());
		
		// ITEM INFO
		if (itemInput.getInfo() != null) {
			item.setItemInfo(stubbedInfo.createItemInfo(itemInput.getInfo()));
		} else {
			item.setItemInfo(stubbedInfo.createDefaultItemInfo());
		}

		// ITEM MEDIA
		if (itemInput.getMedia() != null) {
			item.setItemMedia(stubbedMedia.createDefaultItemMediaTypeImage()); // TODO
		} else {
			item.setItemMedia(stubbedMedia.createDefaultItemMediaTypeImage());
		}

		// ITEM AVAILABILITY
		if (itemInput.getItemAvailability() != null) {
			item.setItemAvailability(stubbedItemAvailability.createItemAvailability(itemInput.getItemAvailability(),
					itemInput.getAvailabilityType(), itemInput.isAppliance()));
		} else {
			item.setItemAvailability(stubbedItemAvailability.createDefaultItemAvailability(itemInput.getAvailabilityType()));
		}

		// STORE SKU
		if (itemInput.getStoreSku() != null) {
			item.setStoreSkus(stubbedStoreSku.createStoreSku(itemInput));
		} else {
			item.setStoreSkus(stubbedStoreSku.createDefaultStoreSku(itemInput, itemInput.getStoreId()));
		}

		// ITEM PROMOTION
		if (itemInput.getPromotion() != null) {
			item.setItemPromotion(
					stubbedPromotion.createItemPromotion(itemInput.getItemId(), itemInput.getPromotion()));
		}

		// ITEM RATING
		if (itemInput.getRating() != null) {
			item.setItemRating(stubbedRatingAndReview.createItemRating(itemInput.getRating()));
		} else {
			item.setItemRating(stubbedRatingAndReview.createDefaultItemRating());
		}
		
		// ATTRIBUTE GROUPS
		item.setAttributeGroups(stubbedAttributeGroup.createDomainGroupList(itemInput));

		// REBATES
		item.setRebates(stubbedPromotion.createRebates(itemInput.isRebates()));

		// ITEM SHIPPING
		if (itemInput.getShipping() != null) {
			item.setItemShipping(stubbedShipping.createItemShipping(itemInput));
		} else {
			item.setItemShipping(stubbedShipping.createDefaultItemShipping(itemInput.isAppliance()));
		}

		return item;
	}

	public Item createDefaultSku(String itemId, String storeId) {
		Item item = setItemDetails(itemId, null, null, null, null, null);

		item.setItemInfo(stubbedInfo.createDefaultItemInfo());

		item.setItemMedia(stubbedMedia.createDefaultItemMediaTypeImage());

		item.setItemAvailability(stubbedItemAvailability
				.createDefaultItemAvailability(ItemAvailabilityType.SHARED));

		item.setStoreSkus(stubbedStoreSku.createDefaultStoreSku(null, storeId));

		item.setItemPromotion(stubbedPromotion.createDefaultItemPromotion(itemId));

		item.setItemRating(stubbedRatingAndReview.createDefaultItemRating());

		item.setAttributeGroups(stubbedAttributeGroup.createDomainGroupList(null));

		item.setRebates(stubbedPromotion.createDefaultRebates());

		item.setItemShipping(stubbedShipping.createDefaultItemShipping(false));

		return item;
	}

	public Item setItemDetails(String itemId, String itemType, String availabilityType, String parentId,
			String partNumber, String protectionPlanSku) {
		Item item = new Item();
		item.setItemId(itemId);
		item.setAvailabilityType(availabilityType);
		item.setCanonicalURL("/p/test-product/" + itemId);
		item.setWebUrl("http://www.homedepot.com" + item.getCanonicalURL());
		setItemType(item, itemType);
		setItemAvailabilityType(item, availabilityType);
		item.setParentId(parentId);
		item.setPartNumber(partNumber);
		item.setProtectionPlanSku(protectionPlanSku);
		return item;
	}

	public void setItemType(Item item, String itemType) {
		if (StringUtils.isNotBlank(itemType) && Enums.getIfPresent(ItemType.class, itemType).isPresent()) {
			item.setItemType(itemType);
		} else {
			item.setItemType(ItemType.MERCHANDISE.getItemType());
		}
	}

	public void setItemAvailabilityType(Item item, String availabilityType) {
		if (ItemAvailabilityType.isValidItemAvailabilityType(availabilityType)) {
			item.setAvailabilityType(availabilityType);
		} else {
			item.setAvailabilityType(ItemAvailabilityType.SHARED);
		}
	}
}