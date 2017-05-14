package com.express.sessions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(asyncSupported=true,urlPatterns = {"/*"})
public class SessionManager implements Filter{

	public static final String USER_SESSION_ID = "user_session_id";
	public static final String USER_NAME = "user_name";
	
	public static Map<Long, HttpSession> sessionMap = new HashMap<Long, HttpSession>();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		boolean pass = false;
		if(request.getRequestURI().contains("/auth/login")||request.getRequestURI().contains("/registration")){
			pass = true;
		}
		HttpSession session = request.getSession(false);
		if(session != null){
			if(session.getAttribute(USER_SESSION_ID)!= null){
				pass = true;
			}
		}
		
		if(pass){
			doFilter(arg0, arg1, arg2);
		}else{
			response.getOutputStream().write("{'error':'auth required'}".getBytes());
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
