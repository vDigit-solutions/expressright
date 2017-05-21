package com.express.service.history;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.express.dao.videos.VideosDao;
import com.express.service.history.dao.HistoryDao;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryDao historyDao;

	@Autowired
	private VideosDao videosDao;

	@Override
	public Collection<Map<String, Object>> searchHistory(Long user_session_id, Integer apptype, Integer device_type,
			Integer pageNo, Integer pageSize) {
		if (user_session_id == null) {
			return null;
		}
		List<Long> videoIds = historyDao.loadHistory(user_session_id, apptype);

		return videosDao.getVideosbyVideoIds(videoIds);
	}

}
