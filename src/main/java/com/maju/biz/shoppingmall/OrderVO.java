package com.maju.biz.shoppingmall;

import lombok.Data;

@Data
public class OrderVO {
  private  int     idxOrder ;
  private  String  orderG ;
  private  String  cart_id ;
  private  String  mid ;
  private  String  pid ;
  private  int     amount ;
  private  String  today ;
  
  private  String TEACHER_NAME ;
}
