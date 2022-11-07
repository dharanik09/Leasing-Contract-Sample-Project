package com.allane.mobility.group.amg.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler  extends ResponseEntityExceptionHandler  {
	 
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.NOT_FOUND.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    	return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
    
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	 @Override
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(
	            MethodArgumentNotValidException ex,
	            HttpHeaders headers, HttpStatus status, WebRequest request) {
	             
	    Map<String, Object> responseBody = new LinkedHashMap<>();
		ErrorMessage message = new ErrorMessage(
				status.value(),
				new Date(),
				"Bad Request",
				request.getDescription(false));
    
     
	    List<String> errors = ex.getBindingResult().getFieldErrors()
	       .stream()
	       .map(x -> x.getDefaultMessage())
	       .collect(Collectors.toList());
	         
	    message.setErrors(errors);
	         
	      return new ResponseEntity<>(message, headers, status);
	    }


//	 @Override
//	 protected ResponseEntity<Object> handleMethodArgumentNotValid(
//	            MethodArgumentNotValidException ex,
//	            HttpHeaders headers, HttpStatus status, WebRequest request) {
//	             
//	    Map<String, Object> responseBody = new LinkedHashMap<>();
//	    responseBody.put("timestamp", new Date());
//	    responseBody.put("status", status.value());
//	         
//	    List<String> errors = ex.getBindingResult().getFieldErrors()
//	       .stream()
//	       .map(x -> x.getDefaultMessage())
//	       .collect(Collectors.toList());
//	         
//	      responseBody.put("errors", errors);
//	         
//	      return new ResponseEntity<>(responseBody, headers, status);
//	    }
}