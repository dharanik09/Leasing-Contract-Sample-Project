package com.allane.mobility.group.amg.exception;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {
	
	private int statusCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;
	private String message;
	private String description;

	private List<String> errors;
	
	public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
	  this.statusCode = statusCode;
	  this.timestamp = timestamp;
	  this.message = message;
	  this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	

}
