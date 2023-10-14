package com.exam.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@EnableWebMvc
@Configuration
public class MySecurityConfig{
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated()
				).httpBasic(Customizer.withDefaults());
		return http.build();
	}

}
