package com.express.dao.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class VideoSearchDaoImpl extends JdbcDaoSupport implements VideoSearchDao{
	
	String queryVideosByTheme = "SELECT * FROM ( SELECT ROW_NUMBER() OVER( ORDER BY video_id ) as slNo,video_id ,video_name , file_mime_type , theme_type , video_description , video_duration , video_uploaded_time , file_url , thumbnail_url , user_name , theme_id , theme_name FROM v_online_videos ov JOIN index_themes it ON it.theme_id = ov.theme_type WHERE AND theme_id = ? ) AS tbl WHERE slNo BETWEEN ? AND ? ";
	String queryVideosSearch = "SELECT * FROM ( SELECT ROW_NUMBER() OVER( ORDER BY video_id ) as slNo,video_id ,video_name , file_mime_type , theme_type , video_description , video_duration , video_uploaded_time , file_url , thumbnail_url , user_name , theme_id , theme_name FROM v_online_videos ov JOIN index_themes it ON it.theme_id = ov.theme_type WHERE ( video_name LIKE ? OR video_description LIKE ? ) AND theme_id = ? ) AS tbl WHERE slNo BETWEEN ? AND ? ";
	String queryTheme = " SELECT DISTINCT theme_id , theme_name FROM v_online_videos ov JOIN index_themes it ON it.theme_id = ov.theme_type WHERE ( video_name LIKE ? OR video_description LIKE ? ) ";
	String queryIndexTheme = " SELECT theme_id , theme_name index_theme ";
	String queryWithoutTheme = " SELECT * FROM v_online_videos ov JOIN index_themes it ON it.theme_id = ov.theme_type WHERE video_name LIKE ? OR video_description LIKE ?  ";
	
	@Autowired
	public VideoSearchDaoImpl(JdbcTemplate jdbcTemplate){
		super();
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public List<Map<String, Object>> searchVideos(String query, Integer theme) {
		List<Map<String, Object>> result = null;
		if(theme>=0){
			result = getJdbcTemplate().query(this.queryVideosSearch,new Object[]{"%"+query+"%" , "%"+query+"%" , theme}, new ColumnMapRowMapper());
		}else{
			result = getJdbcTemplate().query(this.queryWithoutTheme,new Object[]{"%"+query+"%" , "%"+query+"%" }, new ColumnMapRowMapper());
			
		}
		return result;
	}

	@Override
	public Collection<Map<String, Object>> searchVideos(String query,
			Long theme, Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		if(theme>=0){
			Map<String, Object> resultData = new HashMap<String, Object>();
			List<Map<String, Object>> data = searchVideosByTheme("%"+query+"%" , theme , pageNo , pageSize);
			if(data.size() > 0){
				Map<String, Object> themeMap = data.get(0);
				resultData.put("theme_id",themeMap.get("theme_id"));
				resultData.put("theme_name",themeMap.get("theme_name"));
				resultData.put("videos", data);
				result.add(resultData);
			}
		}else{
			
			List<Map<String, Object>> themes = getJdbcTemplate().queryForList(this.queryTheme,new Object[]{"%"+query+"%" , "%"+query+"%" });
			System.out.println(themes);
			for (Map<String, Object> map : themes) {
				Long theme_id = (Long) map.get("theme_id");
				String theme_name = (String) map.get("theme_name");
				List<Map<String, Object>> data = searchVideosByTheme("%"+query+"%" , theme_id , pageNo , pageSize);
				
				Map<String, Object> resultData = new HashMap<String, Object>();
				resultData.put("theme_id",theme_id);
				resultData.put("theme_name",theme_name);
				resultData.put("videos", data);
				result.add(resultData);
			}
		}
		return result;
	}

	private List<Map<String, Object>> searchVideosByTheme(String query,
			Long theme, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		int offset = (pageNo-1)*pageSize+1;
		if(query != null && query.length()>0){
			return getJdbcTemplate().queryForList(this.queryVideosSearch,new Object[]{query , query , theme ,offset,offset+pageSize});
		}else{
			return getJdbcTemplate().queryForList(this.queryVideosByTheme,new Object[]{  theme ,offset,offset+pageSize});
			
		}
	}
	

	}
