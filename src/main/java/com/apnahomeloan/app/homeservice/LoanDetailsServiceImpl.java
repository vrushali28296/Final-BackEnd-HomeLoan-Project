package com.apnahomeloan.app.homeservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apnahomeloan.app.model.Customer;
import com.apnahomeloan.app.model.EmiDetails;
import com.apnahomeloan.app.model.LoanDetails;
import com.apnahomeloan.app.repository.CustomerRepositary;
import com.apnahomeloan.app.repository.EmiDetailsRepository;
import com.apnahomeloan.app.repository.LoanServiceRepositary;
import com.apnahomeloan.app.serviceinterface.LoanDetailsServiceI;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsServiceI
{
@Autowired LoanServiceRepositary lsr;
	
	@Autowired EmiDetailsRepository edr;
	
	@Autowired CustomerRepositary cr;
	@Override
	
	public LoanDetails saveLoanDetails(@Valid LoanDetails loan,int customerid) {
		
		
		double principal, rate, time, emi;
		
		//LoanDetails l1 = LoanDetails.get();
		principal=loan.getLoanPrincipalAmt();
		
		rate = loan.getRateOfInterest();

		time = loan.getLoanTenure();
		
		rate = rate / (12 * 100);

		time = time * 12;

		emi = (principal * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);

		System.out.println("Monthly EMI is= " + emi + "\n");

		Customer c=cr.findByCustomerid(customerid);
			
		LoanDetails l=new LoanDetails();
		EmiDetails e=new EmiDetails();
		e.setEmiAmtMonnthly(emi);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
		e.setEmiDueDate(formatter.format(date));
		e.setPreviousEmiStatus("ok");
		
		l.setLoanPrincipalAmt(loan.getLoanPrincipalAmt());
		l.setLoanTenure(loan.getLoanTenure());
		l.setRateOfInterest(loan.getRateOfInterest());
		l.setStatus("Approveddd");
		
		l.setEmiDetails(e);
		
		c.setLoanDetails(l);
		edr.save(e);
		
		cr.save(c);
		
		return lsr.save(l);
	}

	@Override
	public List<LoanDetails> getLoanDetails() {
		
		return lsr.findAll();
	}

	@Override
	public LoanDetails updateLoanDetails(LoanDetails loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLoanDetails(int loanId) {
		lsr.deleteById(loanId);
	}

	@Override
	public LoanDetails getSingleLoan(int loanId) 
	{
		
		return lsr.findByLoanId(loanId);
	}

	@Override
	public Double calculateEmi(LoanDetails loandetails) 
	{
		//Optional<LoanDetails> loan=lsr.findById(null);
		
		double principal, rate, time, emi;
		
		//LoanDetails l1 = LoanDetails.get();
		principal=loandetails.getLoanPrincipalAmt();
		
		rate = loandetails.getRateOfInterest();

		time = loandetails.getLoanTenure();
		
		rate = rate / (12 * 100);

		time = time * 12;

		emi = (principal * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);

		System.out.println("Monthly EMI is= " + emi + "\n");
		
		return emi;
	}

	@Override
	public LoanDetails saveLoanDetails11(@Valid LoanDetails loan, int customerId) 
	{

		Customer c=cr.findByCustomerid(customerId);
			
		LoanDetails l=new LoanDetails();
		EmiDetails e=new EmiDetails();
		e.setEmiAmtMonnthly(loan.getEmiDetails().getEmiAmtMonnthly());
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
		e.setEmiDueDate(formatter.format(date));
		e.setPreviousEmiStatus("ok");
		
		l.setLoanPrincipalAmt(loan.getLoanPrincipalAmt());
		l.setLoanTenure(loan.getLoanTenure());
		l.setRateOfInterest(loan.getRateOfInterest());
		l.setStatus("Approveddd");
		
		l.setEmiDetails(e);
		
		c.setLoanDetails(l);
		edr.save(e);
		
		cr.save(c);
		
		return lsr.save(l);
	}
	
	
	

	

}