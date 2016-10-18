/**
 * 
 */
package com.homedepot.pip.input;

/**
 * @author KXP8101
 *
 */
public class Fulfillment {
	private boolean sthStatus;

	private boolean bopisStatus;
	private boolean bopisCheckNearby;

	private boolean bossStatus;

	private boolean bodfsStatus;
	private String bodfsCharge;
	
	private String alphaPrompt;

	public boolean isSthStatus() {
		return sthStatus;
	}

	public void setSthStatus(boolean sthStatus) {
		this.sthStatus = sthStatus;
	}

	public boolean isBopisStatus() {
		return bopisStatus;
	}

	public void setBopisStatus(boolean bopisStatus) {
		this.bopisStatus = bopisStatus;
	}

	public boolean isBopisCheckNearby() {
		return bopisCheckNearby;
	}

	public void setBopisCheckNearby(boolean bopisCheckNearby) {
		this.bopisCheckNearby = bopisCheckNearby;
	}

	public boolean isBossStatus() {
		return bossStatus;
	}

	public void setBossStatus(boolean bossStatus) {
		this.bossStatus = bossStatus;
	}

	public boolean isBodfsStatus() {
		return bodfsStatus;
	}

	public void setBodfsStatus(boolean bodfsStatus) {
		this.bodfsStatus = bodfsStatus;
	}

	public String getBodfsCharge() {
		return bodfsCharge;
	}

	public void setBodfsCharge(String bodfsCharge) {
		this.bodfsCharge = bodfsCharge;
	}

	public String getAlphaPrompt() {
		return alphaPrompt;
	}

	public void setAlphaPrompt(String alphaPrompt) {
		this.alphaPrompt = alphaPrompt;
	}
}