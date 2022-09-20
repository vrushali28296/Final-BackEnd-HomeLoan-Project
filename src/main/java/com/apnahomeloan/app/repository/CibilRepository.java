package com.apnahomeloan.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.apnahomeloan.app.model.Cibil;

@Repository
public interface CibilRepository extends JpaRepository<Cibil, Integer> {

	public Cibil findByCibilId(Integer cibilId );
	
	//public List<Cibil> findByAllCibilStatus(String cibilStatus); 
}
