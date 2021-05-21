package com.shayan.book.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UFileNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

    public UFileNotFoundException(String message) {
        super(message);
    }

    public UFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
