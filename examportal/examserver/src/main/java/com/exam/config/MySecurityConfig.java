package com.exam.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
	public UserDetailsService userDetailsService() {
		UserDetails pabitra=User.builder()
				.username("pabitra")
				.password("pabitra")
				.roles("USER")
				.build();
		
		UserDetails admin=User.builder()
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(pabitra,admin);
	}
}
