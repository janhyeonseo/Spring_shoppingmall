package com.maju.biz.golf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;

public class BoardCountRowMapper   implements RowMapper<Integer>   {

	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer	count = rs.getInt("tc");
		return count;
	}

}
