package com.express.dao;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface LoginDao {

	Map<String, Object> doLogin(String username, String password,
			HttpServletRequest request, Integer appType, Integer device_type);
	public Boolean logout(long session_id);
	Map<String, Object> doScialLogin(String profileName, String email,
			HttpServletRequest request, Integer apptype, Integer device_type, Integer socialType);

}
