package com.nissan.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TblLoanRequest")
public class LoanRequest
{	
	//Declare Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanRequestID;
	
	private Date requestDate;
	private Date approveDate;
	private double amount;
	private String status;			//Pending By Default
	private int tenure;
	private String sourceOfIncome;
	private String remarks;
	
	@Column(nullable = false)
	private String govtID;
	
	
	//@JoinColumn				//LoanRequest.userID = User.userID
	@JoinColumn(name = "userID")
	@ManyToOne
	private User user;	
	
	//@JoinColumn				//LoanRequest.loanID = Loan.loanID
	@JoinColumn(name = "loanID")
	@ManyToOne
	private Loan loan;	
	
	//@JoinColumn				//LoanRequest.userID = User.userID
	@JoinColumn(name = "assignedUserID")
	@ManyToOne
	private User assignedTo;

	//Default Constructor
	public LoanRequest()
	{
		super();
	}


	//Parameterized Constructor
	public LoanRequest(int loanRequestID, Date requestDate, Date approveDate, double amount, String status, int tenure,
			String sourceOfIncome, String remarks, String govtID, User user, Loan loan, User assignedTo) {
		super();
		this.loanRequestID = loanRequestID;
		this.requestDate = requestDate;
		this.approveDate = approveDate;
		this.amount = amount;
		this.status = status;
		this.tenure = tenure;
		this.sourceOfIncome = sourceOfIncome;
		this.remarks = remarks;
		this.govtID = govtID;
		this.user = user;
		this.loan = loan;
		this.assignedTo = assignedTo;
	}
	
	// Copy LoanRequestDTO to LoanRequest
	public LoanRequest(LoanRequestDTO loanRequestDTO)
	{
		this.amount = loanRequestDTO.getAmount();
		this.govtID = loanRequestDTO.getGovtID();
		this.tenure = loanRequestDTO.getTenure();
		this.sourceOfIncome = loanRequestDTO.getSourceOfIncome();
		
		this.user = new User();
		this.user.setUserID(loanRequestDTO.getUserID());
		
		this.loan = new Loan();
		this.loan.setLoanID(loanRequestDTO.getLoanID());
	}

	
	//Getters & Setters
	public int getLoanRequestID() {
		return loanRequestID;
	}

	public void setLoanRequestID(int loanRequestID) {
		this.loanRequestID = loanRequestID;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getGovtID() {
		return govtID;
	}

	public void setGovtID(String govtID) {
		this.govtID = govtID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	
	//Overriding toString()
	@Override
	public String toString() {
		return String.format(
				"LoanRequest [loanRequestID=%s, requestDate=%s, approveDate=%s, amount=%s, status=%s, tenure=%s, sourceOfIncome=%s, remarks=%s, govtID=%s, user=%s, loan=%s, assignedTo=%s]",
				loanRequestID, requestDate, approveDate, amount, status, tenure, sourceOfIncome, remarks, govtID, user,
				loan,assignedTo);
	}
	
	
	
	
	
	
	
}

