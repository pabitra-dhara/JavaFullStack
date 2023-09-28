package com.exam.config;



import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import jakarta.servlet.Filter;



@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfiguration{

	@Override
	public Filter springSecurityFilterChain() throws Exception {
		// TODO Auto-generated method stub
		return super.springSecurityFilterChain();
	}


	
	
}
