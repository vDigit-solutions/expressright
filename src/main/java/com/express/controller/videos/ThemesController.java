package com.express.controller.videos;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.express.service.videos.ThemesService;

@RestController("themes")
@RequestMapping("themes")
@CrossOrigin
public class ThemesController {
	
	@Autowired
	ThemesService themesService;

	@RequestMapping
	public List<Map<String, Object>> getAllThemes(@RequestParam Integer pageNo , @RequestParam Integer pageSize){
		List<Map<String, Object>> result = null;
		result = themesService.getAllThemes(pageNo , pageSize);
		return result;
	}
	@RequestMapping("all")
	public List<Map<String, Object>> getAllThemes(){
		List<Map<String, Object>> result = null;
		result = themesService.getAllThemes();
		return result;
	}
	
	@RequestMapping("{theme_id}")
	public Map<String, Object> getThemeById(@PathVariable("theme_id") Long theme_id){
		Map<String, Object> result = null;
		result = themesService.getThemeById(theme_id);
		return result;
	}
}
