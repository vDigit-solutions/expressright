package com.express.vo.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ProfileBean {

	@Email(message="User email id required")
    @Size(min=4, max=1000,message="Feedback message must be atleast 4 charachters")
	String email;
	@NotEmpty(message="profie id required")
	private Long profile_id;
	@NotEmpty(message="username required")
    @Size(min=4, max=100,message="user name criteria : min length must be 4 charachters")
	String full_name;
	
	@NotEmpty(message="username required")
    @Size(min=4, max=100,message="new Password criteria : min length must be 4 charachters")
	String newpassword;
	@NotEmpty(message="username required")
    @Size(min=4, max=100,message="confirmation passwprd criteria : min length must be 4 charachters")
	String password_confirmation;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(Long profile_id) {
		this.profile_id = profile_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getPassword_confirmation() {
		return password_confirmation;
	}
	public void setPassword_confirmation(String password_confirmation) {
		this.password_confirmation = password_confirmation;
	}
	
	
		
}
