package com.express.controller.registration;

import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.express.service.registration.RegistrationService;
import com.express.vo.bean.RegistrationBean;

@RestController
@CrossOrigin(methods={RequestMethod.GET , RequestMethod.POST})
@RequestMapping(value="registration")
public class RegistrationController {
	private static Logger logger = LogManager.getLogger(RegistrationController.class);
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping("username_available/{username}")
	public Map<String, Object> userNameCheckAvailability(@PathVariable(value = "username") String username){
		Map<String, Object> result = null;
		try {
			
			result = registrationService.userNameCheckAvailability(username);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	
	@RequestMapping
	public Map<String, Object> registerUser(@Valid RegistrationBean registrationBean , BindingResult bindingResult,
			@RequestParam(required = false, defaultValue = "3") Integer apptype,
			@RequestParam(required = false, defaultValue = "2") Integer reg_from){
		Map<String, Object> result = null;
		try {
			
			
			result = registrationService.registerUser(registrationBean, bindingResult,apptype,reg_from,false);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.put("error 500", "service error");
		}
		return result;
	}
	
	@RequestMapping("do")
	public Map<String, Object> registerUserJson(@Valid @RequestBody RegistrationBean registrationBean , BindingResult bindingResult,
			@RequestParam(required = false, defaultValue = "3") Integer apptype,
			@RequestParam(required = false, defaultValue = "2") Integer reg_from,
			@RequestParam(required = false, defaultValue = "false") Boolean login){
		Map<String, Object> result = null;
		try {
			
			
			result = registrationService.registerUser(registrationBean, bindingResult,apptype,reg_from,login);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.put("error 500", "service error");
		}
		return result;
	}

	@RequestMapping("forgotPassword")
	public Map<String, Object> forgotPassword(@RequestParam String email_id,
			@RequestParam(required = false, defaultValue = "3") Integer apptype,
			@RequestParam(required = false, defaultValue = "2") Integer reg_from){
		Map<String, Object> result = null;
		try {
			
			
			result = registrationService.forgotPassword(email_id,apptype,reg_from);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.put("error 500", "service error");
		}
		return result;
	}
	
}
