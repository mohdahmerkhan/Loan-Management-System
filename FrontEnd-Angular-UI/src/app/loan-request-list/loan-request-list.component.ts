import { Component, OnInit } from '@angular/core';
import { LoanService } from '../shared/loan.service';


@Component({
  selector: 'app-loan-request-list',
  templateUrl: './loan-request-list.component.html',
  styleUrls: ['./loan-request-list.component.scss']
})
export class LoanRequestListComponent implements OnInit {

  constructor(public loanService : LoanService) { }

  ngOnInit(): void
  {
    console.log("Welcome to the LifeCycle Hook of Loan Service");
    this.loanService.bindGetAllLoanRequestList();
  }

  //Subscribe get All Loan Request List
  getAllLoanRequestList()
  {
    //Call Service
    this.loanService.getAllLoanRequests().subscribe(
      response => {
        console.log("Retrieving from list");
        console.log(response);
      },
      (error) =>{
        console.log("Something Wrong");
        console.log(error);
      }
    )
  }
}

