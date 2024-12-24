package com.maju.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.maju.biz.login.LoginService;
import com.maju.biz.login.LoginVO;

@Controller
public class LoginController {
	
	@Autowired
	LoginService  service;
	
	@Autowired
	HttpSession  session;
	
	@GetMapping(value="login.do")
	  String login() { 
		
	 return "login/login";		
	}
	
	@GetMapping(value="logout.do")
	  String logout() { 
		
		session.invalidate();
		
	 return "redirect:/login.do";		
	}
	
	
	@PostMapping(value="login.do")
	  String loginOK(LoginVO vo ) {	
		
	 String	S= service.getSelect(vo);
	 if (S.equals("T")) {
		 if (vo.getPwd().equals("1234")) {
			 // 로그인 성공
			 session.setAttribute("id", vo.getId());	
			 return "redirect:/index.jsp";	
		 }else {
			return "redirect:/login.do" ;
		 }
	 } else {
		 return "redirect:/login.do" ;
	 }	
	}
	
	
}
