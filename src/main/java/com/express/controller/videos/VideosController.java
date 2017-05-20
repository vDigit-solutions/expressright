package com.express.controller.videos;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.express.service.videos.VideosService;

@RestController("videos")
@RequestMapping("videos")
@CrossOrigin
public class VideosController {

	@Autowired
	VideosService videosService;

	Logger logger = LogManager.getLogger(VideosController.class);

	@RequestMapping
	public List<Map<String, Object>> getAllVideos(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		List<Map<String, Object>> result = null;
		result = videosService.getAllVideos(pageNo, pageSize);
		return result;
	}

	@RequestMapping("recent")
	public List<Map<String, Object>> getRecentVideos(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		List<Map<String, Object>> result = null;
		result = videosService.getRecentVideos(pageNo, pageSize);
		return result;
	}

	@RequestMapping("all")
	public List<Map<String, Object>> getAllVideos() {
		List<Map<String, Object>> result = null;
		result = videosService.getAllVideos();
		return result;
	}

	@RequestMapping("theme/{theme_id}")
	public List<Map<String, Object>> getAllVideosbyTheme(@PathVariable("theme_id") Long theme_id,
			@RequestParam(required = false, defaultValue = "0") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		List<Map<String, Object>> result = null;
		result = videosService.getAllVideosbyTheme(theme_id, pageNo, pageSize);
		return result;
	}

	@RequestMapping("theme/{theme_id}/all")
	public List<Map<String, Object>> getAllVideosbyTheme(@PathVariable("theme_id") Long theme_id) {
		List<Map<String, Object>> result = null;
		result = videosService.getAllVideosbyTheme(theme_id);
		return result;
	}

	@RequestMapping("{videoId}")
	public Map<String, Object> getVideobyVideoId(@PathVariable("videoId") Long videoId) {
		Map<String, Object> result = null;
		result = videosService.getVideobyVideoId(videoId);
		return result;
	}

	@RequestMapping("loadAll")
	public Collection<Map<String, Object>> searchVideos(@RequestParam(required = false, defaultValue = "-1") Long theme,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "8") Integer pageSize) {
		return videosService.loadAllVideos(theme, pageNo, pageSize);
	}

	@RequestMapping("playBackStarted")
	public Collection<Map<String, Object>> playBackStarted(@RequestParam Long video_id,
			@RequestParam Long user_session_id, @RequestParam(required = false, defaultValue = "3") Integer apptype,
			@RequestParam(required = false, defaultValue = "2") Integer device_type) {
		logger.info("video play back started " + video_id);
		videosService.playBackStarted(video_id, user_session_id, apptype, device_type);
		return null;
	}

	@RequestMapping("like")
	public Collection<Map<String, Object>> like(@RequestParam Long video_id, @RequestParam Long user_session_id,
			@RequestParam(required = false, defaultValue = "3") Integer apptype,
			@RequestParam(required = false, defaultValue = "2") Integer device_type) {
		logger.info("video like " + video_id);
		videosService.like(video_id, user_session_id, apptype, device_type);
		return null;
	}

	@RequestMapping("deleteVideos")
	public Map<String, Object> deleteVideos(@RequestParam("video_ids[]") Long[] video_ids,
			@RequestParam Long user_session_id) {
		logger.info(video_ids.length + "  " + user_session_id);
		Map<String, Object> result = videosService.deleteVideos(Arrays.asList(video_ids), user_session_id);
		return result;
	}

	@RequestMapping("deleteVideos/do")
	public Collection<Map<String, Object>> doDeleteVideos(@RequestBody com.express.vo.bean.DeleteVideos deleteVideos) {
		logger.info(deleteVideos.getVideo_ids() + "  " + deleteVideos.getUser_session_id());
		videosService.deleteVideos(deleteVideos.getVideo_ids(), deleteVideos.getUser_session_id());
		return null;
	}

}
