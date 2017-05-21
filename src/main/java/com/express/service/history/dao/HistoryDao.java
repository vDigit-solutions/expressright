package com.express.service.history.dao;

import java.util.List;

public interface HistoryDao {
	List<Long> loadHistory(Long user_session_id, Integer apptype);
}