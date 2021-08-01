package com.home.amit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1333378322939172874L;

	public ContactNotFoundException(Long id) {
		super("could not find contact '" + id + "'.");
	}
}
