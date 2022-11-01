package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Role;
import com.nissan.model.User;
import com.nissan.repo.IUserRepository;

@Service
public class UserServiceImpl implements IUserService
{
	//Field Injection
	@Autowired
	IUserRepository userRepo;
	
	//Find All
	@Override
	public List<User> findAllUsers()
	{
		return (List<User>)userRepo.findAll();
	}

	
	//Find by (Email or Phone) & Password
	@Override
	public User findByEmailPhoneAndPassword(String emailOrPhone, String password)
	{
		User _user = userRepo.findByEmailPhoneAndPassword(emailOrPhone, password);
		
		if(_user != null)
		{
			//Check Condition for User
			if( (emailOrPhone.equals(_user.getEmail()) ||
					emailOrPhone.equals(_user.getPhoneNo())) 
					&& password.equals(_user.getPassword()) )
			{
				return _user;
			}
			
			return null;
		}

		return null;
	}
	

	//Add User
	@Transactional
	@Override
	public User addUser(User user)
	{
		//Setting User Active
		user.setActive(true);
		
		//Setting Role of the user As Customer
		Role tempRole = new Role();
		tempRole.setRoleID(3);
		tempRole.setRoleName("Customer");
		user.setRole(tempRole);
		
		return userRepo.save(user);
	}


	//Update User
	@Transactional
	@Override
	public User updateUser(User user)
	{
		return userRepo.save(user);
	}
	
	//Delete or Disable User
	@Transactional
	@Override
	public void deleteUser(int userId)
	{
		userRepo.disableById(userId);
	}


	
}
