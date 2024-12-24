package com.maju.biz.golf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maju.biz.golf.vo.TeacherVO;

public class TeacherRowMapper implements RowMapper<TeacherVO> {

	@Override
	public TeacherVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeacherVO	m = new TeacherVO();
		m.setTEACHER_CODE(rs.getInt("TEACHER_CODE"));
		m.setTEACHER_NAME(rs.getString("TEACHER_NAME"));
		m.setCLASS_NAME(rs.getString("CLASS_NAME"));
		m.setCLASS_PRICE(rs.getInt("CLASS_PRICE"));
		m.setTEACHAR_REGIST_DATE(rs.getInt("TEACHAR_REGIST_DATE"));
		return m;
	}

}
