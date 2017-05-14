package com.express.dao.videos;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class ThemesDaoImpl extends JdbcDaoSupport implements ThemesDao{

	final static String query = "SELECT ROW_NUMBER() OVER( ORDER BY theme_id) as sl_no, * FROM index_themes ";
	@Autowired
	public ThemesDaoImpl(JdbcTemplate jdbcTemplate){
		super();
		setJdbcTemplate(jdbcTemplate);
	}

	
	@Override
	public List<Map<String, Object>> getAllThemes(){
		
		List<Map<String, Object>>result = null;
		//new ColumnMapRowMapper()
		result = getJdbcTemplate().queryForList(query +" ORDER BY theme_id " );
		
		return result;
	}
	@Override
	public List<Map<String, Object>> getAllThemes(Integer pageNo,
			Integer pageSize) {
		//paginat
		List<Map<String, Object>>result = null;
		int offset = (pageNo-1)*pageSize;
		
		//new ColumnMapRowMapper()
		//String selectQuery = query + " ORDER BY theme_id OFFSET "+offset+" ROWS FETCH NEXT "+pageSize+" ROWS ONLY;";
		String selectQuery ="SELECT * FROM ( "+query+" ) AS tbl WHERE tbl.sl_no BETWEEN ? AND ? ";
		result = getJdbcTemplate().query(selectQuery,new Object[]{offset , offset+pageSize},new ColumnMapRowMapper());
		return result;
	}


	@Override
	public Map<String, Object> getThemeById(Long theme_id) {
		Map<String, Object>result = null;
		//new ColumnMapRowMapper()
		String selectQuery = query + " WHERE theme_id = ? ";
		result = getJdbcTemplate().queryForMap(selectQuery , theme_id);
		return result;
	}
}
