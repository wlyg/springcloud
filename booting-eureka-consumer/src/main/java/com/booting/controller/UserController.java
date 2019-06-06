package com.booting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booting.pojo.User;
import com.booting.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/consumer")
	public List<User> getUsers(){
//		return this.userService.getUsers();
		return this.userService.getUser();
	}
}
