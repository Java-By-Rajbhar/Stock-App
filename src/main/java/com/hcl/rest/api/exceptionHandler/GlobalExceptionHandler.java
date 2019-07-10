package com.hcl.rest.api.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.hcl.rest.api.exception.ErrorResponse;
import com.hcl.rest.api.exception.NumberOfShareOrSharePriceMoreException;
import com.hcl.rest.api.exception.UserDoesNotExistException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserDoesNotExistException.class)
	public ResponseEntity<ErrorResponse> exceptionHaldler(UserDoesNotExistException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false),
				HttpStatus.UNAUTHORIZED.value());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(NumberOfShareOrSharePriceMoreException.class)
	public ResponseEntity<ErrorResponse> exceptionHaldler(NumberOfShareOrSharePriceMoreException ex,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false),
				HttpStatus.METHOD_NOT_ALLOWED.value());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHaldler(Exception ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false),
				HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
