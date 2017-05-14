package com.express.service.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.express.dao.search.VideoSearchDao;

@Service
public class VideoSearchServiceImpl implements VideoSearchService{
	
	@Autowired
	private VideoSearchDao videoSearchDao;

	@Override
	public Collection<Map<String, Object>> searchVideos(String query, Integer theme) {
		Collection<Map<String, Object>> result = null;
		Map<Long, Map<String, Object>> resultMap = new HashMap<Long, Map<String,Object>>();
		List<Map<String, Object>> data = null;
		data = videoSearchDao.searchVideos(query , theme);
		
		for (Map<String, Object> map : data) {
			Long theme_id = (Long) map.get("theme_id");
			if(resultMap.containsKey(theme_id)){
				Map<String, Object> themeMap = resultMap.get(theme_id);
				List<Map<String, Object>> videos = (List<Map<String, Object>>) themeMap.get("videos");
				videos.add(map);
			}else{
				List<Map<String, Object>> videos = new ArrayList<Map<String,Object>>();
				videos.add(map);
				Map<String, Object> themeMap = new HashMap<>();
				themeMap.put("theme_id", theme_id);
				themeMap.put("theme_name", map.get("theme_name"));
				themeMap.put("videos", videos);
				resultMap.put(theme_id, themeMap);
				
			}
		}
		
		result = resultMap.values();
		return result;
	}

	@Override
	public Collection<Map<String, Object>> searchVideos(String query,
			Long theme, Integer pageNo, Integer pageSize) {
		Collection<Map<String, Object>> result = null;
		result = videoSearchDao.searchVideos(query , theme , pageNo , pageSize);
		return result;
	}

	}
