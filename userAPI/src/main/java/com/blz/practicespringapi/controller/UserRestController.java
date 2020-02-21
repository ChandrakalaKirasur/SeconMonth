package com.blz.practicespringapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blz.practicespringapi.model.User;
import com.blz.practicespringapi.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	} 
	
	@RequestMapping("/user/{useName}")
	public User getUser(@PathVariable String useName) {
		return userService.getUser(useName);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user) {
		 userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{useName}")
	public void updateUser(@RequestBody User user,@PathVariable String useName) {
		userService.updateUser(useName,user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/user/{userID}")
	public void deleteUser(@RequestBody String userID) {
		userService.deleteUser(userID);
	}
}
