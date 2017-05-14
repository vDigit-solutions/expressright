package com.express.dao;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Future;


public interface UploadDao {

	

	Number persistFileInfo(String name, String contentType, String description,
			Integer theme, String name2, String thumbnail, Long session_id, Future<Double> duration, String mp4Address);
	
	public Collection<Map<String, Object>> loadUserVideos(
			Long session_id,Long theme, Integer pageNo, Integer pageSize);

}
