package com.maju.biz.golf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maju.biz.golf.vo.MemberVO;

public class MemberRowMapper  implements RowMapper<MemberVO> {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO m =new MemberVO();
		m.setREGIST_MONTH(rs.getString("REGIST_MONTH"));
		m.setC_NO(rs.getString("C_NO"));
		m.setC_NAME(rs.getString("C_NAME"));
		m.setCLASS_NAME(rs.getString("CLASS_NAME"));
		m.setCLASS_AREA(rs.getString("CLASS_AREA"));
		m.setTUITION(rs.getInt("TUITION"));
		m.setGRADE(rs.getString("GRADE"));
		return m;
	}

}
