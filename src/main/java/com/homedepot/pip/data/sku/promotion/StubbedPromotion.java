package com.homedepot.pip.data.sku.promotion;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.Promotion;
import com.homedepot.pip.backend.domain.Rebates;
import com.homedepot.pip.backend.domain.item.ItemPromotion;
import com.homedepot.pip.input.PromoInput;

@Component
public class StubbedPromotion {
	
	public ItemPromotion createDefaultItemPromotion(String itemId) {
		ArrayList<Promotion> promotions = new ArrayList<>();
		promotions.add(createDefaultPromotion(itemId));
		ItemPromotion itemPromotion = new ItemPromotion();
		itemPromotion.setPromotionList(promotions);
		return itemPromotion;
	}
	
	public ItemPromotion createItemPromotion(String itemId, PromoInput promotion) {
		ArrayList<Promotion> promotions = new ArrayList<>();
		promotions.add(createPromotion(itemId, promotion.getCode(), promotion.getDescription(),
				promotion.getStartDate(), promotion.getEndDate(), promotion.getLongDescription()));
		ItemPromotion itemPromotion = new ItemPromotion();
		itemPromotion.setPromotionList(promotions);
		return itemPromotion;
	}
	
	public Promotion createPromotion(String itemId, String promoCode, String promoDescription,
			String discountStartDate, String discountEndDate, String promoLongDescription) {
		Promotion promotion = new Promotion();
		promotion.setPromoCatentryId(itemId);
		promotion.setPromoCode(promoCode);
		promotion.setPromoDescription(promoDescription);
		promotion.setPromoLongDescription(promoLongDescription);
		promotion.setPromoUrl("http://www.homedepot.com/webapp/wcs/stores/servlet/DiscountDetailsDisplayView?storeId=10051&langId=-1&catalogId=10053&productId=" + itemId + "&code=" + promoCode);
		promotion.setDiscountStartDate(discountStartDate);
		promotion.setDiscountEndDate(discountEndDate);
		promotion.setPromoType("DISCOUNT");
		return promotion;
	}

	private Promotion createDefaultPromotion(String itemId) {
		String promoDescription = "Price includes 10% off Appliances Offer discounts. While supplies last.";
		String promoLongDescription = "10% off Appliances Offer ends October 19. 10% off discount taken off of Special Buy retail. Limited time offer.";
		return createPromotion(itemId, "10103469", promoDescription, "09/29/2016", "10/16/2017", promoLongDescription);
	}
	
	public Rebates createDefaultRebates() {
        return createRebates(false);
	}
	
	public Rebates createRebates(boolean hasEcoRebates) {
		Rebates rebates = new Rebates();
        rebates.setHasEcoRebates(hasEcoRebates);
        return rebates;
	}
}