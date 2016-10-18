package com.homedepot.pip.enums;

public enum ItemType {

	MERCHANDISE("MERCHANDISE"),
	MAJOR_APPLIANCE("MAJOR_APPLIANCE"),
	CONFIGURABLE_BLINDS("CONFIGURABLE_BLINDS");

	private String itemType;

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType
	 *            the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	private ItemType(String itemType) {
		this.itemType = itemType;
	}
}