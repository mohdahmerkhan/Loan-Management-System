
package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Loan;
import com.nissan.model.LoanRequest;
import com.nissan.model.LoanRequestDTO;
import com.nissan.model.Role;
import com.nissan.model.User;
import com.nissan.service.ILoanService;
import com.nissan.service.IRoleService;
import com.nissan.service.IUserService;


@CrossOrigin		//Helps to Avoid CORS Error
@RestController
@RequestMapping("api/")
public class AppRestController
{
	//Field Injection
	@Autowired
	IUserService userService;
	
	//Field Injection
	@Autowired
	IRoleService roleService;
	
	//Field Injection
	@Autowired
	ILoanService loanService;
	
	
	//List all Users
	@GetMapping("users")
	public List<User> findAllUser()
	{
		return userService.findAllUsers();
	}
	
	//List all Roles
	@GetMapping("roles")
	public List<Role> findAllRole()
	{
		return roleService.findAllRoles();
	}
	
	//List all Loans
	@GetMapping("loans")
	public List<Loan> findAllLoan()
	{
		return loanService.findAllLoans();
	}
	
	//List all LoanRequests
	@GetMapping("loanRequests")
	public List<LoanRequest> findAllLoanRequest()
	{
		return loanService.finAllLoanRequests();
	}


	
	@GetMapping("userLogin/{emailOrPhone}&{password}")
	public User findUserByEmailPhoneAndPassword(@PathVariable String emailOrPhone, @PathVariable String password)
	{
		System.out.println("Inside Controller");
		return userService.findByEmailPhoneAndPassword(emailOrPhone, password);
	}
	
	//Add User
	@PostMapping("users")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		System.out.println("Inserting a Record");
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.OK);
	}
	
	//Update User
	@PutMapping("users")
	public User updateUser(@RequestBody User user)
	{
		System.out.println("Updating a Record");
		return userService.updateUser(user);
	}
	
	//Add LoanRequests
	@PostMapping("loanRequests")
	public ResponseEntity<LoanRequest> addUser(@RequestBody LoanRequestDTO loanRequestDTO)
	{
		System.out.println("Inserting a Loan Request");
		return new ResponseEntity<LoanRequest>(loanService.addLoanRequest(loanRequestDTO),HttpStatus.OK);
	}
	
	//Update LoanRequests
	@PutMapping("loanRequests")
	public LoanRequest updateUser(@RequestBody LoanRequest loanRequest)
	{
		System.out.println("Updating a Loan request");
		return loanService.updateLoanRequest(loanRequest);
	}
	
	
	
	//Delete(Actually Disable) User
	@PutMapping("users/{userID}")
	public void deleteUser(@PathVariable int userID)
	{
		System.out.println("Disabling the record");
		userService.deleteUser(userID);
		//return userService.;
	}
	
}


