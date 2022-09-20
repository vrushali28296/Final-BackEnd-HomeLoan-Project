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

import com.apnahomeloan.app.model.Applicant;
import com.apnahomeloan.app.model.Cibil;
import com.apnahomeloan.app.repository.CibilRepository;
import com.apnahomeloan.app.serviceinterface.ApplicantServiceI;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ApplicantController {

	@Autowired
	ApplicantServiceI aps1;
	
	@Autowired
	private CibilRepository cbr;

	@PostMapping("/saveApplicant")
	public ResponseEntity<Applicant> saveApplicant(@Valid @RequestBody Applicant a) {
		aps1.saveApplicant(a);
		return new ResponseEntity<Applicant>(a, HttpStatus.OK);
	}
	
	@GetMapping("/getApprovedList")
	public List<Applicant> getApprovelist()
	{
		System.out.println("a");
	List<Applicant>list=aps1.getApprovelist();	
		
	return list;
		
	}
		

	@GetMapping("/getApplicants")
	public ResponseEntity<List<Applicant>> getApplicant() {

		List<Applicant> list = aps1.getAllData();

		return new ResponseEntity<List<Applicant>>(list, HttpStatus.OK);
	}

	@PutMapping("/updateApplicant")
	public ResponseEntity<Applicant> updateApplicant(@RequestBody Applicant a) {

		aps1.saveApplicant(a);

		return new ResponseEntity<Applicant>(a, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteApplicant/{apid}")
	public ResponseEntity<Applicant> deleteApplicant(@PathVariable int apid) {

		aps1.deleteApplicant(apid);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/singleApplicant/{applicantid}")
	public ResponseEntity<Applicant> getApplicantById(@PathVariable int applicantid) {

		Applicant applicant = aps1.getApplicantBtId(applicantid);

		return new ResponseEntity<Applicant>(applicant, HttpStatus.OK);
	}
}
