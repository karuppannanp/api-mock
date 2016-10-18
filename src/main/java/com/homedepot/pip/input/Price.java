package com.homedepot.pip.input;

public class Price {

	private String uom;
	private Double originalPrice;
	private Double specialPrice;
	private Double specialBuyPrice;
	private Boolean mapAboveOriginalPrice;

	private boolean alternatePriceDisplay;
	private String unitsPerCase = "0.0";
	private String caseUnitUom;

	private Double bulkPrice;
	private Double bulkPriceThresholdQty;

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}

	public Double getSpecialBuyPrice() {
		return specialBuyPrice;
	}

	public void setSpecialBuyPrice(Double specialBuyPrice) {
		this.specialBuyPrice = specialBuyPrice;
	}

	public Boolean getMapAboveOriginalPrice() {
		return mapAboveOriginalPrice;
	}

	public void setMapAboveOriginalPrice(Boolean mapAboveOriginalPrice) {
		this.mapAboveOriginalPrice = mapAboveOriginalPrice;
	}

	public Boolean getAlternatePriceDisplay() {
		return alternatePriceDisplay;
	}

	public void setAlternatePriceDisplay(Boolean alternatePriceDisplay) {
		this.alternatePriceDisplay = alternatePriceDisplay;
	}

	public String getUnitsPerCase() {
		return unitsPerCase;
	}

	public void setUnitsPerCase(String unitsPerCase) {
		this.unitsPerCase = unitsPerCase;
	}

	public String getCaseUnitUom() {
		return caseUnitUom;
	}

	public void setCaseUnitUom(String caseUnitUom) {
		this.caseUnitUom = caseUnitUom;
	}

	public Double getBulkPrice() {
		return bulkPrice;
	}

	public void setBulkPrice(Double bulkPrice) {
		this.bulkPrice = bulkPrice;
	}

	public Double getBulkPriceThresholdQty() {
		return bulkPriceThresholdQty;
	}

	public void setBulkPriceThresholdQty(Double bulkPriceThresholdQty) {
		this.bulkPriceThresholdQty = bulkPriceThresholdQty;
	}
}