package com.express.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.express.dao.registration.PasswordEncryptionService;
import com.express.sessions.SessionManager;

@Repository
public class LoginDaoImpl extends JdbcDaoSupport implements LoginDao {

	@Autowired
	public LoginDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Autowired
	private PasswordEncryptionService passwordEncryptionService;

	@Override
	public Map<String, Object> doLogin(String username, String password, HttpServletRequest request, Integer appType,
			Integer device_type) {
		String encrypted = passwordEncryptionService.encrypt(password);
		Map<String, Object> result = new HashMap<String, Object>();

		Object[] returnData = getJdbcTemplate().query("EXEC f_do_login_manual ? , ? , ? , ? ",
				new Object[] { username, encrypted, appType, device_type }, new ResultSetExtractor<Object[]>() {

					@Override
					public Object[] extractData(ResultSet rs) throws SQLException, DataAccessException {
						ResultSetMetaData rsmd = rs.getMetaData();

						rs.next();
						int columCount = rsmd.getColumnCount();
						Object[] data = new Object[columCount];
						for (int i = 1; i <= columCount; i++) {
							data[i - 1] = rs.getObject(i);
						}
						return data;
					}

				});
		Integer loginStatus = (int) returnData[0];
		Long session_id = (Long) returnData[1];
		String message = (String) returnData[2];
		String name = (String) returnData[3];

		switch (loginStatus) {
		case 1:

			result.put("success", false);
			result.put("message", message);
			break;
		case 2:
			result.put("success", true);
			result.put("message", message);
			result.put("name", name);
			result.put(SessionManager.USER_SESSION_ID, session_id);
			if (request != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute(SessionManager.USER_SESSION_ID, session_id);
				session.setAttribute(SessionManager.USER_NAME, username);
			}

			break;

		default:
			break;
		}

		return result;
	}

	public Boolean logout(long session_id) {
		boolean result = false;

		getJdbcTemplate().update("UPDATE user_login_history SET user_loggedout_time = ? WHERE [user_id] = ?",
				new Object[] { new Date(), session_id });

		return result;
	}

	@Override
	public Map<String, Object> doScialLogin(String profileName, String email, HttpServletRequest request,
			Integer apptype, Integer device_type, Integer socialType) {

		Map<String, Object> result = new HashMap<String, Object>();

		Object[] returnData = getJdbcTemplate().query(
				"EXEC f_do_social_login" + " @profileName =  ?," + " @profileEmail =?," + " @app_type = ?,"
						+ " @device_type = ?," + " @socialType = ?",
				new Object[] { profileName, email, apptype, device_type, socialType },
				new ResultSetExtractor<Object[]>() {

					@Override
					public Object[] extractData(ResultSet rs) throws SQLException, DataAccessException {
						ResultSetMetaData rsmd = rs.getMetaData();

						rs.next();
						int columCount = rsmd.getColumnCount();
						Object[] data = new Object[columCount];
						for (int i = 1; i <= columCount; i++) {
							data[i - 1] = rs.getObject(i);
						}
						return data;
					}

				});
		Integer loginStatus = (int) returnData[0];
		Long session_id = (Long) returnData[1];
		String message = (String) returnData[2];
		String name = (String) returnData[3];

		switch (loginStatus) {
		case 1:

			result.put("success", false);
			result.put("message", message);
			break;
		case 2:
			result.put("success", true);
			result.put("message", message);
			result.put("name", name);
			result.put(SessionManager.USER_SESSION_ID, session_id);
			if (request != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute(SessionManager.USER_SESSION_ID, session_id);
				session.setAttribute(SessionManager.USER_NAME, profileName);
			}

			break;

		default:
			break;
		}

		return result;

	}

}
