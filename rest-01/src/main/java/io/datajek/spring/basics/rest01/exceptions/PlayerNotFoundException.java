package io.datajek.spring.basics.rest01.exceptions;

public class PlayerNotFoundException extends RuntimeException {
	// These were based the class we extended (bunch of slightly-different constructors)

	public PlayerNotFoundException() {
		super();
	}

	public PlayerNotFoundException(String message) {
		super(message);
	}

	public PlayerNotFoundException(Throwable cause) {
		super(cause);
	}

	public PlayerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlayerNotFoundException(String message, Throwable cause,
	                               boolean enableSuppression,
	                               boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}