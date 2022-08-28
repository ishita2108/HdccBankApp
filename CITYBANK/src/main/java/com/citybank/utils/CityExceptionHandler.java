package com.citybank.utils;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.citybank.dto.ErrorDetails;
import com.citybank.exceptions.CustomerNotFoundException;

@RestControllerAdvice
public class CityExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
		ErrorDetails details=new ErrorDetails();
		details.setDate(LocalDateTime.now());
		details.setName("team.it@city.com");
		String errorMessage= ex.getBindingResult().getAllErrors().stream()
				.map(x-> x.getDefaultMessage())
				.collect(Collectors.joining(","));
		
		details.setMessage(errorMessage);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handle500(Exception ex){
		ErrorDetails details=new ErrorDetails();
		details.setDate(LocalDateTime.now());
		details.setName("team.it@city.com");
		
		
		details.setMessage("KYC Not Found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(Exception ex){
		ErrorDetails details=new ErrorDetails();
		details.setDate(LocalDateTime.now());
		details.setName("team.it@city.com");
		
		
		details.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}

}
