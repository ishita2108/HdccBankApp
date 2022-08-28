package com.infinity.utils;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infinity.dto.ErrorDetails;
import com.infinity.exceptions.CustomerNotFoundException;

@RestControllerAdvice
public class InfinityExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
		ErrorDetails details=new ErrorDetails();
		details.setDate(LocalDateTime.now());
		details.setName("team.it@infinity.com");
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
		details.setName("team.it@infinity.com");
		
		
		details.setMessage("some internal server error pls try after some time");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(Exception ex){
		ErrorDetails details=new ErrorDetails();
		details.setDate(LocalDateTime.now());
		details.setName("team.it@infinity.com");
		
		
		details.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}

}
