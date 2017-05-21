package com.express.service.history.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDaoImpl extends JdbcDaoSupport implements HistoryDao {

	@Autowired
	public HistoryDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public List<Long> loadHistory(Long user_session_id, Integer apptype) {
		if (user_session_id == null) {
			return null;
		}
		JdbcTemplate jt = getJdbcTemplate();
		Long user_id = jt.queryForObject("SELECT user_id FROM user_login_history WHERE id = ?",
				new Object[] { user_session_id }, Long.class);
		return jt.queryForList("SELECT distinct video_id FROM history_viewed_log WHERE user_id = ? and app_type = ?",
				new Object[] { user_id, apptype }, Long.class);

	}

}
