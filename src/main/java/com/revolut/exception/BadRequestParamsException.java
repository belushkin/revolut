package com.revolut.exception;

public class BadRequestParamsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5816875620615823349L;

	public BadRequestParamsException() {

	}

	/**
	 * @param message
	 */
	public BadRequestParamsException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param throwable
	 */
	public BadRequestParamsException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
