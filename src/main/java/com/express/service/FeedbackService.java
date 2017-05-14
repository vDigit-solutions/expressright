package com.express.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

import com.express.vo.bean.FeedbackBean;

public interface FeedbackService {

	Map<String, Object> doFeedback(FeedbackBean loginBean, BindingResult bindingResult,
			HttpServletRequest request, Integer apptype, Integer device_type);
	


}
