package com.inditex.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PriceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PriceNotFoundException(String message) {
		super(message);
	}

	public PriceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
