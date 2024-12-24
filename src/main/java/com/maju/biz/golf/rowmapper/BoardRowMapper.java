package com.maju.biz.golf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper   implements RowMapper<HashMap<String, Object>>  {

	@Override
	public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 HashMap<String, Object> map = new HashMap<String, Object>() ;
		 map.put("seq", rs.getInt("seq"));
		 map.put("title", rs.getString("title"));
		 map.put("writer", rs.getString("writer"));
		 map.put("content", rs.getString("content"));
		 map.put("regdate", rs.getString("regdate"));
		 map.put("cnt", rs.getInt("cnt"));
		return map;
	}

}
