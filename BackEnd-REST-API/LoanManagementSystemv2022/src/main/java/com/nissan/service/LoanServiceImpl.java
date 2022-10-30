package com.nissan.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Loan;
import com.nissan.model.LoanRequest;
import com.nissan.model.LoanRequestDTO;
import com.nissan.repo.ILoanRepository;
import com.nissan.repo.ILoanRequestRepository;

@Service
public class LoanServiceImpl implements ILoanService
{
	//Field Injection
	@Autowired
	ILoanRepository loanRepo;
	
	@Autowired
	ILoanRequestRepository loanRequestRepo;
	

	@Override
	public List<Loan> findAllLoans()
	{
		return loanRepo.findAll();
	}


	@Override
	public List<LoanRequest> finAllLoanRequests()
	{
		return loanRequestRepo.findAll();
	}
	
	//Add LoanRequest
	@Transactional
	@Override
	public LoanRequest addLoanRequest(LoanRequestDTO loanRequestDTO)
	{
		//Mapping of LoanRequestDTO to LoanRequest
		LoanRequest loanRequest = new LoanRequest(loanRequestDTO);
		
		//Set loan Status
		loanRequest.setStatus("Pending");
		
		//Set Request Date
		loanRequest.setRequestDate(Date.valueOf(LocalDate.now()));
		
		return loanRequestRepo.save(loanRequest);
	}


	//Update User
	@Transactional
	@Override
	public LoanRequest updateLoanRequest(LoanRequest loanRequest)
	{
		return loanRequestRepo.save(loanRequest);
	}
	
}
