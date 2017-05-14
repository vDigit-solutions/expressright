package com.express.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.express.dao.LoginDao;
import com.express.vo.bean.LoginBean;
import com.express.vo.bean.SocialLoginBean;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	@Override
	public Map<String, Object> doLogin(LoginBean loginBean, BindingResult bindingResult,
			HttpServletRequest request, Integer appType , Integer device_type) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(bindingResult.getErrorCount() == 0 ){
    		
			result = loginDao.doLogin(loginBean.getUsername(), loginBean.getPassword(), request,appType , device_type);
			
    		}else{
    			result.put("error_count", bindingResult.getErrorCount());
    			result.put("errors", bindingResult.getAllErrors());
    		
    		}
		
		
		
		return result;
	}
	public Boolean logout(long session_id){
		return loginDao.logout(session_id);
	}
	@Override
	public Map<String, Object> doSocialLogin(SocialLoginBean loginBean,
			BindingResult bindingResult, HttpServletRequest request,
			Integer apptype, Integer device_type) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(bindingResult.getErrorCount() == 0 ){
    		
			result = loginDao.doScialLogin(loginBean.getProfileName(), loginBean.getEmail(), request,apptype , device_type , loginBean.getSocialType());
			
    		}else{
    			result.put("error_count", bindingResult.getErrorCount());
    			result.put("errors", bindingResult.getAllErrors());
    		
    		}
		
		
		
		return result;
	}

}
