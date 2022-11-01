package com.nissan.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.LoanRequest;

@Repository
public interface ILoanRequestRepository extends JpaRepositoryImplementation<LoanRequest,Integer>
{
	//Spring Data JPA -- JpaRepositoryImplementation, 
	@Query("from LoanRequest where assignedTo = ?1")
	public List<LoanRequest> findLoanRequestsForOfficer(int userID); 
	
	@Query("from LoanRequest where userID = ?1")
	public List<LoanRequest> findLoanRequestsForCustomer(int userID); 
	
	@Query("from LoanRequest where userID = ?1 and roleID = 1")
	public List<LoanRequest> findLoanRequestsForAdmin(int userID);
	
	
	//Ask for Request Date
	@Query("select requestDate from LoanRequest where loanRequestID = ?1")
	public Date frindRequestDateByUserID(int loanRequestID);
	
	

	
}

