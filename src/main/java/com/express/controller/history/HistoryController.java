package com.express.controller.history;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.express.service.history.HistoryService;

@RestController("historyVideos")
@RequestMapping("historyVideos")
@CrossOrigin
public class HistoryController {

	@Autowired
	HistoryService historyService;

	@RequestMapping
	public Collection<Map<String, Object>> history(@RequestParam Long user_session_id,
			@RequestParam(required = false, defaultValue = "3") Integer apptype,
			@RequestParam(required = false, defaultValue = "2") Integer device_type,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "8") Integer pageSize) {
		return historyService.searchHistory(user_session_id, apptype, device_type, pageNo, pageSize);
	}
}
