package com.express.vo.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ForgotBean {
	@Email(message = "Plesae check your email")
	@NotEmpty(message = "email required")
	String email;

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
