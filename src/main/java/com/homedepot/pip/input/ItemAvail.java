/**
 * 
 */
package com.homedepot.pip.input;

/**
 * @author KXP8101
 *
 */
public class ItemAvail {

	private boolean buyable = true;
	private boolean inventoryStatus = true;
	private boolean backorderable;
	private boolean published = true;
	private boolean discontinued;
	private String backorderDate;
	private int storeStatus = 0;
	private int onlineStatus = 0;

	public String getBackorderDate() {
		return backorderDate;
	}

	public void setBackorderDate(String backorderDate) {
		this.backorderDate = backorderDate;
	}

	public boolean isBuyable() {
		return buyable;
	}

	public void setBuyable(boolean buyable) {
		this.buyable = buyable;
	}

	public boolean isInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(boolean inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public boolean isBackorderable() {
		return backorderable;
	}

	public void setBackorderable(boolean backorderable) {
		this.backorderable = backorderable;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public int getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(int storeStatus) {
		this.storeStatus = storeStatus;
	}

	public int getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(int onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
}