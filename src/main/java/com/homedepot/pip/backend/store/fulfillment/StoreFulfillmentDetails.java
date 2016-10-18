/**
 * 
 */
package com.homedepot.pip.backend.store.fulfillment;

/**
 * @author KXP8101
 *
 */
public class StoreFulfillmentDetails {

	private Sku sku;
	private PrimaryStore primaryStore;
	private AlternateStores alternateStores;
	private String inventoryStatusTimestamp;

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public PrimaryStore getPrimaryStore() {
		return primaryStore;
	}

	public void setPrimaryStore(PrimaryStore primaryStore) {
		this.primaryStore = primaryStore;
	}

	public AlternateStores getAlternateStores() {
		return alternateStores;
	}

	public void setAlternateStores(AlternateStores alternateStores) {
		this.alternateStores = alternateStores;
	}

	public String getInventoryStatusTimestamp() {
		return inventoryStatusTimestamp;
	}

	public void setInventoryStatusTimestamp(String inventoryStatusTimestamp) {
		this.inventoryStatusTimestamp = inventoryStatusTimestamp;
	}
}