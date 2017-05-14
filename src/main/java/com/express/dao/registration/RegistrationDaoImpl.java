package com.express.dao.registration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.express.dao.LoginDao;
import com.express.vo.bean.ProfileBean;
import com.express.vo.bean.RegistrationBean;

@Repository
public class RegistrationDaoImpl extends JdbcDaoSupport implements RegistrationDao {

	@Autowired
	public RegistrationDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		setJdbcTemplate(jdbcTemplate);
	}

	@Autowired
	private LoginDao loginDao;

	@Autowired
	private PasswordEncryptionService passwordEncryptionService;

	@Override
	public Boolean userNameCheckAvailability(String username) {
		boolean result = false;

		int usersCount = getJdbcTemplate().queryForObject("SELECT count(*) FROM user_registration WHERE user_name = ?",
				new String[] { username }, Integer.class);
		result = usersCount == 0;
		return result;
	}

	@Override
	public Map<String, Object> registerUser(RegistrationBean registrationBean, Integer apptype, Integer reg_from,
			Boolean login) {

		String password = passwordEncryptionService.encrypt(registrationBean.getPassword());

		Map<String, Object> result = new HashMap<String, Object>();
		int usersCount = getJdbcTemplate().queryForObject(
				"SELECT count(*) FROM user_registration WHERE user_email = ? OR user_mobile = ?  ",
				new String[] { registrationBean.getEmail(), registrationBean.getPhoneNumber() }, Integer.class);
		if (usersCount == 0) {
			int insertCount = getJdbcTemplate().update(
					"INSERT INTO user_registration( user_name ,user_email ,user_password ,user_mobile ,user_registration_from ,user_registration_app_type ,user_registration_date ,user_last_updated_date,user_age_group )  VALUES (?,? ,?  ,?  ,?  ,?  ,?, null ,? )",
					registrationBean.getUsername(), registrationBean.getEmail(), password,
					registrationBean.getPhoneNumber(), reg_from, apptype, new Date(), registrationBean.getAgeGroup()// ,registrationBean.getGender()
			);
			if (insertCount == 1) {
				if (login) {
					result = loginDao.doLogin(registrationBean.getEmail(), registrationBean.getPassword(), null,
							apptype, reg_from);
				}
				result.put("success", true);
				result.put("message", "Registration Process Done");
			}
		} else {
			result.put("success", false);
			result.put("message", "Email Or Phone Number Already Registered...");
			result.put("ERROR_CODE", "EXPR0001");
		}
		return result;
	}

	@Override
	public Map<String, Object> forgotPassword(String email_id, Integer apptype, Integer reg_from) {
		Random random = new Random(9999);
		String input = email_id.substring(0, email_id.indexOf("@")) + random.nextLong();
		String newPass = passwordEncryptionService.encrypt(input);
		getJdbcTemplate().update("UPDATE user_registration set user_password = ? where user_email = ?", newPass,
				email_id);
		Map<String, Object> result = null;
		result = getJdbcTemplate().queryForMap("SELECT user_name FROM user_registration WHERE user_email = ?",
				email_id);
		result.put("user_password", input);
		return result;
	}

	@Override
	public void updateProfile(ProfileBean profileBean, Integer apptype, Integer device_type) {
		getJdbcTemplate().update("UPDATE user_registration SET user_password = ? WHERE user_email = ?",
				profileBean.getNewpassword(), profileBean.getEmail());

	}
}
