package com.maju.biz.golf;

import java.util.List;

import com.maju.biz.golf.vo.ClassVO;
import com.maju.biz.golf.vo.MemberVO;
import com.maju.biz.golf.vo.MoneyVO;
import com.maju.biz.golf.vo.TeacherVO;

public interface GolfDao {
	List<TeacherVO> TeacherList(TeacherVO vo);
	List<MemberVO>  memberList();
	List<MoneyVO>   teacherMoney();   
	TeacherVO teacherDetail(TeacherVO vo)  ; 
	void  enrolMent(ClassVO vo);
	
	void TeacherEvaluationInsert(TeacherVO vo );
	List<TeacherVO> TeacherEvaluationSelect(TeacherVO vo);
	
}
