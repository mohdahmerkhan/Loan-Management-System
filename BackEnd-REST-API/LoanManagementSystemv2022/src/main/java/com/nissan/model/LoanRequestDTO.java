package com.nissan.model;

public class LoanRequestDTO
{
	// Declare Fields
	private double amount;
	private int tenure;
	private String sourceOfIncome;
	private String govtID;
	private int userID;
	private int loanID;
	
	//Default Constructor
	public LoanRequestDTO()
	{
		super();
	}
	
	//Parameterized Constructor
	public LoanRequestDTO(double amount, int tenure, String sourceOfIncome, String govtID, int userID, int loanID)
	{
		this.amount = amount;
		this.tenure = tenure;
		this.sourceOfIncome = sourceOfIncome;
		this.govtID = govtID;
		this.userID = userID;
		this.loanID = loanID;
	}
	
	//Getters & Setters
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
	public String getGovtID() {
		return govtID;
	}
	public void setGovtID(String govtID) {
		this.govtID = govtID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getLoanID() {
		return loanID;
	}
	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}
	
	//Overriding toString()
	@Override
	public String toString() {
		return String.format(
				"LoanRequestDTO [amount=%s, tenure=%s, sourceOfIncome=%s, govtID=%s, UserID=%s, loanID=%s, getAmount()=%s, getTenure()=%s, getSourceOfIncome()=%s, getGovtID()=%s, getUserID()=%s, getLoanID()=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				amount, tenure, sourceOfIncome, govtID, userID, loanID, getAmount(), getTenure(), getSourceOfIncome(),
				getGovtID(), getUserID(), getLoanID(), getClass(), hashCode(), super.toString());
	}	
	
	

}
