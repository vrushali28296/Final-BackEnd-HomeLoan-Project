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
import com.apnahomeloan.app.model.PropertyDetails;
import com.apnahomeloan.app.repository.CustomerRepositary;
import com.apnahomeloan.app.serviceinterface.PropertyDetailsServiceI;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyDetailsController {
	@Autowired
	PropertyDetailsServiceI propertydetailsserviei;
	
	@Autowired
	private CustomerRepositary cr;
	
	@PostMapping("/savepropertydetails/{customerid}")
	public ResponseEntity<PropertyDetails> savePropertydetails(@RequestBody PropertyDetails propertydetails,@PathVariable int customerid){
		
		Customer c=cr.findByCustomerid(customerid);
		
	//PropertyDetails propertydet=	propertydetailsserviei.savePropertyDetails(propertydetails);
	
	//c.setPropertyDetails(propertydet);
		c.getPropertyDetails().setPropertyaddress(propertydetails.getPropertyaddress());
		c.getPropertyDetails().setPropertyarea(propertydetails.getPropertyarea());
		c.getPropertyDetails().setPropertyprice(propertydetails.getPropertyprice());
		c.getPropertyDetails().setPropertytype(propertydetails.getPropertytype());
	cr.save(c);
	return new ResponseEntity<PropertyDetails>(HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/getpropertydetails")
	public ResponseEntity<List< PropertyDetails>> getPropertyDetails(){
		
	List<PropertyDetails> propertydetailslist=	propertydetailsserviei.getpropertydetails();
	return new ResponseEntity<List<PropertyDetails>>(propertydetailslist, HttpStatus.OK);
		
		
	}
	
//	@PutMapping(value = "updatepropertydetails/{property_ID}")
//	public ResponseEntity<PropertyDetails> updatepropertydetails(@RequestBody PropertyDetails propertydetails, @PathVariable Integer property_ID){
//		
//	PropertyDetails propertyd=	propertydetailsserviei.updatepropertydetails(propertydetails, property_ID);
//	
//	return new ResponseEntity<PropertyDetails>(propertyd, HttpStatus.CREATED);
//		
//		
//	}
	
	@DeleteMapping(value = "/deletepropertydetails/{property_ID}")
	public ResponseEntity<PropertyDetails> deletepropertydetails(@PathVariable Integer property_ID ){
		
		propertydetailsserviei.deletepropertydetails(property_ID);
		
		return new ResponseEntity<PropertyDetails>(HttpStatus.NO_CONTENT);
		
		
	}

}
