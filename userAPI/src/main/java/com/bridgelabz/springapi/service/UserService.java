package com.bridgelabz.springapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.springapi.model.User;

@Service
public class UserService {
	
	private List<User> users=new ArrayList<>(Arrays.asList(new User("chandrakala","Chandra","chandra12","8147267142"),new User("Ravikumar","RaviK","ravi1234","9686200267")));
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getUser(String userName) {
		return users.stream().filter(t -> t.getUseName().equals(userName)).findFirst().get();
	}

	public void addUser(User user) {
		users.add(user);
	}


	public void updateUser(String userName, User user) {
		for(int i=0;i<users.size();i++) {
			User u=users.get(i);
			if(u.getUseName().equals(userName))
				users.set(i, user);
				return;
		}
	}
}
