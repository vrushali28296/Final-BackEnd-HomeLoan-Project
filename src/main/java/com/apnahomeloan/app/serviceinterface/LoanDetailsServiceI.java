package com.apnahomeloan.app.serviceinterface;

import java.util.List;

import javax.validation.Valid;

import com.apnahomeloan.app.model.LoanDetails;

public interface LoanDetailsServiceI
{
	

	public LoanDetails saveLoanDetails(@Valid LoanDetails loan, int customerId);

	public List<LoanDetails> getLoanDetails();

	public LoanDetails updateLoanDetails(LoanDetails loan);

	public void deleteLoanDetails(int loanId);

	public LoanDetails getSingleLoan(int loanid);

	public Double calculateEmi(LoanDetails loan);

	public LoanDetails saveLoanDetails11(@Valid LoanDetails loan, int customerId);
}