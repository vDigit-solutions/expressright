package com.express.sessions;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

import com.express.dao.LoginDao;

public class LogoutListner implements HttpSessionListener , HttpSessionAttributeListener,ApplicationContextAware {

	Logger logger = LogManager.getLogger(LogoutListner.class);
	@Autowired
	LoginDao logindao;
	
	
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		if(session.getAttribute(SessionManager.USER_SESSION_ID)!=null){
			logger.info("New Login found with username [0] , history id [1]",session.getAttribute(SessionManager.USER_SESSION_ID),session.getAttribute(SessionManager.USER_NAME));
		}
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		if(session.getAttribute(SessionManager.USER_SESSION_ID)!=null){
			logger.info("Logout found with username [0] , history id [1]",session.getAttribute(SessionManager.USER_SESSION_ID),session.getAttribute(SessionManager.USER_NAME));
			long session_id = (long) session.getAttribute(SessionManager.USER_SESSION_ID);
			logindao.logout(session_id);
			SessionManager.sessionMap.remove(session_id);
		}

	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		if(arg0.getName() == SessionManager.USER_SESSION_ID){
			SessionManager.sessionMap.put((Long)arg0.getValue(), arg0.getSession());
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.info("logout listner");
		  if (applicationContext instanceof WebApplicationContext) {
	            ((WebApplicationContext) applicationContext).getServletContext().addListener(this);
	        } else {
	            //Either throw an exception or fail gracefully, up to you
	            throw new RuntimeException("Must be inside a web application context");
	        }
		
	}


}
