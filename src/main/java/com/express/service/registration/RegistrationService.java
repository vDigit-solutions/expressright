package com.express.service.registration;

import java.util.Map;

import org.springframework.validation.BindingResult;

import com.express.vo.bean.ProfileBean;
import com.express.vo.bean.RegistrationBean;

public interface RegistrationService {

	Map<String, Object> userNameCheckAvailability(String username);

	Map<String, Object> registerUser(RegistrationBean registrationBean, BindingResult bindingResult, Integer apptype, Integer reg_from, Boolean login);

	Map<String, Object> forgotPassword(String email_id, Integer apptype,
			Integer reg_from);
	
	Map<String, Object> updateProfile(ProfileBean profileBean,BindingResult bindingResult, Integer apptype,
			Integer reg_from);

}
