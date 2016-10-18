/**
 * 
 */
package com.homedepot.pip.backend.store.fulfillment;

/**
 * @author KXP8101
 *
 */
public class Inventory {
	private int onHandQuantity;
	private int expectedQuantityAvailable;

	public int getOnHandQuantity() {
		return onHandQuantity;
	}

	public void setOnHandQuantity(int onHandQuantity) {
		this.onHandQuantity = onHandQuantity;
	}

	public int getExpectedQuantityAvailable() {
		return expectedQuantityAvailable;
	}

	public void setExpectedQuantityAvailable(int expectedQuantityAvailable) {
		this.expectedQuantityAvailable = expectedQuantityAvailable;
	}
}
