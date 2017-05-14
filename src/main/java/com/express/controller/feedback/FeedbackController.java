package com.express.controller.feedback;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.express.service.FeedbackService;
import com.express.service.registration.RegistrationService;
import com.express.vo.bean.FeedbackBean;
import com.express.vo.bean.LoginBean;
import com.express.vo.bean.RegistrationBean;

@RestController
@CrossOrigin(methods={RequestMethod.GET , RequestMethod.POST})
@RequestMapping(value="feedback")
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	private static Logger logger = LogManager.getLogger(FeedbackController.class);
	
	  @RequestMapping()
	    public Map<String, Object> doFeedback(@Valid FeedbackBean feedbackBean , BindingResult bindingResult,
	    		@RequestParam(required = false, defaultValue = "3") Integer apptype,
				@RequestParam(required = false, defaultValue = "2") Integer device_type
				, HttpServletRequest request){
	    	Map<String, Object> result = null;
	    	try {
	    		//request.getRemoteHost()
				result = feedbackService.doFeedback(feedbackBean , bindingResult , request,apptype ,device_type);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
	    	return result;
	    }
	    
	    @RequestMapping(value="do")
	    public Map<String, Object> doFeedbackJson(@Valid @RequestBody FeedbackBean feedbackBean , BindingResult bindingResult,
	    		@RequestParam(required = false, defaultValue = "3") Integer apptype,
				@RequestParam(required = false, defaultValue = "2") Integer device_type
				, HttpServletRequest request){
	    	Map<String, Object> result = null;
	    	try {
	    		//request.getRemoteHost()
				result = feedbackService.doFeedback(feedbackBean , bindingResult , request,apptype ,device_type);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
	    	return result;
	    }
	
}
