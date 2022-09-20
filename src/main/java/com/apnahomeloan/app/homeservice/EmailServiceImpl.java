package com.apnahomeloan.app.homeservice;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.apnahomeloan.app.model.Applicant;
import com.apnahomeloan.app.model.Customer;
import com.apnahomeloan.app.model.EmailSending;
import com.apnahomeloan.app.serviceinterface.EmailServiceI;

@Service
public class EmailServiceImpl implements EmailServiceI
{

	@Autowired JavaMailSender jms;

	@Override
	public void sendMail(String toEmail)
	{
		try {
			SimpleMailMessage smm=new SimpleMailMessage();
			smm.setFrom("shirishpatil089@gmail.com");
			smm.setTo(toEmail);
			
			
			String body = "Dear Applicant " + " " + " " + ","
					+ "Your Loan Enquiry is approved, for further process please visit to our office with following Documents : "
					+ "1. Address Proof" +
					"2. Pancard" + 
					"3. Income Tax Return" + 
					"4. Addhar Card"
					+ "5. Photo" + 
					"6. Bank Cheque" + 
					"7. Salary Slips" +
					"8. Property Proof"
					+ "9. Property Insurance"
					+ " " +
					"Best Regards,"
					+ "Sales Executive," +
					"Apna Home Loan," + 
					"Pune.";
			
			String subject = "Enquiry Approved For Home Loan";
			smm.setSubject(subject);
			smm.setText(body);
			
			jms.send(smm);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("NOT sent");
		}
		System.out.println("Sent");	
	}

	@Override
	public void sendEmailWithAttachment(EmailSending em, MultipartFile file)
	{
		MimeMessage mm=jms.createMimeMessage();
		try {
			MimeMessageHelper mmh=new MimeMessageHelper(mm,true);
			mmh.setFrom(em.getFromEmail());
			mmh.setTo(em.getToEmail());
			mmh.setSubject(em.getSubject());
			mmh.setText(em.getTextBody());		
			mmh.addAttachment(file.getOriginalFilename(), file);
			
			jms.send(mm);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Not Sent");
		}
		System.out.println("Mail Sent");
	}

		
//	@Override
//	public Applicant sendFurtherDocuments(Applicant app) {
//
//		String body = "<b>Dear " + app.getApplicant_name() + " " + "</b>,"
//				+ "<br>Your Loan Enquiry is approved, for further process please visit to our office with following Documents : "
//				+ "<br><br>1. Address Proof" + "<br>2. Pancard" + "<br>3. Income Tax Return" + "<br>4. Addhar Card"
//				+ "<br>5. Photo" + "<br>6. Bank Cheque" + "<br>7. Salary Slips" + "<br>8. Property Proof"
//				+ "<br>9. Property Insurance" + "<br><br><br><img src='cid:image001'/>" + "<br><b>Best Regards,</b>"
//				+ "<br>Sales Executive," + "<br>Apna Home Loan," + "<br>Pune.";
//
//		String sendto = app.getApplicant_email();
//
//		String subject = "Enquiry Approved For Home Loan";
//
//		MimeMessage mm = jms.createMimeMessage();
//		try {
//			MimeMessageHelper mmh = new MimeMessageHelper(mm, true);
//			mmh.setFrom(sendto);
//			mmh.setTo(fromEmail);
//			mmh.setSubject(subject);
//			mmh.setText(body, true);
//
//			FileSystemResource resource = new FileSystemResource(
//					new File("C:\\FULL STACK DEVELOPER\\FINAL PROJECT\\BACKEND\\email.jpg"));
//			mmh.addInline("image001", resource);
//
//			jms.send(mm);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Not Sent");
//		}
//		System.out.println("Mail Sent");
//
//		// Applicant a=asi.sa
//		return app;
//	}
	
	

	@Override
	public String sendSanctionLetter(Customer customer, MultipartFile sanctionLetter) {
		String body = "<b>Dear " + customer.getCustomername() + "</b>,"
				+ "<br>We thank you for choosing APNA HOME LOAN as your financier for Loan. We are "
				+ "pleased to inform you that with reference to the application, we have in-principle sanctioned you a loan facility, the"
				+ "details of which are mensioned in ataached sanction Letter. "

				+ "<br><br>If you accept Saction letter then sign the saction letter and submit it to the office"

				+ "<br><br><br><img src='cid:image001'/>" + "<br><b>Best Regards,</b>"
				// +"<br>Loan Officer,"
				+ "<br>APNA HOME LOAN," + "<br>Pune.";

		String sendto = customer.getCustomeremail();
		System.out.println(customer.getCustomeremail());
		String subject = "Loan Approval";

		MimeMessage meMimeMsg = jms.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(meMimeMsg, true);
			helper.setTo(sendto);
		//	helper.setFrom(fromEmail);
			helper.setSubject(subject);

			helper.setText(body, true);

			FileSystemResource resource = new FileSystemResource(
					new File("C:/Users/SHIVA/Downloads/Home-Loan-for-women.jpg"));
			helper.addInline("image001", resource);

//			  FileSystemResource file=new FileSystemResource("C:/Users/SHIVA/Downloads/Home-Loan-for-women.jpg");
//			  helper.addAttachment(file.getFilename(), file);
			jms.send(meMimeMsg);

		} catch (MessagingException e2) {
			e2.printStackTrace();
		}

		return "Mail Send Successfully";
	}

	
	
	
	@Override
	public void sendSanctionMail(String toEmail) {
		try {
			SimpleMailMessage smm=new SimpleMailMessage();
			smm.setFrom("shirishpatil089@gmail.com");
			smm.setTo(toEmail);
			
			
			String body = "Dear Customer" + " "+ ","
					+ "We thank you for choosing APNA HOME LOAN as your financier for Loan. We are "
					+ "pleased to inform you that with reference to the application, we have in-principle sanctioned you a loan facility, the"
					+ "details of which are mensioned in ataached sanction Letter. "

					+ "If you accept Saction letter then sign the saction letter and submit it to the office"

					+ "" + "Best Regards,"
					// +"<br>Loan Officer,"
					+ "APNA HOME LOAN," + "Pune.";

			
			String subject = " Home Loan Sanction Mail";
			smm.setSubject(subject);
			smm.setText(body);
			
			jms.send(smm);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("NOT sent");
		}
		System.out.println("Sent");	
	}

	@Override
	public void sendRejectedEmail(String toEmail) {
		try {
			SimpleMailMessage smm=new SimpleMailMessage();
			smm.setFrom("shirishpatil089@gmail.com");
			smm.setTo(toEmail);
			
			
			String body = "Dear Customer" + " "+ ","
					+ "It gives us a pain to apprise you that your request for the loan of 5 Million dollars has been rejected by the board of directors of our bank. The main reason for this rejection was found to be the short amount of salary you are earning, being a job holder in a government service. As you have no source of income other than this job, and the bank has strong reservations over your way of returning this huge amount of loan."
					
					+ "" + "Best Regards,"
					// +"<br>Loan Officer,"
					+ "APNA HOME LOAN," + "Pune.";

			
			String subject = " Home Loan Rejected Email";
			smm.setSubject(subject);
			smm.setText(body);
			
			jms.send(smm);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("NOT sent");
		}
		System.out.println("Sent");		}

}
