package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.LoanRequest;

@Repository
public interface ILoanRequestRepository extends JpaRepositoryImplementation<LoanRequest,Integer>
{
	//Spring Data JPA -- JpaRepositoryImplementation, 
	
}

