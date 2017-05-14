package com.express.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.express.service.UploadService;


@RestController
@CrossOrigin
public class UploadController {

	@Autowired
	UploadService uploadService;

	@RequestMapping(value = "uploadAttachments", method = RequestMethod.POST, produces = {
			"application/json" })
	public @ResponseBody Callable<List<Map<String, Object>>> uploadAttachments(final @RequestParam("file") MultipartFile[] file ,final @RequestParam(value="description") String[] description ,final @RequestParam(value="theme") Integer[] theme,final @RequestParam(value="name") String[] name ,final @RequestParam(value="session_id") Long session_id) {
		
		return new Callable<List<Map<String, Object>>>() {

			@Override
			public List<Map<String, Object>> call() throws Exception {
				List<Map<String, Object>> result = new ArrayList<>();
				;
				for (int i = 0; i < file.length; i++) {
					Map<String, Object> map = uploadService.uploadAttachment( file[i] , description[i],theme[i],name[i],session_id);
					result.add(map);
				}
				
				return result;
			}
		};
	}
	
	@RequestMapping(value = "uploadAttachment", method = RequestMethod.POST, produces = {
	"application/json" })
public @ResponseBody Callable<Map<String, Object>> uploadAttachment(final @RequestParam("file") MultipartFile file ,
		final @RequestParam(value="description") String description ,
		final @RequestParam(value="theme") Integer theme,
		final @RequestParam(value="title") String name,
		final @RequestParam(value="session_id") Long session_id) {

return new Callable<Map<String, Object>>() {

	@Override
	public Map<String, Object> call() throws Exception {
		Map<String, Object> result = null;
		
			result= uploadService.uploadAttachment( file , description,theme,name,session_id);
		
		return result;
	}
};
}

	@RequestMapping(value = "getNumber")
	public @ResponseBody Integer getNumber() {
		return 20;
	}
	@RequestMapping(value = "loadUserVideos", produces = {
	"application/json" })
	public Collection<Map<String, Object>> loadUserVideos(
			final @RequestParam(value="session_id")  Long session_id,
			final @RequestParam(required = false , defaultValue="-1") Long theme ,
			final @RequestParam(required = false , defaultValue="0") Integer pageNo ,
			final @RequestParam(required = false , defaultValue="8") Integer pageSize){
		return uploadService.loadUserVideos(session_id, theme ,  pageNo , pageSize);
		
	}
}
