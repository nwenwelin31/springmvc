package com.springboot.springbootapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootapp.model.UserModel;
import com.springboot.springbootapp.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@RequestMapping(value = "/all_users", method = RequestMethod.GET)
	public List<UserModel> allUsers(){
		List<UserModel> res = userservice.getAllUsers();
		return res;
	}
	
	@RequestMapping(value = "/select_user/{userId}", method = RequestMethod.GET)
	public Optional<UserModel> getUser(@PathVariable int userId){
		Optional<UserModel> res = userservice.getUserById(userId);
		return res;
	}
	@RequestMapping(value = "/user_names", method = RequestMethod.GET)
	public List<String> getAllUserNames(){
		List<String> res = userservice.getAllUserNames();
		return res;
	}
	
	@RequestMapping(value="/add_user" ,method = RequestMethod.POST)
	    public String createUser(@RequestBody UserModel user) {
			userservice.saveUser(user);
	        return "User saved successfully!";
	}
	 
	@PutMapping("/update_user/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserModel user) {
        userservice.updateUser(userId, user);
        return "User updated successfully!";
    }
	
	 @DeleteMapping("/delete_user/{userId}")
	    public String deleteUser(@PathVariable int userId) {
	        userservice.deleteUser(userId);
	        return "User deleted successfully!";
	    }
	 
	@GetMapping("/protected")
    public String protectedEndpoint() {
        return "This is a protected endpoint";
    }
}
