package com.apnahomeloan.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apnahomeloan.app.model.Customer;
import com.apnahomeloan.app.model.EmailSending;
import com.apnahomeloan.app.serviceinterface.EmailServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(value="http://localhost:4200") 
@RestController
public class EmailController {
	

	@Autowired EmailServiceI es;
	
	@Value("${spring.mail.username}")		// using value of property
	String fromEmail;
	
	@PostMapping("/sendMail/{toEmail}")
	public void sendMail(@PathVariable String toEmail) 
	{
		//setFromEmail(fromEmail,toEmail);
		
		try {
			es.sendMail(toEmail);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			//return "Mail NOT Sent...";
		}
		//return "Mail Sent Successfully...";
	}
	
	
	@PostMapping("/sendSanctionMail/{toEmail}")
	public void sendSanctionMail(@PathVariable String toEmail) 
	{
		//setFromEmail(fromEmail,toEmail);
		
		try {
			es.sendSanctionMail(toEmail);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Mail NOT Sent");
			//return "Mail NOT Sent...";
		}
		System.out.println("Mail Sent Successfully...");
		//return "Mail Sent Successfully...";
	}
	
	
	@PostMapping("/sendRejectedEmail/{toEmail}")
	public void sendRejectedEmail(@PathVariable String toEmail) 
	{
		//setFromEmail(fromEmail,toEmail);
		
		try {
			es.sendRejectedEmail(toEmail);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Mail NOT Sent");
			//return "Mail NOT Sent...";
		}
		System.out.println("Mail Sent Successfully...");
		//return "Mail Sent Successfully...";
	}
	
	
	
	
	
	
	
	@PostMapping (value = "/sendWithAttachment/{toEmail}/+", consumes = MediaType.ALL_VALUE)
	public String sendMailWithAttachment(@RequestPart(required = true, value = "attachment") MultipartFile file,
			@RequestPart("email")String email) throws IOException
	{
		
		try {
			
			EmailSending em=new EmailSending();
			em.setFromEmail(fromEmail);
			ObjectMapper o = new  ObjectMapper();
			EmailSending e2=o.readValue(email, EmailSending.class);
			em.setToEmail(e2.getToEmail());
			em.setSubject(e2.getSubject());
			em.setTextBody(e2.getTextBody());
			es.sendEmailWithAttachment(em,file);
			
			} 
				catch (Exception e) 
				{
					e.printStackTrace();
					return "Email not Sent...";
				}
		return "Mail Sent Successfully..";
	}
	
	
	
	@PostMapping(value = "/sendsanctionletter", consumes = MediaType.ALL_VALUE)
	public String sendSanctionLetter(@RequestPart("sanctionLetter") MultipartFile sanctionLetter,
			@RequestPart("customer") String customer) throws JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		Customer customer1 = objectMapper.readValue(customer, Customer.class);
		System.out.println("cust"+customer1);
		try {
			es.sendSanctionLetter(customer1, sanctionLetter);
		} catch (Exception e1) {
			return "Email can not sent";
		}
		return "Email sent Succesfully";
	}

}
