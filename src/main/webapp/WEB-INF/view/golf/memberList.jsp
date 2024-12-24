<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
  <div align="center"><h2> 회원 수강 등록 정보조회 </h2>  </div> 
  <div align="center"> 
  
 <table border=1  width=700>
<tr align="center">
 <th>수강월</th><th>회원번호</th><th>회원명</th>
 <th>강의명</th><th>강의장소</th><th>수강료</th><th>등급</th> </tr>

<c:forEach  var="m" items="${li}" >
	
<tr align="center">
   <td> ${m.getREGIST_MONTH() } </td> 
   <td> ${m.getC_NO() }</td> 
   <td> ${m.getC_NAME() }</td> 
   <td> ${m.getCLASS_NAME()}</td> 
   <td> ${m.getCLASS_AREA()}</td> 
   <td> ${m.getTUITION() }</td> 
   <td> ${m.getGRADE() }</td> 

</tr>

</c:forEach>

</table>
  
 
  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>