package com.express.service.videos;

import java.util.List;
import java.util.Map;

public interface ThemesService {

	List<Map<String, Object>> getAllThemes(Integer pageNo, Integer pageSize);

	List<Map<String, Object>> getAllThemes();

	Map<String, Object> getThemeById(Long theme_id);

}
