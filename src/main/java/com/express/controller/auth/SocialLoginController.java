package com.express.controller.auth;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.express.service.LoginService;
import com.express.sessions.SessionManager;
import com.express.vo.bean.LoginBean;
import com.express.vo.bean.SocialLoginBean;


@RestController
@CrossOrigin(methods={RequestMethod.GET , RequestMethod.POST ,RequestMethod.DELETE , RequestMethod.PUT})
@RequestMapping(value="auth_social")
public class SocialLoginController {

    Logger logger = LogManager.getLogger(SocialLoginController.class);
    @Autowired LoginService loginService;
    
    @RequestMapping(value="login")
    public Map<String, Object> doLogin(@Valid SocialLoginBean loginBean , BindingResult bindingResult,
    		@RequestParam(required = false, defaultValue = "3") Integer apptype,
			@RequestParam(required = false, defaultValue = "2") Integer device_type
			, HttpServletRequest request){
    	Map<String, Object> result = null;
    	try {
    		//request.getRemoteHost()
			result = loginService.doSocialLogin(loginBean , bindingResult , request,apptype ,device_type);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	return result;
    }
    
    @RequestMapping(value="login/do")
    public Map<String, Object> doLoginJson(@Valid @RequestBody SocialLoginBean loginBean , BindingResult bindingResult,
    		@RequestParam(required = false, defaultValue = "3") Integer apptype,
			@RequestParam(required = false, defaultValue = "2") Integer device_type
			, HttpServletRequest request){
    	Map<String, Object> result = null;
    	try {
    		//request.getRemoteHost()
			result = loginService.doSocialLogin(loginBean , bindingResult , request,apptype ,device_type);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	return result;
    }
    
    @RequestMapping(value="logout")
    public Boolean doLogout(HttpSession session){
    	session.invalidate();
    	return true;
    }
    
    @RequestMapping(value="logout/do")
    public Boolean doLogout(HttpSession session, @RequestParam Long session_id){
    	boolean result = false;
    	if(SessionManager.sessionMap.containsKey(session_id)){
    		SessionManager.sessionMap.get(session_id).invalidate();
    		result = true;
    	}else{
    		loginService.logout(session_id);
    		result = true;
    	}
    	return result;
    }
    
   
}
