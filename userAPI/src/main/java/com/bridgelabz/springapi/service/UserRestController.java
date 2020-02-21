package com.bridgelabz.springapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springapi.model.User;

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
	
	@RequestMapping("/user/{userName}")
	public User getUser(@PathVariable String userName) {
		return userService.getUser(userName);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user) {
		 userService.addUser(user);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/users/{userName}")
	public void updateUser(@RequestBody User user,@PathVariable String userName) {
		userService.updateUser(userName,user);
	}
}
