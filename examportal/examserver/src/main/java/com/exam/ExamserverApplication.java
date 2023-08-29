package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.services.UserServices;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{
	//password encription
	@Autowired
	private UserServices userServices;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
		System.out.print("Application Run And Reddy");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
//		User user=new User();
//		user.setFirstName("Pabitra");
//		user.setLastName("Dhara");
//		user.setUsername("pabitar@721140");
//		user.setPassword("12345678");
//		user.setEmail("pabitra@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1=new Role();
//		role1.setRoleId(1);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		User user1=this.userServices.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
//		System.out.println(user1.getPassword());
	}
}
