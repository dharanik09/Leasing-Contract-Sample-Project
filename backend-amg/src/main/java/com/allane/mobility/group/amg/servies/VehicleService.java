package com.allane.mobility.group.amg.servies;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.allane.mobility.group.amg.entity.Vehicle;

public interface VehicleService {
	
	public Vehicle createVehicle(Vehicle vehicle);

	public List<Vehicle> getVehicleDetails();

	public Optional<Vehicle> getVehicleDetailsById(@NotNull int id);

	public Vehicle updateVehicleDetailsById(@Valid @NotNull int id, Vehicle vehicle);

	public boolean deleteVehicleDetailsById(@NotNull int id);

	
}
