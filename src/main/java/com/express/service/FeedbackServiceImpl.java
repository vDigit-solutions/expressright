package com.express.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.express.dao.FeedbackDao;
import com.express.dao.LoginDao;
import com.express.vo.bean.FeedbackBean;
import com.express.vo.bean.LoginBean;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackDao feedbackDao;
	@Override
	public Map<String, Object> doFeedback(FeedbackBean feedbackBean, BindingResult bindingResult,
			HttpServletRequest request, Integer appType , Integer device_type) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(bindingResult.getErrorCount() == 0 ){
    		
			result = feedbackDao.doFeedback(feedbackBean, request,appType , device_type);
			
    		}else{
    			result.put("error_count", bindingResult.getErrorCount());
    			result.put("errors", bindingResult.getAllErrors());
    		
    		}
		
		
		
		return result;
	}
	
}
