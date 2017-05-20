package com.express.dao.videos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class VideosDaoImpl extends JdbcDaoSupport implements VideosDao {

	private NamedParameterJdbcTemplate npJdbcTemplate;

	@Autowired
	public VideosDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		setJdbcTemplate(jdbcTemplate);
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
	}

	@Override
	public List<Map<String, Object>> getAllVideos(Integer pageNo, Integer pageSize) {

		checkForPageVariables(pageNo, pageSize);
		List<Map<String, Object>> result = null;
		int offset = (pageNo - 1) * pageSize + 1;

		String selectQuery = "SELECT * FROM ( SELECT * FROM v_online_videos ) AS tbl WHERE tbl.sl_no BETWEEN ? AND ? ";
		// String selectQuery = queryVideos + " ORDER BY video_id OFFSET
		// "+offset+" ROWS FETCH NEXT "+pageSize+" ROWS ONLY;";
		result = getJdbcTemplate().query(selectQuery, new Object[] { offset, offset + pageSize },
				new ColumnMapRowMapper());
		return result;
	}

	private void checkForPageVariables(Integer pageNo, Integer pageSize) {
		if (pageNo <= 0 || pageSize <= 0) {
			throw new IllegalArgumentException("Page size or page number is invalid , Expected to be Natural Number ");
		}

	}

	@Override
	public List<Map<String, Object>> getAllVideos() {

		List<Map<String, Object>> result = null;
		// new ColumnMapRowMapper()
		result = getJdbcTemplate().query("SELECT * FROM v_online_videos", new ColumnMapRowMapper());
		return result;
	}

	@Override
	public List<Map<String, Object>> getAllVideosbyTheme(Long theme_id, Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> result = null;
		int offset = (pageNo - 1) * pageSize + 1;

		String selectQuery = "SELECT * FROM ( SELECT * FROM v_online_videos_by_theme ) AS tbl WHERE tbl.sl_no BETWEEN ? AND ? ";
		// String selectQuery = queryVideosByTheme +" OFFSET " + offset+" ROWS
		// FETCH NEXT "+pageSize+" ROWS ONLY;";
		result = getJdbcTemplate().query(selectQuery, new Object[] { theme_id, offset, offset + pageSize },
				new ColumnMapRowMapper());
		return result;
	}

	@Override
	public List<Map<String, Object>> getAllVideosbyTheme(Long theme_id) {

		List<Map<String, Object>> result = null;

		result = getJdbcTemplate().query("SELECT * FROM v_online_videos_by_theme WHERE theme_type = ? ",
				new Object[] { theme_id }, new ColumnMapRowMapper());
		return result;
	}

	@Override
	public Map<String, Object> getVideobyVideoId(Long videoId) {

		Map<String, Object> result = null;

		result = getJdbcTemplate().queryForMap(" SELECT * FROM v_online_videos WHERE video_id = ? ",
				new Object[] { videoId });
		return result;
	}

	@Override
	public Map<String, Object> getVideoDetailbyVideoId(Long videoId) {

		Map<String, Object> result = null;

		result = getJdbcTemplate().queryForMap(
				" SELECT theme_type , thumbnail , file_path FROM online_video WHERE video_id = ? ",
				new Object[] { videoId });
		return result;
	}

	public List<Map<String, Object>> getRecentVideos(Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> result = null;

		int offset = (pageNo - 1) * pageSize + 1;

		String selectQuery = "SELECT * FROM ( SELECT * FROM v_online_videos ) AS tbl WHERE tbl.sl_no BETWEEN ? AND ? ";

		result = getJdbcTemplate().query(selectQuery, new Object[] { offset, offset + pageSize },
				new ColumnMapRowMapper());
		return result;
	}

	@Override
	public Collection<Map<String, Object>> loadAllVideos(Long theme, Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if (theme >= 0) {
			Map<String, Object> resultData = new HashMap<String, Object>();
			List<Map<String, Object>> data = searchVideosByTheme(theme, pageNo, pageSize);
			if (data.size() > 0) {
				Map<String, Object> themeMap = data.get(0);
				resultData.put("theme_id", themeMap.get("theme_id"));
				resultData.put("theme_name", themeMap.get("theme_name"));
				resultData.put("videos", data);
				result.add(resultData);
			}
		} else {

			List<Map<String, Object>> themes = getJdbcTemplate().queryForList(queryTheme);
			for (Map<String, Object> map : themes) {
				Long theme_id = (Long) map.get("theme_id");
				String theme_name = (String) map.get("theme_name");
				List<Map<String, Object>> data = searchVideosByTheme(theme_id, pageNo, pageSize);

				Map<String, Object> resultData = new HashMap<String, Object>();
				resultData.put("theme_id", theme_id);
				resultData.put("theme_name", theme_name);
				resultData.put("videos", data);
				result.add(resultData);
			}
		}
		return result;
	}

	private List<Map<String, Object>> searchVideosByTheme(Long theme, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		int offset = (pageNo - 1) * pageSize + 1;

		return getJdbcTemplate().queryForList(queryVideosByTheme, new Object[] { theme // });//
				, offset, offset + pageSize });

	}

	@Override
	public int deleteVideos(List<Long> video_ids, Long user_session_id) {
		Map<String, Object> params = new HashMap<>();
		params.put("video_ids", video_ids);
		params.put("id", user_session_id);
		return npJdbcTemplate.update(queryDeleteVideo, params);

	}

	@Override
	public void playBackStarted(Long video_id, Long user_session_id, Integer apptype, Integer device_type) {
		JdbcTemplate jt = getJdbcTemplate();
		jt.update("UPDATE ov SET ov.view_count = ov.view_count+1 FROM online_video ov WHERE ov.video_id = ?", video_id);

		if (user_session_id == null) {
			return;
		}

		Long user_id = jt.queryForObject("SELECT user_id FROM user_login_history WHERE id = ? ",
				new Object[] { user_session_id }, Long.class);
		jt.update(
				"INSERT INTO history_viewed_log(video_id , user_id , app_type , view_datetime) values( ? , ? , ? , ?)",
				new Object[] { video_id, user_id, apptype, new Date() });

	}

	@Override
	public void like(Long video_id, Long user_session_id, Integer apptype, Integer device_type) {
		JdbcTemplate jt = getJdbcTemplate();
		jt.update("UPDATE ov SET ov.like_count = ov.like_count + 1 FROM online_video ov WHERE ov.video_id = ?",
				video_id);
	}
}
