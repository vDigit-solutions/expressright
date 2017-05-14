package com.express.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

import com.express.vo.bean.LoginBean;
import com.express.vo.bean.SocialLoginBean;

public interface LoginService {

	Map<String, Object> doLogin(LoginBean loginBean, BindingResult bindingResult,
			HttpServletRequest request, Integer apptype, Integer device_type);
	
	public Boolean logout(long session_id);

	Map<String, Object> doSocialLogin(SocialLoginBean loginBean,
			BindingResult bindingResult, HttpServletRequest request,
			Integer apptype, Integer device_type);

}
