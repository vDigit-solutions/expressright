package com.express.vo.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {
	
	@NotNull(message="username required")
	@NotEmpty(message="username required")
	String username;
	@NotNull(message="password required")
	@NotEmpty(message="password required")
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
