package com.express.dao;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.express.vo.bean.FeedbackBean;

public interface FeedbackDao {

	Map<String, Object> doFeedback(FeedbackBean feedbackBean,
			HttpServletRequest request, Integer appType, Integer device_type);

}
