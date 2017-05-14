package com.express.service.videos;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface VideosService {

	List<Map<String, Object>> getAllVideos(Integer pageNo, Integer pageSize);

	List<Map<String, Object>> getAllVideos();

	List<Map<String, Object>> getAllVideosbyTheme(Long theme_id,
			Integer pageNo, Integer pageSize);

	List<Map<String, Object>> getAllVideosbyTheme(Long theme_id);
	
	public Map<String, Object> getVideobyVideoId(Long videoId);

	List<Map<String, Object>> getRecentVideos(Integer pageNo, Integer pageSize);
	
	public Collection<Map<String, Object>> loadAllVideos(
			Long theme, Integer pageNo, Integer pageSize);

	Map<String, Object> deleteVideos(List<Long> video_ids, Long user_session_id);
	
	public void playBackStarted(Long video_id, Long user_session_id, Integer apptype, Integer device_type);

}
