package com.express.vo.bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationBean {

	@NotEmpty(message="username required")
    @Size(min=4, max=100,message="username criteria : min length must be 4 charachters")
	String username;
	@NotEmpty(message="password required")
    @Size(min=6, max=30,message="password criteria : min length must be 6 charachters")
	String password;
	@NotEmpty(message="password required")
    @Size(min=6, max=30,message="confirm password criteria : min length must be 6 charachters")
	String confirmPassword;
	@NotEmpty(message="phoneNumber required")
    @Size(min=10,message=" phone number : min lengt cannot be less than 10")
	String phoneNumber;
	@Email(message="Plesae check your email")
	@NotEmpty(message="email required")
	String email;
	@NotNull(message="Age Group is Required field")
	Integer ageGroup;
	//@NotNull(message="Gender is Required field")
	//Short gender;
	
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public Integer getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(Integer ageGroup) {
		this.ageGroup = ageGroup;
	}

	@AssertTrue(message="confirm password does not match")
	public Boolean isConfirmePasswordSameAsPassword(){
		return confirmPassword.equals(password);
	}
	
	
}
