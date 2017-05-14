package com.express.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	public Map<String, Object> uploadAttachment( MultipartFile request, String description, Integer theme, String name, Long session_id);

	public Collection<Map<String, Object>> loadUserVideos(Long session_id,
			Long theme, Integer pageNo, Integer pageSize);
	
}
