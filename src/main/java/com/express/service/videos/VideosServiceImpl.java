package com.express.service.videos;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.express.dao.videos.VideosDao;

@Service
public class VideosServiceImpl implements VideosService {

	Logger logger = LogManager.getLogger(VideosServiceImpl.class);
	@Autowired
	VideosDao videosDao;

	@Value("${files.uploadDir}")
	private String fileUploadPath;

	@Override
	public List<Map<String, Object>> getAllVideos(Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> result = null;
		result = videosDao.getAllVideos(pageNo, pageSize);
		return result;
	}

	@Override
	public List<Map<String, Object>> getAllVideos() {
		List<Map<String, Object>> result = null;
		result = videosDao.getAllVideos();
		return result;
	}

	@Override
	public List<Map<String, Object>> getAllVideosbyTheme(Long theme_id, Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> result = null;
		result = videosDao.getAllVideosbyTheme(theme_id, pageNo, pageSize);
		return result;
	}

	@Override
	public List<Map<String, Object>> getAllVideosbyTheme(Long theme_id) {
		List<Map<String, Object>> result = null;
		result = videosDao.getAllVideosbyTheme(theme_id);
		return result;
	}

	public Map<String, Object> getVideobyVideoId(Long videoId) {
		Map<String, Object> result = null;
		result = videosDao.getVideobyVideoId(videoId);
		return result;
	}

	public List<Map<String, Object>> getRecentVideos(Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> result = null;
		result = videosDao.getRecentVideos(pageNo, pageSize);
		return result;
	}

	public Collection<Map<String, Object>> loadAllVideos(Long theme, Integer pageNo, Integer pageSize) {
		return videosDao.loadAllVideos(theme, pageNo, pageSize);
	}

	@Override
	public Map<String, Object> deleteVideos(List<Long> video_ids, Long user_session_id) {
		List<Long> failedList = new ArrayList<Long>();
		Map<String, Object> result = new HashMap<String, Object>();
		for (Long videoId : video_ids) {
			try {
				Map<String, Object> video = videosDao.getVideoDetailbyVideoId(videoId);
				Long theme_type = (Long) video.get("theme_type");
				String file_path = (String) video.get("file_path");
				String thumbnail = (String) video.get("thumbnail");
				final String fileLocation = fileUploadPath + File.separator + theme_type + File.separator;

				File video_file = new File(fileLocation, file_path);
				File thumbnail_file = new File(fileLocation, thumbnail);

				FileUtils.deleteQuietly(video_file);
				FileUtils.deleteQuietly(thumbnail_file);
			} catch (Exception e) {
				logger.error(" error deleating file " + e.getMessage(), e);
				if (video_ids.remove(videoId)) {
					failedList.add(videoId);
				}
			}
		}

		int deleatedCount = videosDao.deleteVideos(video_ids, user_session_id);
		result.put("deleatedCount", deleatedCount);
		result.put("deleatedVideo", video_ids);
		result.put("failedList", failedList);
		return result;
	}

	public void playBackStarted(Long video_id, Long user_session_id, Integer apptype, Integer device_type) {
		videosDao.playBackStarted(video_id, user_session_id, apptype, device_type);
	}

}
