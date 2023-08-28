package com.exam.services;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;

public interface UserServices {
//create user
	public User createUser(User user,Set<UserRole>userRole);
}
