package com.springboot.springbootapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
	
	public Optional<UserModel> getUserById(int userId) {
		return userRepo.findById(userId);
	}
	
	public List<String> getAllUserNames(){
		return userRepo.findAllUserNames();
	}
	
	public void saveUser(UserModel user) {
		userRepo.save(user);
    }
	public void deleteUser(int userId) {
		userRepo.deleteById(userId);
	}
	
	public void updateUser(int userId, UserModel updatedUser) {
		UserModel existingUser = userRepo.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            // Update any other fields as needed
            userRepo.save(existingUser);
        }
	}
}
