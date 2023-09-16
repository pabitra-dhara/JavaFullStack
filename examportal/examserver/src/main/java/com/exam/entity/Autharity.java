package com.exam.entity;

import org.springframework.security.core.GrantedAuthority;

public class Autharity implements GrantedAuthority{
	
	private String authority;
	
	public Autharity(String authority) {
		super();
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

}
