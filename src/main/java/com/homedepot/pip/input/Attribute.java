/**
 * 
 */
package com.homedepot.pip.input;

/**
 * @author KXP8101
 *
 */
public class Attribute {

	private String guid;
	private String value;
	private boolean bulleted;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isBulleted() {
		return bulleted;
	}

	public void setBulleted(boolean bulleted) {
		this.bulleted = bulleted;
	}
}