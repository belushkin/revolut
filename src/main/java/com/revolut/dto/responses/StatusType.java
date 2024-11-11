package com.revolut.dto.responses;

public enum StatusType {
    SUCCESS("Success"), ERROR("Error"), INFORMATIONAL("Information"), REDIRECT("Redirect");

	private String message;

	/**
	 * @param message
	 */
	private StatusType(String message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}
}
