package com.springboot.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/protected")
    public String protectedEndpoint() {
        return "This is a protected endpoint";
    }
}
