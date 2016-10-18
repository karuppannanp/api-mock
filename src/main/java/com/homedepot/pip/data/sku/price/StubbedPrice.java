package com.homedepot.pip.data.sku.price;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.homedepot.pip.backend.domain.item.ItemPrice;
import com.homedepot.pip.input.Price;

@Service
public class StubbedPrice {
	
	public ItemPrice createDefaultStorePrice(boolean appliance) {
        ItemPrice itemPrice = new ItemPrice();
        itemPrice.setAlternatePriceDisplay(false);
        itemPrice.setDollarOff(5.5);
        itemPrice.setLowerPrice(false);
        itemPrice.setOriginalPrice(12.9);
        itemPrice.setPercentageOff(43.0);
        itemPrice.setSpecialPrice(7.4);
        itemPrice.setUnitsPerCase("0.0");
        itemPrice.setUom("each");
        return itemPrice;
	}
	
	public ItemPrice createDefaultOnlinePrice(boolean appliance) {
        ItemPrice itemPrice = new ItemPrice();
        itemPrice.setAlternatePriceDisplay(false);
        itemPrice.setDollarOff(4.0);
        itemPrice.setLowerPrice(false);
        itemPrice.setOriginalPrice(12.9);
        itemPrice.setPercentageOff(31.0);
        itemPrice.setSpecialPrice(8.9);
        itemPrice.setUnitsPerCase("0.0");
        itemPrice.setUom("each");
        return itemPrice;
	}
	
	public ItemPrice createPrice(Price price, boolean appliance) {
		ItemPrice itemPrice = new ItemPrice();
		
		itemPrice.setUom(price.getUom());
		if (price.getMapAboveOriginalPrice() != null) {
			itemPrice.setMapAboveOriginalPrice(price.getMapAboveOriginalPrice());
			itemPrice.setPricingMessage("see final price in cart");
		}
		
		setBulkPrice(itemPrice, price);
		if (appliance) {
			setSpecialBuyPrice(itemPrice, price);
		}
		setSpecialPrice(itemPrice, price);
		setUnitCasePrice(itemPrice, price);
		
		return itemPrice;
	}
	
	private void setBulkPrice(ItemPrice itemPrice, Price price) {
		if (price.getBulkPrice() != null && price.getBulkPrice() > 0 && price.getBulkPriceThresholdQty() != null
				&& price.getBulkPriceThresholdQty() > 0) {
			itemPrice.setBulkPrice(price.getBulkPrice());
			itemPrice.setBulkPriceThresholdQty(price.getBulkPriceThresholdQty());
		}
	}
	
	private void setSpecialBuyPrice(ItemPrice itemPrice, Price price) {
		if (price.getSpecialBuyPrice() != null && price.getSpecialBuyPrice() > 0
				&& price.getSpecialBuyPrice() < price.getOriginalPrice()) {
			itemPrice.setSpecialBuyPrice(price.getSpecialBuyPrice());
			itemPrice.setSpecialBuyDollarOff(price.getOriginalPrice() - price.getSpecialBuyPrice());
			itemPrice.setSpecialBuyPercentageOff(getPercentageOff(price.getOriginalPrice(), price.getSpecialBuyPrice()));
		}
	}
	
	private void setSpecialPrice(ItemPrice itemPrice, Price price) {
		if (price.getSpecialPrice() != null && price.getOriginalPrice() != null
				&& price.getOriginalPrice() > price.getSpecialPrice()) {
			itemPrice.setOriginalPrice(price.getOriginalPrice());
			itemPrice.setSpecialPrice(price.getSpecialPrice());
			itemPrice.setDollarOff(price.getOriginalPrice() - price.getSpecialPrice());
			itemPrice.setPercentageOff(getPercentageOff(price.getOriginalPrice(), price.getSpecialPrice()));
		} else {
			itemPrice.setSpecialPrice(price.getOriginalPrice());
		}
	}
	
	private void setUnitCasePrice(ItemPrice itemPrice, Price price) {
		if (StringUtils.isNotBlank(price.getUnitsPerCase())) {
			int unitsPerCase = convertStringToInt(price.getUnitsPerCase());
			if (unitsPerCase > 0) {
				itemPrice.setCaseUnitUom(price.getCaseUnitUom());
				itemPrice.setUnitOriginalPrice((price.getOriginalPrice() / unitsPerCase) + "");
				itemPrice.setUnitSpecialPrice((price.getSpecialPrice() / unitsPerCase) + "");
			}
		}
	}
	
	private int convertStringToInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception exception) {
		}
		return 0;
	}
	
	private Double getPercentageOff(Double larger, Double smaller) {
		Double percentageOff = ((larger - smaller) / larger) * 100;
		if (percentageOff >= 0) {
			percentageOff = new Double(Math.round(percentageOff));
		} else {
			percentageOff = 0.0;
		}
		return percentageOff;
	}
}