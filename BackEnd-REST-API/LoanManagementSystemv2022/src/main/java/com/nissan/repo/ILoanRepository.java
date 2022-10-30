package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Loan;


@Repository
public interface ILoanRepository extends JpaRepositoryImplementation<Loan,Integer>
{
	//Spring Data JPA -- JpaRepositoryImplementation, 
	
}

