package com.allane.mobility.group.amg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allane.mobility.group.amg.entity.Customer;
import com.allane.mobility.group.amg.entity.LeasingContract;
import com.allane.mobility.group.amg.entity.Vehicle;

@Repository
public interface LeasingContractRepository extends JpaRepository<LeasingContract, Integer>{

}
