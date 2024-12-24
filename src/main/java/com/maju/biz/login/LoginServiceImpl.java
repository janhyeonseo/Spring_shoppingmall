package com.maju.biz.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService  {

	@Autowired
	LoginDao  dao;
	
	@Override
	public String getSelect(LoginVO vo) {
		// TODO Auto-generated method stub
		return dao.getSelect(vo);
	}

}
