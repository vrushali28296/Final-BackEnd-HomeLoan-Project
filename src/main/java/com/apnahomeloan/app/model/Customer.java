package com.apnahomeloan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerid;
	
	private Integer customer_age;
	
	private String customer_name;
	
	private String customer_gender;
	
	private String customer_email;
	
	private String customer_dob;
	
	private String customer_address;
	
	
	private String customer_mobno;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Applicant applicant;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails accountDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private Documents documents;
	@OneToOne(cascade = CascadeType.ALL)
	private ProfessionDetails profession;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDetails loanDetails;
}




/*
 { "customer_age":34,
 "customer_name":"vrushali",
 "customer_gender":"female",
  "customer_email":"vk@gmail.com", 
  "customer_dob":"28/2/96",
  "customer_address":"pune",
 "customer_mobno":"9876543210",
  "customer_proposedLoanAmt":"500000", 
 "customer_totalLoanAmt":"800000",
	"applicant":{
     "applicantid":2,
      "applicant_name":"vk",
      "applicant_occupation":"developer",
      "applicant_pancard":"pancard1234",
      "applicant_email":"vk99@gamil.com",
      "cibil":{"cibilId":1,
      "cibilScore":600,
               "cibilScoreDateTime":"282222",
               "cibilStatus":"invalid",
               "cibilRemark":"bad"}
    			},
 	"accountDetails":{ "account_id":3,
    "account_type":"saving",
 						"account_holdername":"vrushalik",
 						"ifsc_code" : "sbi1234"
				},
 	"propertyDetails":{"property_ID":5,
    "property_type":"xyz",
                       "property_area":"500.00",
                       "property_price":"555555",
                       "property_address":"pune"
      				
    			},
 	
 	"profession":{"proffession_id":4,
    "designation":"junior",
                  "proffession_name":"it",
                  "proffession_type":"itt",
                  "annual_salary":600000
    }
}

 * 
 */