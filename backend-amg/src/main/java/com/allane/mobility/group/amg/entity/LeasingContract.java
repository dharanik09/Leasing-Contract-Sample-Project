package com.allane.mobility.group.amg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "leasing_contract")
public class LeasingContract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	
    @Column(name = "contract_number")
    @NotEmpty(message = "Contract number is required")
	private String contractNumber;
    
    @Column(name = "monthly_rate")
    @NotNull(message = "Monthly rate  is required")
	private double monthlyRate;
    
    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Customer customer;
    
    @OneToOne
    @JoinColumn(name="vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
//    
//    
    

}
