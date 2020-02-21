package com.blz.practicespringapi.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blz.practicespringapi.model.User;

public interface UserRepository extends CrudRepository<User,String> {

	//getAllUsers()
	//getUser(String userName)
	//crup repository is a interface it implements all basic crup operations
	public static User findByUserName(String useName,List<User> users) {
		return users.stream().filter(t -> t.getUseName().equals(useName)).findFirst().get();

	}

	public static void deleteByUserName(String useName,List<User> users) {
		users.removeIf(user -> user.getUseName().equals(useName));
	}

	
}
