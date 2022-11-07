package com.allane.mobility.group.amg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
    @Column(name = "brand")
    @NotEmpty(message = "Brand is required")
	private String brand;
    
    @Column(name = "model")
    @NotEmpty(message = "Model is required")
	private String model;
    
    @Column(name = "model_year")
    @NotNull(message = "Model year is required")
	private int model_year;
    
    @Column(name = "vehicle_identification_number")
	private String VIN;
    
    @Column(name = "price")
    @NotNull(message = "Price is required")
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getModel_year() {
		return model_year;
	}

	public void setModel_year(int model_year) {
		this.model_year = model_year;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
		
	


}
