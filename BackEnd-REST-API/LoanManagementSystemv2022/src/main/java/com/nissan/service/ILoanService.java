package com.nissan.service;

import java.util.List;

import com.nissan.model.Loan;
import com.nissan.model.LoanRequest;
import com.nissan.model.LoanRequestDTO;
import com.nissan.model.User;

public interface ILoanService
{
	//Find All Loan
	List<Loan> findAllLoans();
	
	//Find All LoanRequest
	List<LoanRequest> finAllLoanRequests(int userID, int roleID);
	
	//Add Loan Request
	LoanRequest addLoanRequest(LoanRequestDTO loanRequestDTO);
	
	//Update Loan Request
	LoanRequest updateLoanRequest(LoanRequestDTO loanRequestDTO, int loanRequestID, boolean isApproved, int roleID);

}

