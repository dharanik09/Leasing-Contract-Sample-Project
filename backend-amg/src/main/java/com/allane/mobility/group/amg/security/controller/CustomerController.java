package com.allane.mobility.group.amg.security.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allane.mobility.group.amg.entity.Customer;
import com.allane.mobility.group.amg.exception.ResourceNotFoundException;
import com.allane.mobility.group.amg.servies.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CustomerController {

	
	@Autowired
	private CustomerService customerservice;


//	@GetMapping	
//	public String index() {
//	 return "welome to Customer 8083";
//	}
	
	@GetMapping("/test")
	public String index() {
	 return "Test Customer";
	}
 
	@PostMapping("/customer")
 	public ResponseEntity<Object>  CreateCustomerDetails(@Valid @RequestBody Customer customer) {
		Customer result = customerservice.saveCustomerDetails(customer);
		if(result == null) throw new ResourceNotFoundException("Not Saved");
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}
	
	@GetMapping("/getCustomerDetails")
 	public ResponseEntity<Object>  getCustomerDetails() {
		List<Customer> result = customerservice.getCustomerDetails();
		if(result == null) throw new ResourceNotFoundException("Not Saved");
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/getCustomerDetailsById/{id}")
 	public ResponseEntity<Object>  getCustomerDetailsById(@PathVariable @NotNull int id) {
		if(id > 0) {
			Optional<Customer> result = customerservice.getCustomerDetailsById(id);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}
	
	@RequestMapping(value = "/updateCustomerDetailsById/{id}", method = RequestMethod.PUT)
 	public ResponseEntity<Object>  updateCustomerDetailsById(@Valid @PathVariable @NotNull int id, @RequestBody Customer customer) {
		if(id > 0) {
			Customer result = customerservice.updateCustomerDetailsById(id, customer);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}
	
	@RequestMapping(value = "/deleteCustomerDetailsById/{id}", method = RequestMethod.DELETE)
 	public ResponseEntity<Object>  deleteCustomerDetailsById(@PathVariable @NotNull int id) {
		if(id > 0) {
			boolean result = customerservice.deleteCustomerDetailsById(id);
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}

}
