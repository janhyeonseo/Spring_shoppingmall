<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
 <div align="center"> <h2> 주문서 목록보기 </h2> </div>
 <div align="center">

 <form action="${path}/orderInsert.do" method="post" >

 <table  border=1 width=700>
 <thead>
 <tr align="center">
 <th  width=100> idx </th>  <th  width=100> orderG </th>
 <th  width=100>mid </th> <th  width=100>TEACHER_NAME </th>  
 <th  width=150> amount  </th> <th  width=150> today  </th> 
 </tr>
 </thead>
<c:if test="${li.size() == 0}">
	<tr><td colspan=8 align="center"> 레코드가 존재 하지 않습니다. </td> </tr>
</c:if>
<c:if test="${li.size() != 0}">

	<c:forEach var="m"  items="${li}" >
	<c:set var="idx" value="${idx=idx+1}" />
	<tr  align="center"> 
	<td> ${idx} </td>   </td>
	
	<td> <a href=${path}/orderListDetail.do?orderG=${m.orderG}> ${m.orderG} </a>    </td>
		
	<td> ${m.mid}   </td><td> ${m.TEACHER_NAME}   </td>
	<td align=right> ${m.amount}   </td>
	<td> ${m.today}   </td>
	</tr>
	</c:forEach>
	   
</c:if>

</table>

</form>
</div>
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>