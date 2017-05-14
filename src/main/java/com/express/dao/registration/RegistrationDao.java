package com.express.dao.registration;

import java.util.Map;

import com.express.vo.bean.ProfileBean;
import com.express.vo.bean.RegistrationBean;

public interface RegistrationDao {

	Boolean userNameCheckAvailability(String username);

	Map<String, Object> registerUser(RegistrationBean registrationBean, Integer apptype, Integer reg_from, Boolean login);

	Map<String, Object> forgotPassword(String email_id, Integer apptype,
			Integer reg_from);

	void updateProfile(ProfileBean profileBean, Integer apptype,
			Integer device_type);

}
