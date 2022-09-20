package com.apnahomeloan.app.controller;

 import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apnahomeloan.app.model.Customer;
import com.apnahomeloan.app.model.LoanDetails;
import com.apnahomeloan.app.repository.CustomerRepositary;
import com.apnahomeloan.app.serviceinterface.CustomerServiceI;
import com.apnahomeloan.app.serviceinterface.LoanDetailsServiceI;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoanDetailsController {

	@Autowired
	private LoanDetailsServiceI lsi;
	
	@Autowired
	private CustomerServiceI csi;

	@PostMapping("/saveloanDetails/{customerId}")
	public ResponseEntity<LoanDetails> save_loanDetails(@Valid @RequestBody LoanDetails loan,@PathVariable int customerId) {
		LoanDetails l = lsi.saveLoanDetails(loan,customerId);
		return new ResponseEntity<LoanDetails>(l, HttpStatus.CREATED);
	}

	@GetMapping("/getloanDetails")
	public ResponseEntity<List<LoanDetails>> getLoanDetails() {
		List<LoanDetails> list = lsi.getLoanDetails();
		return new ResponseEntity<List<LoanDetails>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/newsaveloanDetails/{customerId}")
	public ResponseEntity<LoanDetails> save_loanDetails11(@Valid @RequestBody LoanDetails loan,@PathVariable int customerId) {
		LoanDetails l = lsi.saveLoanDetails11(loan,customerId);
		return new ResponseEntity<LoanDetails>(l, HttpStatus.CREATED);
	}

	@PutMapping("/updateloanDetails")
	public ResponseEntity<LoanDetails> update_EmiDetails(@RequestBody LoanDetails loan) {
		LoanDetails loan1 = lsi.updateLoanDetails(loan);
		return new ResponseEntity<LoanDetails>(loan1, HttpStatus.OK);
	}

	@DeleteMapping("/deleteloanDetails/{loanId}")
	public ResponseEntity<LoanDetails> delete_EmiDetails(@PathVariable int loanId) {
		lsi.deleteLoanDetails(loanId);
		return new ResponseEntity<LoanDetails>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getSingleLoan/{loanid}")
	public LoanDetails getSingleLoan(@PathVariable int loanid)
	{
		
		return lsi.getSingleLoan(loanid);
		
	}
	
	@PostMapping("/getCalEmi")
	public Double calculateEmi(@RequestBody LoanDetails loan)
	{
		Double lo=lsi.calculateEmi(loan);
		return lo;
		
	}
	
}


