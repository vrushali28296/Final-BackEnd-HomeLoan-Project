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
import com.apnahomeloan.app.model.ProfessionDetails;
import com.apnahomeloan.app.repository.CustomerRepositary;
import com.apnahomeloan.app.serviceinterface.ProfessionServiceI;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessionController {
	
	@Autowired
	ProfessionServiceI professionservice;
	
	@Autowired
	private CustomerRepositary cr;
	
	@PostMapping(value = "/saveProfessiondetails/{customerid}")
	public ResponseEntity<ProfessionDetails> saveProfession(@RequestBody ProfessionDetails professiondetails,@PathVariable int customerid){
		
	System.out.println(professiondetails.getAnnualsalary()+"............");
	System.out.println(professiondetails.getDesignation());
		Customer c=cr.findByCustomerid(customerid);
		
			//ProfessionDetails proffesion=professionservice.saveProfession(professiondetails);
			
		
			
//			professionservice.saveProfession(professiondetails);
			c.getProfession().setAnnualsalary(professiondetails.getAnnualsalary());
			c.getProfession().setDesignation(professiondetails.getDesignation());
			c.getProfession().setProffessionname(professiondetails.getProffessionname());
			c.getProfession().setProffessiontype(professiondetails.getProffessiontype());
			cr.save(c);
			return new ResponseEntity<ProfessionDetails>( HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/getProfessiondetails")
	public ResponseEntity<List<ProfessionDetails>> getProfesstionDetails(){
		
	List<ProfessionDetails> professiondetailsList=	professionservice.getProfessiondetails();
	
	return new ResponseEntity<List<ProfessionDetails>>(professiondetailsList, HttpStatus.OK);
		
		
	}
	
	@PutMapping(value = "/updateProfessionDetails/{proffessionid}")
	public ResponseEntity<ProfessionDetails> updateProfession(@RequestBody ProfessionDetails professiondetails,  @PathVariable Integer proffessionid){
		
		
		
		
		
	ProfessionDetails profession=	professionservice.updateProfessionDetails(professiondetails, proffessionid);
	
	return new ResponseEntity<ProfessionDetails>(profession, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(value = "/deleteProfessionDetails/{proffessionid}")
	public ResponseEntity<ProfessionDetails> deleteProfession(@PathVariable Integer proffessionid){
		professionservice.deleteprofession(proffessionid);
		
		return new ResponseEntity<ProfessionDetails>(HttpStatus.NO_CONTENT);
		
		
	}
	

}
