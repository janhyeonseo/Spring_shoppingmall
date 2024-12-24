<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/top.jsp" %>
<style type="text/css">
  a {      
      text-decoration: none;
      color: black;
      font-weight: bold;
 }
 
 .font1{
   font-size:1.5em;
 }
</style>
<section>
<br>
  <div> </div> 
  <div align="center" class="font1"> 
   <br><br>
   <a href="${path}/shoppingInsert.do" >1. 상품등록</a> <br>   
   <a href="${path}/shoppingSelect.do">2. 상품목록</a> <br>   
   <a href="${path}/cartList.do?mid=${id}">3 .장바구니</a><br>   
   <a href="${path}/orderList.do">4.주문목록보기</a><br>   
   <a href="${path}/shopTeacherMoney.do">5.강사별쇼핑현황</a><br>
   <a href="${path}/TeacherMap.do">6.강사별주소(지도)</a><br>
 
  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>