<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
  <div align="center"><h2> 강사매출현황 </h2>  </div> 
  <div align="center"> 
   
<table border=1  width=700>
<tr align="center">
 <th>강사코드</th><th>강의명</th>
 <th>강사명</th><th>총매출</th> </tr>
 
<c:forEach  var="m" items ="${li}" >
	
	<tr align="center">
	   <td> ${m.getT1() } </td> 
	   <td> ${m.getT2() }</td> 
	   <td> ${m.getT3()  }</td> 
	   <td> ${m.getT4()  }</td> 
	</tr>
</c:forEach>

</table>

  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>