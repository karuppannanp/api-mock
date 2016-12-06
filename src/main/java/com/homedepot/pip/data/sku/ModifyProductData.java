package com.homedepot.pip.data.sku;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.pip.backend.domain.Product;
import com.homedepot.pip.backend.domain.Products;
import com.homedepot.pip.backend.domain.item.Item;
import com.homedepot.pip.data.sku.attributeGroup.StubbedAttributeGroup;
import com.homedepot.pip.data.sku.info.StubbedInfo;
import com.homedepot.pip.data.sku.itemAvailability.StubbedItemAvailability;
import com.homedepot.pip.data.sku.media.StubbedMedia;
import com.homedepot.pip.data.sku.promotion.StubbedPromotion;
import com.homedepot.pip.data.sku.ratingsAndReviews.StubbedRatingAndReview;
import com.homedepot.pip.data.sku.shipping.StubbedShipping;
import com.homedepot.pip.data.sku.storeSku.StubbedStoreSku;
import com.homedepot.pip.input.ItemInput;

@Service
public class ModifyProductData {

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

	public Products modifyProductsFromItemCache(ItemInput itemInput, Products products) {
		ArrayList<Product> productList = products.getProductList();
		for (Product product : productList) {
			ArrayList<Item> itemList = product.getItems();
			for (Item item : itemList) {
				modifyItemFromItemCache(itemInput, item);
				break;
			}
			break;
		}
		return products;
	}

	
	public Item modifyItemFromItemCache(ItemInput itemInput, Item item) {
		//Item item = setItemDetails(itemInput.getItemId(), itemInput.getItemType(), itemInput.getAvailabilityType(),
			//	itemInput.getParentId(), null, itemInput.getProtectionPlanSku());
		
		// ITEM INFO
		if (itemInput.getInfo() != null) {
			item.setItemInfo(stubbedInfo.modifyItemInfo(itemInput, item.getItemInfo()));
		}

		// ITEM MEDIA TODO
		if (itemInput.getMedia() != null) {
			item.setItemMedia(stubbedMedia.createItemMedia(itemInput.getMedia()));
		}

		// ITEM AVAILABILITY TODO
		if (itemInput.getItemAvailability() != null) {
			item.setItemAvailability(stubbedItemAvailability.createItemAvailability(itemInput.getItemAvailability(),
					itemInput.getAvailabilityType(), itemInput.getAppliance()));
		} else {
			item.setItemAvailability(stubbedItemAvailability.createDefaultItemAvailability(itemInput.getAvailabilityType()));
		}

		// STORE SKU TODO
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
		}
		
		// ATTRIBUTE GROUPS
		item.setAttributeGroups(stubbedAttributeGroup.createDomainGroupList(itemInput));

		// REBATES
		if (itemInput.getRebates() != null) {
			item.setRebates(stubbedPromotion.createRebates(itemInput.getRebates()));
		}

		// ITEM SHIPPING TODO
		if (itemInput.getShipping() != null) {
			item.setItemShipping(stubbedShipping.createItemShipping(itemInput));
		} else {
			item.setItemShipping(stubbedShipping.createDefaultItemShipping(itemInput.getAppliance()));
		}

		return item;
	}
}