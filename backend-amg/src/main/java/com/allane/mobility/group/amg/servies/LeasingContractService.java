package com.allane.mobility.group.amg.servies;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.allane.mobility.group.amg.entity.LeasingContract;

public interface LeasingContractService {

	LeasingContract createLeasingContract(LeasingContract leasingContract);

	List<LeasingContract> getLeasingContratDetailsList();

	Optional<LeasingContract> getLeasingDetailsById(@NotNull int id);

	boolean deleteLeasingDetailsById(@NotNull int id);

	LeasingContract updateLeasingDetailsById(@Valid @NotNull int id, LeasingContract leasingContract);


}
