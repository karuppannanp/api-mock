/**
 * 
 */
package com.homedepot.pip.backend.store.fulfillment;

/**
 * @author KXP8101
 *
 */
public class Sku {

	private String itemId;
	private String title;
	private Media media;
	private boolean buyOnlinePickupInStoreEligible;
	private boolean buyOnlineShipToStoreEligible;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public boolean isBuyOnlinePickupInStoreEligible() {
		return buyOnlinePickupInStoreEligible;
	}

	public void setBuyOnlinePickupInStoreEligible(boolean buyOnlinePickupInStoreEligible) {
		this.buyOnlinePickupInStoreEligible = buyOnlinePickupInStoreEligible;
	}

	public boolean isBuyOnlineShipToStoreEligible() {
		return buyOnlineShipToStoreEligible;
	}

	public void setBuyOnlineShipToStoreEligible(boolean buyOnlineShipToStoreEligible) {
		this.buyOnlineShipToStoreEligible = buyOnlineShipToStoreEligible;
	}
}
