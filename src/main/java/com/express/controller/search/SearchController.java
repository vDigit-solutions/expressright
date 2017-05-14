package com.express.controller.search;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.express.service.search.VideoSearchService;

@RestController("search")
@RequestMapping("search")
@CrossOrigin
public class SearchController {
	
	@Autowired
	private VideoSearchService searchService;
	
	@RequestMapping
	public Collection<Map<String, Object>> searchVideos(
			@RequestParam(required = false , defaultValue="") String query ,
			@RequestParam(required = false , defaultValue="-1") Long theme ,
			@RequestParam(required = false , defaultValue="0") Integer pageNo ,
			@RequestParam(required = false , defaultValue="8") Integer pageSize 
			){
		Collection<Map<String, Object>> result = null;
		result = searchService.searchVideos(query , theme , pageNo , pageSize);
		return result;
	}
	
}
