package com.allane.mobility.group.amg.servies;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.allane.mobility.group.amg.entity.Customer;

public interface CustomerService {

	Customer saveCustomerDetails(Customer c);

	List<Customer> getCustomerDetails();

	Optional<Customer> getCustomerDetailsById(@Valid int id);

	Customer updateCustomerDetailsById(@Valid @NotNull int id, Customer customer);

	boolean deleteCustomerDetailsById(@NotNull int id);
	
}
