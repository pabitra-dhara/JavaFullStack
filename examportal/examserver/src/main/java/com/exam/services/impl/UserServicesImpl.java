package com.exam.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserServices;
@Service
public class UserServicesImpl implements UserServices{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles){
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			 System.out.println("User is alredy there");
			try {
				throw new Exception("User is Alresdy there");
			} catch (Exception e) {
				System.out.println(e);
			}
		}else {
			//create user
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		return local;
	}

}
