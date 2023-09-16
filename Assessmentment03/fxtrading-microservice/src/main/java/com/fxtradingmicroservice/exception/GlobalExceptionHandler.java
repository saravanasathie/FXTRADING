package com.fxtradingmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
		
	@ExceptionHandler(CurrencyNotValidException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> CurrencyNotValidException(CurrencyNotValidException exception){
		return ResponseEntity.ok(exception.getMessage());
	}
	
	@ExceptionHandler(ExchangeDataNotExistsException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> exchangeDataNotExistsException(ExchangeDataNotExistsException exception){
		return ResponseEntity.ok(exception.getMessage());
	}
}

