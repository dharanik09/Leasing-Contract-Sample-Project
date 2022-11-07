package com.allane.mobility.group.amg.servies;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allane.mobility.group.amg.entity.LeasingContract;
import com.allane.mobility.group.amg.exception.ResourceNotFoundException;
import com.allane.mobility.group.amg.repository.LeasingContractRepository;

@Service
public class LeasingContractServiceImpl implements LeasingContractService {

	@Autowired
	private LeasingContractRepository leasingContractRepository; 
	
	@Override
	public LeasingContract createLeasingContract(LeasingContract leasingContract) {
		// TODO Auto-generated method stub
		try {
			return leasingContractRepository.save(leasingContract);
		}catch (Exception e) {
			throw new ResourceNotFoundException("Unexpected error");
		}
	}

	@Override
	public List<LeasingContract> getLeasingContratDetailsList() {
		// TODO Auto-generated method stub
		try {
			return leasingContractRepository.findAll();
		}catch (Exception e) {
			throw new ResourceNotFoundException("Resources Not Found");
		}
	}

	@Override
	public Optional<LeasingContract> getLeasingDetailsById(@NotNull int id) {
		// TODO Auto-generated method stub
		try {
			return leasingContractRepository.findById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}
	
	@Override
	public LeasingContract updateLeasingDetailsById(@Valid @NotNull int id, LeasingContract leasingContract) {
		// TODO Auto-generated method stub
		try {
			return leasingContractRepository.save(leasingContract);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}
	@Override
	public boolean deleteLeasingDetailsById(@NotNull int id) {
		// TODO Auto-generated method stub
		try {
			leasingContractRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resources not Found");
		}
	}


}
