import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoanRequestDTO } from '../shared/loan-request-dto';
import { LoanService } from '../shared/loan.service';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.scss']
})
export class LoanComponent implements OnInit {

  // DI : Constructor Injection
  constructor(public loanService: LoanService) { 
  }

  //Life Cycle Hook
  ngOnInit(): void
  {
    this.loanService.bindGetAllLoansList();
  }

  //Submit Form
  onSubmit(form)
  {
    console.log(form.value);
    this.insertLoanRequest(form);
  }

  //Insert Method
  insertLoanRequest(form?: NgForm)
  {
     //User ID
     var tempUserID  = localStorage.getItem("UserID");
     if(tempUserID === null)
     {
       return;
     }

     form.value.userID = tempUserID as unknown as number ;

    console.log("Inserting a Request for Loan");
    console.log(form.value);
    // return;
    this.loanService.insertLoanRequest(form.value).subscribe(
      (result) =>{
        console.log(result);
      },
      (error)=>{
        console.log(error);
      }
    );
  }
}


 

