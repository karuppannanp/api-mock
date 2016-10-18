/**
 * 
 */
package com.homedepot.pip.input;

/**
 * @author KXP8101
 *
 */
public class StoreSkuInput {

	private String inventory;
	private Fulfillment fulfillment;
	private Price price;

	public Fulfillment getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

	public Price getPrice() {
		return price;
	}

	public void setItemPrice(Price price) {
		this.price = price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
}