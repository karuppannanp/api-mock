/**
 * 
 */
package com.homedepot.pip.backend.store.fulfillment;

/**
 * @author KXP8101
 *
 */
public class BuyOnlineShipToStore {

	private String estStartDeliveryDate;
	private String estEndDeliveryDate;

	public String getEstStartDeliveryDate() {
		return estStartDeliveryDate;
	}

	public void setEstStartDeliveryDate(String estStartDeliveryDate) {
		this.estStartDeliveryDate = estStartDeliveryDate;
	}

	public String getEstEndDeliveryDate() {
		return estEndDeliveryDate;
	}

	public void setEstEndDeliveryDate(String estEndDeliveryDate) {
		this.estEndDeliveryDate = estEndDeliveryDate;
	}
}