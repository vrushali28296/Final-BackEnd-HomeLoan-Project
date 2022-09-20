package com.apnahomeloan.app.serviceinterface;

import org.springframework.web.multipart.MultipartFile;

import com.apnahomeloan.app.model.Customer;
import com.apnahomeloan.app.model.EmailSending;

public interface EmailServiceI 
{

	public void sendMail(String toEmail);

	public void sendEmailWithAttachment(EmailSending em, MultipartFile file);

	public String sendSanctionLetter(Customer customer1, MultipartFile sanctionLetter);

}
