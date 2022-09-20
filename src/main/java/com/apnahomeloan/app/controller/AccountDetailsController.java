package com.apnahomeloan.app.controller;

import java.util.List;

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

import com.apnahomeloan.app.model.AccountDetails;
import com.apnahomeloan.app.model.Customer;
import com.apnahomeloan.app.repository.CustomerRepositary;
import com.apnahomeloan.app.serviceinterface.AccountDetailsI;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountDetailsController {

	@Autowired
	AccountDetailsI adi;
	
	@Autowired
	private CustomerRepositary cr;

	@PostMapping(value = "/saveAccount/{customerid}")
	public ResponseEntity<AccountDetails> saveAccount(@RequestBody AccountDetails account, @PathVariable int customerid) {

		Customer c=cr.findByCustomerid(customerid);
		
		//AccountDetails ad = adi.saveAccount(account);
		
		c.getAccountDetails().setAccounntNo(account.getAccounntNo());
		c.getAccountDetails().setAccount_holdername(account.getAccount_holdername());
		c.getAccountDetails().setAccount_type(account.getAccount_type());
		c.getAccountDetails().setIfsc_code(account.getIfsc_code());
		
		cr.save(c);
		return new ResponseEntity<AccountDetails>( HttpStatus.OK);
	}

	@GetMapping(value = "/getAccount")
	public ResponseEntity<List<AccountDetails>> getAccount() {
		List<AccountDetails> aclist = adi.getAccount();
		return new ResponseEntity<List<AccountDetails>>(aclist, HttpStatus.OK);
	}

	@PutMapping(value = "/updateAccount/{acid}")
	public ResponseEntity<AccountDetails> updateAccount(@RequestBody AccountDetails account,
			@PathVariable Integer acid) {
		AccountDetails ade = adi.updateAccount(account, acid);
		return new ResponseEntity<AccountDetails>(ade, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteAccount/{acid}")
	public ResponseEntity deleteAccount(@PathVariable Integer acid) {
		adi.deleteAccount(acid);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}


//{
//	  "account_type":"saving",
//	  "account_holdername":"vaishalip",
//	  "ifsc_code":"sbi123"
//	}
