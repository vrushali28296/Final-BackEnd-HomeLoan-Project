package com.apnahomeloan.app.controller;

import java.util.ArrayList;
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
import com.apnahomeloan.app.model.Applicant;
import com.apnahomeloan.app.model.Customer;
import com.apnahomeloan.app.repository.ApplicantRepository;
import com.apnahomeloan.app.repository.CustomerRepositary;
import com.apnahomeloan.app.repository.DocumentRepository;
import com.apnahomeloan.app.serviceinterface.CustomerServiceI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@JsonIgnoreProperties
public class CustomerController 
{
	
		@Autowired 
		CustomerServiceI customerServiceI;
		
		@Autowired
		ApplicantRepository api;
		
		@Autowired
		private CustomerRepositary cr;
		
		@Autowired
		private DocumentRepository dr;
		
		@PostMapping("/saveCustomer/{applicantid}")
		//@JsonIgnoreProperties(ignoreUnknown = true)
		public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer, @PathVariable int applicantid){
						
			Applicant app=api.findByApplicantid(applicantid);
			
			customer.setCustomername(app.getApplicantname());
			customer.setCustomeremail(app.getApplicantemail());
			customer.setApplicant(app);

			Customer c=customerServiceI.saveCustomer(customer);
			
			
			//c.setApplicant(ap);
			 return	new ResponseEntity<Customer>(c,HttpStatus.CREATED);
		}

		@GetMapping(value = "/getCustomers") 
		public ResponseEntity<List<Customer>> getCustomers()
		{
			List<Customer> customer_list=customerServiceI.getCustomers();
			return new ResponseEntity<List<Customer>>(customer_list,HttpStatus.OK);
		}
		
		@GetMapping("/getCustomers/{customerid}")
		public ResponseEntity<List<Customer>> getSingleCustomer(@PathVariable int customerid){
			
								Customer c= cr.findByCustomerid(customerid);
								List<Customer> list= new ArrayList<>();
								list.add(c);
								return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
			
		}
		
		@PutMapping(value = "/updateCustomer/{customerid}")
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable Integer customerid)
		{
			Customer cust=customerServiceI.updateCustomer(customer,customerid);
			return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
		}
		
		@DeleteMapping(value = "/deleteCustomer/{customer_id}")
		public ResponseEntity deleteCustomer(@PathVariable Integer customer_id)
		{
			customerServiceI.deleteCustomer(customer_id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);			
		}
		
		@PostMapping("/updatestatus/{status}/{customerid}")
		public ResponseEntity<Customer> setStatus(@PathVariable String status,@PathVariable int customerid){
			
			Customer c=cr.findByCustomerid(customerid);
			
		c.getDocuments().setStatus(status);
						
		
			cr.save(c);
			return new ResponseEntity<Customer>(HttpStatus.OK);
			
		}
}


//
//
//{
//	  "customer_age": 45,
//	  "customer_name": "vk",
//	  "customer_gender": "female",
//	  "customer_emailid": "vk@gmail.com",
//	  "customer_dob": "28/2/96",
//	  "customer_address": "pune",
//	  "customer_mobno": "9762065593",
//	  "customer_proposedLoanAmt": "5000000",
//	  "customer_totalLoanAmt": "10000000"
//	}



//
//
//{ "customer_age":30,
//	 "customer_name":"vrushali",
//	 "customer_gender":"female",
//	  "customer_email":"vk@gmail.com", 
//	  "customer_dob":"28/2/96",
//	  "customer_address":"pune",
//	 "customer_mobno":"9876543210",
//	  "customer_proposedLoanAmt":"500000", 
//	 "customer_totalLoanAmt":"800000",
//		"applicant":{
//	     
//	      "applicant_name":"vk",
//	      "applicant_occupation":"developer",
//	      "applicant_pancard":"pancard1234",
//	      "applicant_email":"vk99@gamil.com",
//	      "cibil":{"cibilScore":600,
//	               "cibilScoreDateTime":"282222",
//	               "cibilStatus":"invalid",
//	               "cibilRemark":"bad"}
//	    			},
//	 	"accountDetails":{ "account_type":"saving",
//	 						"account_holdername":"vrushalik",
//	 						"ifsc_code" : "sbi1234"
//					},
//	 	"propertyDetails":{ "property_type":"xyz",
//	                       "property_area":"500sqqft",
//	                       "property_price":"555555",
//	                       "property_address":"pune"
//	      				
//	    			},
//	 	"profession":{"designation":"junior",
//	                  "proffession_name":"it",
//	                  "proffession_type":"itt",
//	                  "annual_salary":600000
//	    }
//	}
//	  

