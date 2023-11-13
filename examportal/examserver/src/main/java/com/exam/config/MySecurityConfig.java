package com.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.services.impl.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfiguration{n
	
	@Autowired
	private JwtAuthenticationEntrypoint unauthorizesHandler;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean
	public AuthenticationManager authenticationManagerBean() {
		return authenticationManagerBean();
	}
	
	@Bean
	 	public static PasswordEncoder passwordEncoder() {
	 		return NoOpPasswordEncoder.getInstance();
	 	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	 
	@SuppressWarnings({ "deprecation", "removal" })
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.cors().disable()
		.authorizeRequests()
		.requestMatchers("/generate-token","/user/").permitAll()
		.requestMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(unauthorizesHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
*/

@Configuration
public class MySecurityConfig{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService(){
		UserDetails noremalUser=User
				.withUsername("pabitra")
				.password(passwordEncoder().encode("password"))
				.roles("NORMEL")
				.build();
		
		UserDetails adminUser=User.withUsername("pabitra1")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
		
		
		return new InMemoryUserDetailsManager(noremalUser,adminUser);
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/generate-token","/user/")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		
		
		return http.build();
		
	}
}
