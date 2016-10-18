package com.homedepot.pip.enums;

public enum StoreStatusType {

	ACTIVE(100, "ACTIVE"),
	IN_SEASON(200, "IN SEASON"),
	OUT_OF_SEASON(300, "OUT OF SEASON"),
	INACTIVE(400, "INACTIVE"),
	CLEARANCE(500, "CLEARANCE"),
	DELETED(600, "DELETED"),
	NA(0, "NA");

	private int code;
	private String label;

	private StoreStatusType(int code, String label) {
		this.code = code;
		this.label = label;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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