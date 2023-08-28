package com.exam.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserServices;

public class UserServicesImpl implements UserServices{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRole) {
		User local=this.userRepository.findByUserName(user.getUsername());
		if(local!=null) {
			System.out.println("User is alredy there"); 
//			throw new Exception("User is Alresdy there");
		}else {
			//create user
			for(UserRole ur:userRole) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRole);
			local=this.userRepository.save(user);
		}
		return local;
	}

}
