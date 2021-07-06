package com.gil.imagesloader.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsCatcher {
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> notFoundHandler(Exception e) {
		return errorResponseSender(new ErrorDetails(e.getMessage(), HttpStatus.NOT_FOUND));
	}

	private ResponseEntity<?> errorResponseSender(ErrorDetails errorDetails) {
		return new ResponseEntity<>(errorDetails, errorDetails.getError());
	}
	
	
}
