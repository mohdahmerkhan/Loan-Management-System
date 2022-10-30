package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Role;
import com.nissan.repo.IRoleRepository;

@Service
public class RoleServiceImpl implements IRoleService
{
	//Field Injection
	@Autowired
	IRoleRepository roleRepo;
	
	//Find All
	@Override
	public List<Role> findAllRoles()
	{
		return (List<Role>)roleRepo.findAll();
	}

}
