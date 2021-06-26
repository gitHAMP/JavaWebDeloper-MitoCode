package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class OutcomeNotFoundException extends RuntimeException{

	public OutcomeNotFoundException(String message) {
		super(message);
	}
}
