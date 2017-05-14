package com.express.dao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.express.vo.bean.FeedbackBean;


@Repository
public class FeedbackDaoImpl extends JdbcDaoSupport implements FeedbackDao{

	@Autowired
	public FeedbackDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}
	
	@Override
	public Map<String, Object> doFeedback(FeedbackBean feedbackBean,
			HttpServletRequest request, Integer appType , Integer device_type) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		getJdbcTemplate().update("INSERT INTO contact_us_log  (name ,email ,subject ,message) VALUES (? , ? , ? , ? )", feedbackBean.getName() , feedbackBean.getEmailAddress() , feedbackBean.getSubject() , feedbackBean.getMessage());
		result.put("success", true);
		result.put("message", "Thankyou for contacting..");
		return result;
	}
	
	

}
