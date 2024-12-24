package com.maju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maju.biz.board.BoardService;
import com.maju.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService  service;
	
	@GetMapping(value="boardForm.do")
	  String boardForm() {
	 return "board/insert";		
	}
	

	@GetMapping(value="boardInsert.do")
	  String boardInsert( BoardVO vo ) {

		 service.insert(vo);
		
	 return "redirect:selectAll.do";		
	}
		
	
	@GetMapping(value="bigInsert.do")
	  String bigInsert( BoardVO vo ) {
		for (int i = 0 ; i < 1500 ; i++) {
			
			vo.setTitle("제목1" + i);
			vo.setWriter("글쓴이70" + i);
			vo.setContent("글내용90" + i);	
		    service.bigInsert(vo);   	
		}
	 return "redirect:selectTop.do";		
	}
	
	@RequestMapping(value="selectTop.do")
	  String selectAll(Model  model , BoardVO vo ) { 
			  
	  model.addAttribute("li", service.selectTop(vo));		

	 return "board/selectTop";		
	}
	
	
	
	@GetMapping(value="boardUpdate.do")
	 String boardUpdate( BoardVO vo ) {		
		service.update(vo);   			
	 return "redirect:selectAll.do";		
	}
	
	@GetMapping(value="boardDelete.do")
	  String boardDelete( BoardVO vo ) {		
		service.delete(vo);   			
	 return "redirect:selectAll.do";		
	}
	
	
	@RequestMapping(value="selectAll.do")
	  String selectAll(@RequestParam(value="searchCondition", defaultValue="title", required=false) String Condition
	                  , @RequestParam(value="searchKeyword", defaultValue="", required=false)  String Keyword 
	                   ,Model model, BoardVO   vo ) { 
				  
	int pageSize = 10;
	int pageListSize = 10;
	int startInt  = 0;
	
	if (vo.getStart() == 0) {
		startInt = 1 ;
	} else {
		startInt = vo.getStart();
	}
	
	 BoardVO  m  = service.totalCount(Condition, Keyword);	
	  
	  int tc  = m.getTc() ;
	  int totalPage =(int)(Math.ceil(tc / (double) pageSize ));
	  int nowPage =   startInt  / pageSize   + 1  ;
	  int lastPage  = ( totalPage - 1 ) * pageSize + 1;

	  int listStartPage = (nowPage - 1) / pageListSize * pageListSize + 1;
	  int listEndPage = listStartPage + pageListSize - 1 ;
	  
	  int  endPage = (totalPage - 1) * pageSize + 1 ; 
	  
	  vo.setSearchKeyword(Keyword);
	  vo.setSearchCondition(Condition);
	  vo.setStart( startInt );
	  vo.setEnd(startInt + pageSize - 1);
	  
	  model.addAttribute("searchKeyword", vo.getSearchKeyword());
	  model.addAttribute("searchCondition", vo.getSearchCondition());
	  
	  model.addAttribute("li", service.getSelectAll(vo));
	  	  
	  model.addAttribute("totalCount", tc);	
	  model.addAttribute("pageSize", pageSize);
	  model.addAttribute("pageListSize", pageListSize);
	  model.addAttribute("start", startInt);
	  
	  model.addAttribute("totalPage", totalPage);	
	  model.addAttribute("nowPage", nowPage);	
	  model.addAttribute("lastPage", lastPage);	
	  model.addAttribute("listStartPage", listStartPage);	
	  model.addAttribute("listEndPage", listEndPage);	
	  
	  model.addAttribute("endPage", endPage);	
	
	 return "board/list";		
	}
	

	@GetMapping(value="boardEdit.do")
	  String boardEdit( Model model, BoardVO vo ) { 			  
	  model.addAttribute("m", service.getSelectOne(vo));		
		
	 return "board/edit";		
	}
	
}
