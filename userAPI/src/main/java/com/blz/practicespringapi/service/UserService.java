package com.blz.practicespringapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.practicespringapi.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	private static List<User> users=new ArrayList<User>();
	
	public List<User> getAllUsers(){
		//return users;
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User getUser(String useName) {
		//return users.stream().filter(t -> t.getUseName().equals(userName)).findFirst().get();
		return UserRepository.findByUserName(useName,users);
		
	}

	public void addUser(User user) {
		userRepository.save(user);
	}
	public void updateUser(String userID, User user) {
		userRepository.save(user);
	}

	public void deleteUser(String userID) {
		userRepository.deleteById(userID);
		//UserRepository.deleteByUserName(useName,users);
	}
}
