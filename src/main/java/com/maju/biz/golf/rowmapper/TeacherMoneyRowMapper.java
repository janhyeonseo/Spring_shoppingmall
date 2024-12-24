package com.maju.biz.golf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maju.biz.golf.vo.MoneyVO;

public class TeacherMoneyRowMapper implements RowMapper<MoneyVO> {

	@Override
	public MoneyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MoneyVO m =new MoneyVO();
		m.setT1(rs.getString("T1"));
		m.setT2(rs.getString("T2"));
		m.setT3(rs.getString("T3"));
		m.setT4(rs.getInt("T4"));
		return m;
	}

}
