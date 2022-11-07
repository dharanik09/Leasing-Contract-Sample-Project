package com.allane.mobility.group.amg.security.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
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

import com.allane.mobility.group.amg.entity.Customer;
import com.allane.mobility.group.amg.entity.Vehicle;
import com.allane.mobility.group.amg.exception.ResourceNotFoundException;
import com.allane.mobility.group.amg.servies.VehicleService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleservice;
	
	@PostMapping("/vehicle")
	public ResponseEntity<Object> createVehicle(@Valid @RequestBody Vehicle vehicle) {
		Vehicle result = vehicleservice.createVehicle(vehicle);
		if(result == null) throw new ResourceNotFoundException("Vehicle Details are not Saved");
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}
	@GetMapping("/getVehicleDetails")
 	public ResponseEntity<Object>  getVehicleDetails() {
		List<Vehicle> result = vehicleservice.getVehicleDetails();
		if(result == null) throw new ResourceNotFoundException("Not Saved");
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/getVehicleDetailsById/{id}")
 	public ResponseEntity<Object>  getVehicleDetailsById(@PathVariable @NotNull int id) {
		if(id > 0) {
			Optional<Vehicle> result = vehicleservice.getVehicleDetailsById(id);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}
	
	@RequestMapping(value = "/updateVehicleDetailsById/{id}", method = RequestMethod.PUT)
 	public ResponseEntity<Object>  updateCustomerDetailsById(@Valid @PathVariable @NotNull int id, @RequestBody Vehicle vehicle) {
		if(id > 0) {
			Vehicle result = vehicleservice.updateVehicleDetailsById(id, vehicle);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}
	
	@RequestMapping(value = "/deleteVehicleDetailsById/{id}", method = RequestMethod.DELETE)
 	public ResponseEntity<Object>  deleteVehicleDetailsById(@PathVariable @NotNull int id) {
		if(id > 0) {
			boolean result = vehicleservice.deleteVehicleDetailsById(id);
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}else {
			throw new ResourceNotFoundException("Customer not found");
		}
	}

}
