/**
 * 
 */
package com.homedepot.pip.input;

/**
 * @author KXP8101
 *
 */
public class Info {
	private String description;
	private String title;
	private String brandName;
	private String label;
	private String modelNumber;
	private String vendorNumber;

	private String upcCode;
	private String shipType;
	private String prodClass;
	private String subClass;
	private String department;
	private String limitPerOrder;

	private Boolean genericBrandFlag;
	private String savingsCenter;
	private Boolean hidePrice;

	private Boolean hasIrgItems;
	private Boolean hasFbtItems;
	private Boolean hasFbrItems;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getVendorNumber() {
		return vendorNumber;
	}

	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getProdClass() {
		return prodClass;
	}

	public void setProdClass(String prodClass) {
		this.prodClass = prodClass;
	}

	public String getSubClass() {
		return subClass;
	}

	public void setSubClass(String subClass) {
		this.subClass = subClass;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLimitPerOrder() {
		return limitPerOrder;
	}

	public void setQtyLimit(String limitPerOrder) {
		this.limitPerOrder = limitPerOrder;
	}

	public Boolean getGenericBrandFlag() {
		return genericBrandFlag;
	}

	public void setGenericBrandFlag(Boolean genericBrandFlag) {
		this.genericBrandFlag = genericBrandFlag;
	}

	public String getSavingsCenter() {
		return savingsCenter;
	}

	public void setSavingsCenter(String savingsCenter) {
		this.savingsCenter = savingsCenter;
	}

	public Boolean getHidePrice() {
		return hidePrice;
	}

	public void setHidePrice(Boolean hidePrice) {
		this.hidePrice = hidePrice;
	}

	public Boolean getHasIrgItems() {
		return hasIrgItems;
	}

	public void setHasIrgItems(Boolean hasIrgItems) {
		this.hasIrgItems = hasIrgItems;
	}

	public Boolean getHasFbtItems() {
		return hasFbtItems;
	}

	public void setHasFbtItems(Boolean hasFbtItems) {
		this.hasFbtItems = hasFbtItems;
	}

	public Boolean getHasFbrItems() {
		return hasFbrItems;
	}

	public void setHasFbrItems(Boolean hasFbrItems) {
		this.hasFbrItems = hasFbrItems;
	}
}