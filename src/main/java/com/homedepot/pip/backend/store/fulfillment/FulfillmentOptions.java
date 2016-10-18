/**
 * 
 */
package com.homedepot.pip.backend.store.fulfillment;

/**
 * @author KXP8101
 *
 */
public class FulfillmentOptions {

	private boolean fulfillable;
	private BuyOnlinePickupInStore buyOnlinePickupInStore;
	private BuyOnlineShipToStore buyOnlineShipToStore;
	private AvailabilityMessages availabilityMessages;

	public boolean isFulfillable() {
		return fulfillable;
	}

	public void setFulfillable(boolean fulfillable) {
		this.fulfillable = fulfillable;
	}

	public BuyOnlinePickupInStore getBuyOnlinePickupInStore() {
		return buyOnlinePickupInStore;
	}

	public void setBuyOnlinePickupInStore(BuyOnlinePickupInStore buyOnlinePickupInStore) {
		this.buyOnlinePickupInStore = buyOnlinePickupInStore;
	}

	public BuyOnlineShipToStore getBuyOnlineShipToStore() {
		return buyOnlineShipToStore;
	}

	public void setBuyOnlineShipToStore(BuyOnlineShipToStore buyOnlineShipToStore) {
		this.buyOnlineShipToStore = buyOnlineShipToStore;
	}

	public AvailabilityMessages getAvailabilityMessages() {
		return availabilityMessages;
	}

	public void setAvailabilityMessages(AvailabilityMessages availabilityMessages) {
		this.availabilityMessages = availabilityMessages;
	}
}