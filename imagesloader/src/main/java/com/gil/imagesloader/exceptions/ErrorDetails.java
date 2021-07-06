package com.gil.imagesloader.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorDetails {
	private String message;
	private HttpStatus error;
	private int status;
	
	
	public ErrorDetails(String message, HttpStatus error) {
		this.message = message;
		this.error = error;
		this.status =  error.value();
	}
}
