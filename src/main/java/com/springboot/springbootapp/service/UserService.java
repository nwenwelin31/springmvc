package com.springboot.springbootapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springbootapp.model.UserModel;
import com.springboot.springbootapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<UserModel> getAllUsers(){
		return userRepo.findAll();
	}
}
