package com.allane.mobility.group.amg.servies;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allane.mobility.group.amg.entity.Customer;
import com.allane.mobility.group.amg.exception.ResourceNotFoundException;
import com.allane.mobility.group.amg.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerrepository;
	
	@Override
	public Customer saveCustomerDetails(Customer c) {
		// TODO Auto-generated method stub
		try {
			return customerrepository.save(c);
		}catch (Exception e) {
			throw new ResourceNotFoundException("Unexpected error");
		}
	}

	@Override
	public List<Customer> getCustomerDetails() {
		// TODO Auto-generated method stub
		try {
			return customerrepository.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}

	@Override
	public Optional<Customer> getCustomerDetailsById(@Valid int id) {
		// TODO Auto-generated method stub
		try {
			return customerrepository.findById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}

	@Override
	public Customer updateCustomerDetailsById(@Valid @NotNull int id, Customer customer) {
		// TODO Auto-generated method stub
		try {
			return customerrepository.save(customer);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}

	@Override
	public boolean deleteCustomerDetailsById(@NotNull int id) {
		// TODO Auto-generated method stub
		try {
			customerrepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}
	
}
