/**
 * 
 */
package com.homedepot.pip.backend.store.fulfillment;

/**
 * @author KXP8101
 *
 */
public class BuyOnlinePickupInStore {

	private Inventory inventory;
	private String alphaPromptRestriction;
	private String alphaPromptMessage;

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getAlphaPromptRestriction() {
		return alphaPromptRestriction;
	}

	public void setAlphaPromptRestriction(String alphaPromptRestriction) {
		this.alphaPromptRestriction = alphaPromptRestriction;
	}

	public String getAlphaPromptMessage() {
		return alphaPromptMessage;
	}

	public void setAlphaPromptMessage(String alphaPromptMessage) {
		this.alphaPromptMessage = alphaPromptMessage;
	}
}