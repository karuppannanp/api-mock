package com.homedepot.pip.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	private int status;
	private String message;
	
	public BadRequestException(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
