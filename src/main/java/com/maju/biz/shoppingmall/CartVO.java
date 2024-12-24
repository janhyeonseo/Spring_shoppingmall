package com.maju.biz.shoppingmall;

import lombok.Data;

@Data
public class CartVO {
   private  int cart_id; 
   private  String mid;
   private  String pid;
   private  int  amount;  
   
   private String pname; 
   private int pprice ;
   private String pimg ;
}
