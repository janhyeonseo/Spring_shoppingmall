package com.maju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.maju.biz.golf.GolfService;
import com.maju.biz.golf.vo.ClassVO;
import com.maju.biz.golf.vo.TeacherVO;

@Controller
public class GolfController {
	
	@Autowired
	private GolfService  service;
	
	GolfController(){
	  System.out.println("===> GolfController 생성자 ");	
	}

	@RequestMapping(value="test.do")
	  String test() {
		System.out.println("===> test Mapping  ");	
	 return "golf/test";		
	}
	
	@RequestMapping(value="teacherList.do")
	  String teacherList( Model  model , TeacherVO vo) {
		model.addAttribute("li", service.TeacherList(vo) );	
	 return "golf/teacherList";		
	}
	
	@GetMapping(value="enrolMent.do")
	  String enrolMent( Model  model, TeacherVO vo ) {
		
		model.addAttribute("teacher", service.TeacherList( vo ) );
		model.addAttribute("member", service.memberList() );
		
	 return "golf/enrolMent";		
	}
	
	@PostMapping(value="enrolMent.do")
	  String enrolMentSave( ClassVO  vo ) {
				
	   service.enrolMent(vo);	
		
	 return "redirect:/index.jsp";		
	}
	
	
	@RequestMapping(value="memberList.do")
	  String memberList( Model  model) {
		System.out.println("===> memberList Mapping  ");	
		model.addAttribute("li", service.memberList() );		
	 return "golf/memberList";		
	}
	
	@RequestMapping(value="teacherMoney.do")
	  String teacherMoney( Model  model) {
		System.out.println("===> teacherMoney Mapping  ");	
		model.addAttribute("li", service.teacherMoney() );		
	 return "golf/teacherMoney";		
	}
	
	
	@RequestMapping(value="TeacherMap.do")
	String TeacherMap( Model  model , TeacherVO vo) {
		System.out.println("===> TeacherMap Mapping  ");	
		model.addAttribute("mapli", service.TeacherList(vo) );		
	 return "golf/teacherMap";		
	}
	
	
	@RequestMapping(value="teacherDetail.do")
	String teacherDetail( Model  model , TeacherVO vo  ) {
		System.out.println("===> teacherDetail Mapping  ");	
		model.addAttribute("m", service.teacherDetail(vo) );
		model.addAttribute("li", service.TeacherEvaluationSelect(vo) );		
	 return "golf/teacherDetail";		
	}
	
	@RequestMapping(value="TeacherEvaluation.do")
	String TeacherEvaluation( Model  model , TeacherVO vo  ) {
		System.out.println("===> TeacherEvaluation Mapping  ");	
		service.TeacherEvaluationInsert(vo);
		
	 return "redirect:teacherDetail.do?TEACHER_CODE="+vo.getTEACHER_CODE();		
	}
	
}
