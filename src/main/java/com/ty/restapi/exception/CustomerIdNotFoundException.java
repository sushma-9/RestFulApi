package com.ty.restapi.exception;

public class CustomerIdNotFoundException extends RuntimeException {

	public CustomerIdNotFoundException(String message) {
		super(message);
	}
}
