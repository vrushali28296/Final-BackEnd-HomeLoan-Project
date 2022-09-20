package com.apnahomeloan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class AccountDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	
	private String accounntNo;
	
	private String account_type;
	
	private String account_holdername;
	
	private String ifsc_code; 
}

//
//{
//	  "account_type":"savingAccount111",
//	  "account_holdername":"vaishalip",
//	  "ifsc_code":"sbi123"
//	}
