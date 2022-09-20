package com.apnahomeloan.app.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cibil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cibilId;
	private Integer cibil_Score;
	private String cibil_Score_Date_Time;
	private String cibil_Status;
	private String cibil_Remark;
	
	
}
//"cibilId":