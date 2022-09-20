package com.apnahomeloan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Applicant {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applicantid;
  
	private String applicant_name;
 
	private String applicant_occupation;
  
	private String applicant_pancard;
  
	private String applicant_email;
	
  @OneToOne(cascade =CascadeType.ALL)
  private Cibil cibil;
}

//"applicantid": ,