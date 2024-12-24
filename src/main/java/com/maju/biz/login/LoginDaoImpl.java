package com.maju.biz.login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao  {

	
	@Autowired
	private SqlSessionTemplate  mybatis;
	
	@Override
	public String getSelect(LoginVO vo) {
		System.out.println("vo확인:" + vo);
		
		int k = mybatis.selectOne("Login.SelectOne", vo);
		System.out.println("K확인:" + k);
		
		String P ="";
		if (k == 1) {
			P = "T";
		}else {
			P = "F";
		}		
		return P ;
	}

}
