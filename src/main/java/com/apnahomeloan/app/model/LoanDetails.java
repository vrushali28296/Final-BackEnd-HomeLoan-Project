package com.apnahomeloan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LoanDetails 
{
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 	private Integer loanId;
	 	private Double loanPrincipalAmt;
	 	private Double rateOfInterest;
		private Double loanTenure;
		private String status;
	
		@OneToOne(cascade = CascadeType.ALL)
	 	private EmiDetails emiDetails;
}
