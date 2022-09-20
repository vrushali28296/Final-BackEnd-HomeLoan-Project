package com.apnahomeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apnahomeloan.app.model.LoanDetails;

@Repository
public interface LoanServiceRepositary extends JpaRepository<LoanDetails, Integer>
{

	  public LoanDetails  findByLoanId(int loanId);


}