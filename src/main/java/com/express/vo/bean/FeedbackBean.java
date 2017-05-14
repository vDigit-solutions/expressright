package com.express.vo.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class FeedbackBean {

	@NotEmpty(message="Feedback message required")
    @Size(min=4, max=1000,message="Feedback message must be atleast 4 charachters")
	String message;
	@NotEmpty(message="username required")
    @Size(min=4, max=100,message="username criteria : min length must be 4 charachters")
	String name;
	
	@Email(message="Plesae check your email")
	@NotEmpty(message="email required")
	String emailAddress;
	String subject;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public FeedbackBean(String message, String name, String emailAddress,
			String subject) {
		super();
		this.message = message;
		this.name = name;
		this.emailAddress = emailAddress;
		this.subject = subject;
	}
	
	
		
}
