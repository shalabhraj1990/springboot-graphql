package com.pluralsight.exception;

public class ThrowableGraphQLError extends RuntimeException {
	public ThrowableGraphQLError(String message) {
		super(message);
	}
}
