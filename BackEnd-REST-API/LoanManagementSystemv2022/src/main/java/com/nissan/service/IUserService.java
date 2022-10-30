package com.nissan.service;

import java.util.List;

import com.nissan.model.User;

public interface IUserService
{
	//Find All Users
	List<User> findAllUsers();
	
	//Find By Email or Phone & password
	User findByEmailPhoneAndPassword(String emailOrPhone, String password);
	
	//Insert User
	User addUser(User user);
	
	//Update User
	User updateUser(User user);
	
	//Delete(Actually Disable) User
	void deleteUser(int userId);
}
