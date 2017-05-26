package com.express.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.express.dao.videos.VideosDao;
import com.express.util.PpreparedStatementCreator;

@Repository
public class UploadDaoImpl extends JdbcDaoSupport implements UploadDao {

	private final String persistFileInfoSql = "INSERT INTO online_video (video_name ,file_path ,file_mime_type ,theme_type ,user_id,video_added_datetime ,video_updated_datetime ,video_status ,thumbnail , video_duration , video_description , mp4Address ) VALUES (? ,? ,?  ,? ,? ,?  ,? ,? ,?  ,? , ? , ?)";
	private final String queryVideoBySessionUser = "SELECT  ROW_NUMBER() OVER( ORDER BY video_id) as sl_no, video_id ,  video_name ,  file_mime_type ,  theme_type ,   video_description,   CONVERT(time(0), DATEADD(SECOND, video_duration, 0)) as 'video_duration' ,  CONVERT(VARCHAR(54),video_added_datetime,120) video_uploaded_time,  CONCAT((SELECT base_url  FROM video_base_url ),'/',theme_type,'/' , file_path) file_url , CONCAT((SELECT base_url  FROM video_base_url ),'/',theme_type,'/' , thumbnail) thumbnail_url , view_count , mp4Address FROM online_video   JOIN user_registration ON online_video.user_id = user_registration.user_id JOIN user_login_history ON user_login_history.user_id = online_video.user_id AND user_login_history.id = ? AND theme_type = ? ";

	@Autowired
	public UploadDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public Number persistFileInfo(final String filrPath, final String contentType, final String description,
			final Integer theme, final String name2, final String thumbnail, final Long session_id,
			final Future<Double> duration, final String mp4Address) {
		Number videoId = null;
		try {

			final PreparedStatementSetter paramsSetter = new PreparedStatementSetter() {
				private final Long userId = getUseridBySession(session_id);

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					try {
						// video_name ,file_path ,file_mime_type ,theme_type
						// ,user_id,video_added_datetime ,video_updated_datetime
						// ,video_status ,thumbnail , video_duration
						ps.setString(1, name2);
						ps.setString(2, filrPath);
						ps.setString(3, contentType);
						ps.setInt(4, theme);
						ps.setLong(5, userId);
						ps.setDate(6, new Date(System.currentTimeMillis()));
						ps.setString(7, null);
						ps.setBoolean(8, true);
						ps.setString(9, thumbnail);
						ps.setLong(10, duration.get().longValue());
						ps.setString(11, description);
						ps.setString(12, mp4Address);
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					}
				}
			};

			final PreparedStatementCreator psCreater = new PpreparedStatementCreator(paramsSetter, persistFileInfoSql);

			final KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

			getJdbcTemplate().update(psCreater, generatedKeyHolder);

			videoId = generatedKeyHolder.getKey();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return videoId;
	}

	private Long getUseridBySession(Long session_id) {
		// TODO Auto-generated method stub
		return getJdbcTemplate().queryForObject("SELECT user_id FROM user_login_history WHERE id = ? ", Long.class,
				session_id);
	}

	@Override
	public Collection<Map<String, Object>> loadUserVideos(Long session_id, Long theme, Integer pageNo,
			Integer pageSize) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if (theme >= 0) {
			Map<String, Object> resultData = new HashMap<String, Object>();
			List<Map<String, Object>> data = searchVideosByTheme(session_id, theme, pageNo, pageSize);
			Map<String, Object> themeMap = data.get(0);
			resultData.put("theme_id", themeMap.get("theme_id"));
			resultData.put("theme_name", themeMap.get("theme_name"));
			resultData.put("videos", data);
			result.add(resultData);
		} else {

			List<Map<String, Object>> themes = getJdbcTemplate().queryForList(VideosDao.queryTheme);
			for (Map<String, Object> map : themes) {
				Long theme_id = (Long) map.get("theme_id");
				String theme_name = (String) map.get("theme_name");
				List<Map<String, Object>> data = searchVideosByTheme(session_id, theme_id, pageNo, pageSize);
				if (data.size() > 0) {
					Map<String, Object> resultData = new HashMap<String, Object>();
					resultData.put("theme_id", theme_id);
					resultData.put("theme_name", theme_name);
					resultData.put("videos", data);
					result.add(resultData);
				}
			}
		}
		return result;
	}

	private List<Map<String, Object>> searchVideosByTheme(Long session_id, Long theme, Integer pageNo,
			Integer pageSize) {
		// TODO Auto-generated method stub
		int offset = (pageNo - 1) * pageSize + 1;

		return getJdbcTemplate().queryForList(this.queryVideoBySessionUser, new Object[] { session_id, theme });

	}

}
