package com.exam.contollers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	//getuser by user name
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userServices.getUser(username);
	}
	
	//deleteuser by user id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userServices.deleteUser(userId);
	}
	
	//update user by user name
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable("userId") Long userId,@RequestBody User user) {
		User updateUser=this.userServices.updateUser(userId, user);
		return updateUser;
	}
}
