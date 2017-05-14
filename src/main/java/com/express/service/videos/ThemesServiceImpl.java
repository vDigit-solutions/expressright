package com.express.service.videos;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.express.dao.videos.ThemesDao;

@Service
public class ThemesServiceImpl implements ThemesService{

	
	@Autowired
	ThemesDao themsDao;
	@Override
	public List<Map<String, Object>> getAllThemes(Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> result = null;
		result = themsDao.getAllThemes( pageNo,  pageSize) ;
		return result;
		
	}
	@Override
	public List<Map<String, Object>> getAllThemes() {
		List<Map<String, Object>> result = null;
		result = themsDao.getAllThemes() ;
		return result;
	}
	@Override
	public Map<String, Object> getThemeById(Long theme_id) {
		Map<String, Object> result = null;
		result = themsDao.getThemeById(theme_id) ;
		return result;
	}

}
