package com.apnahomeloan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apnahomeloan.app.model.Applicant;
import com.apnahomeloan.app.model.Cibil;
import com.apnahomeloan.app.serviceinterface.ApplicantServiceI;
import com.apnahomeloan.app.serviceinterface.CibilServiceInterface;

@RestController
@CrossOrigin("*")
public class CibilController {

	@Autowired
	private CibilServiceInterface csi;
		
	@Autowired
	private ApplicantServiceI asi;

	@PostMapping("/saveCibil/{cibil_Score}/{applicantid}")
	public String saveCibil(@PathVariable int cibil_Score, @PathVariable int applicantid) {
		System.out.println("in cibil controller");

		System.out.println(cibil_Score+"--------------------------------------------------------"+applicantid);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Cibil cibil = csi.saveCibil(cibil_Score, applicantid);

		return "kk";
	}

	@GetMapping("/getCibil")
	public Integer getcibil() {

		Integer cibil = csi.getcibil();

		return cibil;
	}

}
