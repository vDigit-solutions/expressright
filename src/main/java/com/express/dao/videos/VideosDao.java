package com.express.dao.videos;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface VideosDao {
	
	String queryVideosByTheme = "SELECT * FROM ( SELECT ROW_NUMBER() OVER( ORDER BY video_id ) as slNo,video_id ,video_name , file_mime_type , theme_type , video_description , video_duration , video_uploaded_time , file_url , thumbnail_url , user_name , theme_id , theme_name , view_count FROM v_online_videos ov JOIN index_themes it ON it.theme_id = ov.theme_type WHERE  theme_id = ? ) AS tbl  WHERE slNo BETWEEN ? AND ? ";
	String queryVideosSearch = "SELECT * FROM ( SELECT ROW_NUMBER() OVER( ORDER BY video_id ) as slNo,video_id ,video_name , file_mime_type , theme_type , video_description , video_duration , video_uploaded_time , file_url , thumbnail_url , user_name , theme_id , theme_name , view_count FROM v_online_videos ov JOIN index_themes it ON it.theme_id = ov.theme_type  WHERE slNo BETWEEN ? AND ? ";
	String queryDeleteVideo = "DELETE FROM online_video WHERE user_id = (SELECT user_id FROM user_login_history WHERE id = :id ) AND video_id IN (:video_ids)";// WHERE slNo BETWEEN ? AND ? ";
	 
	public static final String queryTheme = " SELECT DISTINCT theme_id , theme_name FROM online_video ov JOIN index_themes it ON it.theme_id = ov.theme_type ";



	List<Map<String, Object>> getAllVideos(Integer pageNo, Integer pageSize);

	List<Map<String, Object>> getAllVideos();

	List<Map<String, Object>> getAllVideosbyTheme(Long theme_id,
			Integer pageNo, Integer pageSize);

	List<Map<String, Object>> getAllVideosbyTheme(Long theme_id);
	
	public Map<String, Object> getVideobyVideoId(Long videoId);

	List<Map<String, Object>> getRecentVideos(Integer pageNo, Integer pageSize);
	
	public Collection<Map<String, Object>> loadAllVideos(
			Long theme, Integer pageNo, Integer pageSize);

	int deleteVideos(List<Long> video_ids, Long user_session_id);
	
	public Map<String, Object> getVideoDetailbyVideoId(Long videoId);
	
	public void playBackStarted(Long video_id, Long user_session_id, Integer apptype, Integer device_type);

}
