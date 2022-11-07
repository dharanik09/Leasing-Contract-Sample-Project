package com.allane.mobility.group.amg.servies;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allane.mobility.group.amg.entity.Customer;
import com.allane.mobility.group.amg.entity.Vehicle;
import com.allane.mobility.group.amg.exception.ResourceNotFoundException;
import com.allane.mobility.group.amg.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService  {
	
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		try {
			return vehiclerepository.save(vehicle);
		}catch (Exception e) {
			throw new ResourceNotFoundException("Unexpected error");
		}
	}

	@Override
	public List<Vehicle> getVehicleDetails() {
		// TODO Auto-generated method stub
		try {
			return vehiclerepository.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}

	@Override
	public Optional<Vehicle> getVehicleDetailsById(@NotNull int id) {
		// TODO Auto-generated method stub
		try {
			return vehiclerepository.findById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}

	@Override
	public Vehicle updateVehicleDetailsById(@Valid @NotNull int id, Vehicle vehicle) {
		// TODO Auto-generated method stub
		try {
			return vehiclerepository.save(vehicle);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}

	@Override
	public boolean deleteVehicleDetailsById(@NotNull int id) {
		// TODO Auto-generated method stub
		try {
			vehiclerepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}

	
	
	
}
