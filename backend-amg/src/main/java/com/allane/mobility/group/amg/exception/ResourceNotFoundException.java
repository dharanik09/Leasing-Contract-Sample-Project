package com.allane.mobility.group.amg.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

	  private static final long serialVersionUID = 1L;

	  public ResourceNotFoundException(String msg) {
	    super(msg);
	  }

}