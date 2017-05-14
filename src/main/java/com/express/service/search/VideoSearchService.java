package com.express.service.search;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface VideoSearchService {

	Collection<Map<String, Object>> searchVideos(String query, Integer theme);

	Collection<Map<String, Object>> searchVideos(String query, Long theme,
			Integer pageNo, Integer pageSize);

	}
