package com.maju.biz.golf;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.maju.biz.golf.rowmapper.MemberRowMapper;
import com.maju.biz.golf.rowmapper.TeacherMoneyRowMapper;
import com.maju.biz.golf.rowmapper.TeacherRowMapper;
import com.maju.biz.golf.vo.ClassVO;
import com.maju.biz.golf.vo.MemberVO;
import com.maju.biz.golf.vo.MoneyVO;
import com.maju.biz.golf.vo.TeacherVO;

@Repository
public class GolfDaoImpl implements GolfDao  {
	
	public GolfDaoImpl(){
		System.out.println("===> GolfDaoImpl 생성자 확인 ");
	}
	
	@Autowired
	private SqlSessionTemplate  mybatis;
	
	
	@Override
	public List<TeacherVO> TeacherList(TeacherVO vo) {	
		vo.setSearchKeyword("%"+ vo.getSearchKeyword() +"%");
		return mybatis.selectList("Golf.TeacherList",vo);
	}

	@Override
	public List<MemberVO> memberList() {		
		return mybatis.selectList("Golf.MemberList");
	}

	@Override
	public List<MoneyVO> teacherMoney() {		
		return mybatis.selectList("Golf.TeacherMoney");
	}

	@Override
	public void enrolMent(ClassVO vo) {
		mybatis.insert("Golf.Insert", vo);		
		
	}

	@Override
	public TeacherVO teacherDetail(TeacherVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("Golf.teacherDetail", vo);
	}

	@Override
	public void TeacherEvaluationInsert(TeacherVO vo) {
		mybatis.insert("Golf.TeacherEvaluationInsert", vo);
		
	}

	@Override
	public List<TeacherVO> TeacherEvaluationSelect(TeacherVO vo) {
		return mybatis.selectList("Golf.TeacherEvaluationSelect", vo);
	}

}
