package com.exam.services;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;

public interface UserServices {
//create user
	public User createUser(User user,Set<UserRole>userRole);
	
	//get user by username
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userId);
	
	//update user using user id
	public User updateUser(Long userId,User user);


}
