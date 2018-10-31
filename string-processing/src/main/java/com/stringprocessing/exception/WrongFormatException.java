package com.stringprocessing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WrongFormatException extends RuntimeException {

	private static final long serialVersionUID = 5304851628910797521L;

	public WrongFormatException(String exception) {
		super(exception);
	}

}
