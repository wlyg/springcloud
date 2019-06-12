package com.booting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booting.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {

	@HystrixCommand(fallbackMethod = "testFallBack")
	@RequestMapping("/user")
	public List<User> getUsers(){
		List list = new ArrayList<>();
		list.add("user1");
		list.add("user2");
		list.add("user3");
		int i = 1 / 0;

		return list;
	}

	public List<User> testFallBack () {
		List list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");

		return list;
	}
}
