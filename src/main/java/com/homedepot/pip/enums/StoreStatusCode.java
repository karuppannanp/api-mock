package com.homedepot.pip.enums;

public enum StoreStatusCode {

	CODE_100("ACTIVE"),
	CODE_200("IN_SEASON"),
	CODE_300("OUT_OF_SEASON"),
	CODE_400("INACTIVE"),
	CODE_500("CLEARANCE"),
	CODE_600("DELETED"),
	CODE_0("NA");

	private String label;

	private StoreStatusCode(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String toString() {
		return label;
	}
}