package com.express.service.history;

import java.util.Collection;
import java.util.Map;

public interface HistoryService {

	Collection<Map<String, Object>> searchHistory(Long user_session_id, Integer apptype, Integer device_type,
			Integer pageNo, Integer pageSize);

}
