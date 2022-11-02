import { Injectable } from '@angular/core';
import { LoanRequest } from './loan-request';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Loan } from './loan';
import { LoanRequestDTO } from '../shared/loan-request-dto';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  
  //Global Variable
  formLoanRequest : LoanRequestDTO = new LoanRequestDTO();

  loanRequests : LoanRequest[]; // All Loan Requests
  loans : Loan[];  //All Loan Types

  constructor(private httpClient: HttpClient)
  {
  }

  //Call REST API
  //  1 Get all Loan Requests
  getAllLoanRequests(): Observable<any> {
    //  http://localhost:9095/api/loanRequests
    
    var userID =  localStorage.getItem("UserID");
    var roleID =  localStorage.getItem("roleIDloan");
    
    return this.httpClient.get(environment.apiUrl + "api/loanRequests/"+userID+"&"+roleID);
    
  }

  //  2 Retrieve all Loan Request List for Listing
  bindGetAllLoanRequestList() {
    
    var userID =  localStorage.getItem("userID");
    var roleID =  localStorage.getItem("roleID");
    this.httpClient.get(environment.apiUrl + 'api/loanRequests/'+userID+"&"+roleID)
      .toPromise()
      .then(
        (response) => {
          console.log(response);
          this.loanRequests = response as LoanRequest[];
        }
      );
  }

  // Get all Loans List
  bindGetAllLoansList()
  {
    this.httpClient.get(environment.apiUrl + 'api/loans')
      .toPromise()
      .then(
        (response) => {
          console.log(response);
          this.loans = response as Loan[];
        }
      );
  }


  
  // INSERT
  insertLoanRequest(loanRequestDTO: LoanRequestDTO): Observable<any> {

    return this.httpClient.post(environment.apiUrl + 'api/loanRequests', loanRequestDTO);
  }






}
