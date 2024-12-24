package com.maju.biz.board;

import lombok.Data;

@Data
public class BoardVO {
  private  int  seq ;
  private  String  title ; 
  private  String  writer ; 
  private  String  content ;	
  private  String  regdate ;	
  
  private  int  cnt ;
  
  private  String  searchCondition;
  private  String  searchKeyword;
  
  private  int  tc ;
  
  private  int  start ;
  private  int  end ;
  
  private  int pageSize ;
  private  int pageListSize ;
  private  int totalPage ;
  private  int idx;
  private  int nowPage ;
  private  int listStartPage ;
  private  int listEndPage ;  
  
}
