package com.express.service.registration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.express.dao.registration.RegistrationDao;
import com.express.service.email.EmailSender;
import com.express.vo.bean.ProfileBean;
import com.express.vo.bean.RegistrationBean;

@Service
public class RegistrationServiecImpl implements RegistrationService {

	@Autowired
	RegistrationDao registrationDao;
	@Autowired
	EmailSender emailSender;

	private static Logger logger = LogManager.getLogger(RegistrationServiecImpl.class);

	@Override
	public Map<String, Object> userNameCheckAvailability(String username) {
		Map<String, Object> result = new HashMap<>();
		try {
			Boolean available = registrationDao.userNameCheckAvailability(username);
			result.put("available", available);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public Map<String, Object> registerUser(RegistrationBean registrationBean, BindingResult bindingResult,
			Integer apptype, Integer reg_from, Boolean login) {
		Map<String, Object> result = new HashMap<>();

		if (bindingResult.getErrorCount() == 0) {

			if (registrationBean.getPassword().equals(registrationBean.getConfirmPassword())) {
				result = registrationDao.registerUser(registrationBean, apptype, reg_from, login);
			} else {
				result.put("error", "Check password and confirm password ");
			}

		} else {
			result.put("error_count", bindingResult.getErrorCount());
			result.put("error", bindingResult.getAllErrors());
		}

		return result;
	}

	@Override
	public Map<String, Object> forgotPassword(String email_id, Integer apptype, Integer reg_from) {
		// TODO Auto-generated method stub
		Map<String, Object> user = registrationDao.forgotPassword(email_id, apptype, reg_from);
		if (user.isEmpty()) {
			return user;
		}
		emailSender.sendEmail(email_id, "Forgot Password", user.get("user_name"), user.get("user_password"));
		user.put("success", "success");
		return user;
	}

	@Override
	public Map<String, Object> updateProfile(ProfileBean profileBean, BindingResult bindingResult, Integer apptype,
			Integer device_type) {
		Map<String, Object> result = new HashMap<>();
		if (profileBean.getNewpassword().equals(profileBean.getPassword_confirmation())) {
			if (bindingResult.getErrorCount() == 0) {
				registrationDao.updateProfile(profileBean, apptype, device_type);
			} else {
				result.put("error_count", bindingResult.getErrorCount());
				result.put("error", bindingResult.getAllErrors());
			}
		} else {
			result.put("error_count", 1);
			result.put("error", Arrays.asList(new String[] { "Confirm password is not same as new password" }));
		}
		return null;
	}
}
