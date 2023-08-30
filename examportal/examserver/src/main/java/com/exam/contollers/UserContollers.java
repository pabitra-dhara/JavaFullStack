package com.exam.contollers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserContollers {

	@Autowired
	private UserServices userServices;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception{
		Set<UserRole> roles=new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(45);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.userServices.createUser(user,roles);
	}
	@GetMapping
	public User getUser(String username) {
		return this.userServices.
	}
}
