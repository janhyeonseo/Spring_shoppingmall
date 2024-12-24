package com.maju.biz.golf.vo;

import lombok.Data;

@Data
public class TeacherVO {
  private	int idx   ;
  private	int TEACHER_CODE ;
  private	String TEACHER_NAME;
  private   String CLASS_NAME;
  private	int CLASS_PRICE;
  private	int TEACHAR_REGIST_DATE;
  private	int  amount;
  private	String addr ;
  private	String Evaluation  ; 
  private	int rating ;
  private	String today ;
	
  private	String searchCondition;
  private	String searchKeyword;
}
