package com.maju.biz.shoppingmall;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GolfproductVo {
  private  String pid   ;
  private  String pname   ;
  private  String pprice   ;
  private  String pbaesongbi   ;
  private  String pdesc   ;
  private  String pimgStr   ;
  private  MultipartFile pimg   ;
}
