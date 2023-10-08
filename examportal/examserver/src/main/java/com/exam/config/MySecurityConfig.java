package com.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;



@EnableWebSecurity
@Configuration
public class MySecurityConfig{
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUser=User.withUsername("pabitra").password("password").roles("ROLE_NORMAL").build();
		
		
		UserDetails adminUser=User.withUsername("pabitra1").password("password").roles("ROLE_ADMIN").build();
		return null;
	}
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
	
		return http.build();
	}

}
