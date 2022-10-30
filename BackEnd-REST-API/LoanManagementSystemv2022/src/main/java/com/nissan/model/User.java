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
@Table(name = "TblUser")
public class User
{
	//Declare Variable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String phoneNo;
	
	@Column(nullable = false)
	private String password;
	
	private Date dateOfBirth;
	private boolean isActive;
	
	//@JoinColumn				//User.roleId = Role.roleId
	@JoinColumn(name = "roleID")
	@ManyToOne
	private Role role;

	
	//Default Constructor
	public User()
	{
		super();
	}
	
	//Parameterized Constructor
	public User(int userID, String name, String email, String phoneNo, String password, Date dateOfBirth,
			boolean isActive, Role role)
	{
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.isActive = isActive;
		this.role = role;
	}

	//Getters & Setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo(){
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo){
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	//Overriding toString()
	@Override
	public String toString() {
		return String.format(
				"User [userID=%s, name=%s, email=%s, phoneNo=%s, password=%s, dateOfBirth=%s, isActive=%s, role=%s]",
				userID, name, email, phoneNo, password, dateOfBirth, isActive, role);
	}
		
	
	
}
