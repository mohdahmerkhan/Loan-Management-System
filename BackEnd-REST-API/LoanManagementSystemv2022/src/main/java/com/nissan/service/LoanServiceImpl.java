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
import com.nissan.model.User;
import com.nissan.repo.ILoanRepository;
import com.nissan.repo.ILoanRequestRepository;
import com.nissan.repo.IUserRepository;

@Service
public class LoanServiceImpl implements ILoanService
{
	//Field Injection
	@Autowired
	ILoanRepository loanRepo;
	
	@Autowired
	ILoanRequestRepository loanRequestRepo;
	
	@Autowired
	IUserRepository userRepo;
	

	@Override
	public List<Loan> findAllLoans()
	{
		return loanRepo.findAll();
	}


	@Override
	public List<LoanRequest> finAllLoanRequests(int userID, int roleID)
	{
		//Check Role
		
		if(roleID == 1 && userID == 1)
		{
			User user = userRepo.findByUserID(userID);
			System.out.println("here"+user.getRole().getRoleID());
			
			if(user.getRole().getRoleID() == 1)
			{
				return loanRequestRepo.findAll();
			}
			return null;
			
		}
		else if(roleID == 2)
		{
			return loanRequestRepo.findLoanRequestsForOfficer(userID);
		}
		else if(roleID == 3)
		{
			return loanRequestRepo.findLoanRequestsForCustomer(userID);
		}
		
		return null;
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
	public LoanRequest updateLoanRequest(LoanRequestDTO loanRequestDTO, int loanRequestID, boolean isApproved, int roleID)
	{
		LoanRequest loanRequest = new LoanRequest(loanRequestDTO);
		
		//Setting Back Request Date
		loanRequest.setRequestDate(loanRequestRepo.frindRequestDateByUserID(loanRequestID));
		
		//Setting the loanRequestID
		loanRequest.setLoanRequestID(loanRequestID);
		
		if(roleID == 1)
		{
			if(isApproved)
			{
				loanRequest.setStatus("Approved");
			}
			else
			{
				loanRequest.setStatus("Rejected");
			}
		}
		
		if(roleID == 2)
		{
			if(isApproved)
			{
				loanRequest.setStatus("Accepted");
			}
			else
			{
				loanRequest.setStatus("Cancelled");
			}
		}
		
				
		return loanRequestRepo.save(loanRequest);
	}
	
}
