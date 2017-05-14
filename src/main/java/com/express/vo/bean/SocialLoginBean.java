package com.express.vo.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SocialLoginBean {

	@NotNull(message="Profile Name required")
	@NotEmpty(message="Profile Name required")
	String profileName;
	@NotNull(message="Profile Email required")
	@NotEmpty(message="Profile Email required")
	String email;
	@NotNull(message= "Socialtype is required")
	int socialType;
	


	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSocialType() {
		return socialType;
	}
	public void setSocialType(int socialType) {
		this.socialType = socialType;
	}
	@Override
	public String toString() {
		return "SocialLoginBean [profileName=" + profileName + ", email="
				+ email + ", socialType=" + socialType + "]";
	}
	
	
}
