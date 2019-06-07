package com.booting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booting.pojo.User;

@RestController
public class UserController {

	@RequestMapping("/user")
	public List<User> getUsers(){
		List list = new ArrayList<>();
		list.add("user1");
		list.add("user2");
		list.add("user3");

		return list;
	}
}
