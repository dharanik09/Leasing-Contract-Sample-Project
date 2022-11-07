package com.allane.mobility.group.amg.security.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allane.mobility.group.amg.entity.LeasingContract;
import com.allane.mobility.group.amg.entity.Vehicle;
import com.allane.mobility.group.amg.exception.ResourceNotFoundException;
import com.allane.mobility.group.amg.servies.LeasingContractService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LeasingContractController {
	
	@Autowired
	private LeasingContractService leasingContractService;
	
	@PostMapping("/leasingcontract")
	public ResponseEntity<Object> createLeasingContract(@Valid @RequestBody LeasingContract leasingContract) throws Exception {
		if(leasingContract.getCustomer().getId() == 0)throw new ResourceNotFoundException("Customer Details not found");
		if(leasingContract.getVehicle().getId() == 0)throw new ResourceNotFoundException("Vehicle Details not found");
		LeasingContract result = leasingContractService.createLeasingContract(leasingContract);
		if(result == null) throw new ResourceNotFoundException("Not Saved");
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}
	
	@GetMapping("/getLeasingContratDetails")
	private ResponseEntity<Object> getLeasingContratDetails() throws Exception{
		List<LeasingContract> result = leasingContractService.getLeasingContratDetailsList();
		if(result == null) throw new ResourceNotFoundException("Not Found");
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/getLeasingDetailsById/{id}")
 	public ResponseEntity<Object>  getLeasingDetailsById(@PathVariable @NotNull int id) {
		if(id > 0) {
			Optional<LeasingContract> result = leasingContractService.getLeasingDetailsById(id);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}
	
	
	@RequestMapping(value = "/updateLeasingDetailsById/{id}", method = RequestMethod.PUT)
 	public ResponseEntity<Object>  updateLeasingDetailsById(@Valid @PathVariable @NotNull int id, @RequestBody LeasingContract leasingContract) {
		if(id > 0) {
			LeasingContract result = leasingContractService.updateLeasingDetailsById(id, leasingContract);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}
	
	@RequestMapping(value = "/deleteLeasingDetailsById/{id}", method = RequestMethod.DELETE)
 	public ResponseEntity<Object>  deleteLeasingDetailsById(@PathVariable @NotNull int id) {
		if(id > 0) {
			boolean result = leasingContractService.deleteLeasingDetailsById(id);
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}


}
