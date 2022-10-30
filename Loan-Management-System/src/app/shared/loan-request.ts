import { Loan } from "./loan";
import { User } from "./user";

export class LoanRequest
{
    loanRequestID : number;
    amount : number;
    status : string;
    requestDate : Date;
    approveDate  : Date;
    sourceOfIncome : string;
    tenure : number;
    remarks : string;
    govtID : string;
    loan : Loan;
    user : User;
    assignedTo : User;
}
