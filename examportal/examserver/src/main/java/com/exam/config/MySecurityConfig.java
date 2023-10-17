package com.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.services.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class MySecurityConfig{
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean
	 	public static BCryptPasswordEncoder passwordEncoder() {
	 		return new BCryptPasswordEncoder();
	 	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	 
	protected void configure(HttpSecurity http) throws Exception{
		
	}

}
