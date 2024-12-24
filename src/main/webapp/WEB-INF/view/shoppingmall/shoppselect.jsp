<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
 <div> </div>
 <div align="center">
 <table  border=1 width=700 >
 <thead>
 <tr align="center">
 <th> 순번 </th><th >상품번호 </th>  <th  >상품이름</th>
 <th> 상품가격  </th> <th> 배송비  </th><th> 사진  </th>
 </tr>
 </thead>
<c:if test="${li.size() == 0}">
	<tr><td colspan=5 align="center"> 레코드가 존재 하지 않습니다. </td> </tr>
</c:if>
<c:if test="${li.size() != 0}">

	<c:forEach var="m"  items="${li}" >
	<c:set var="idx" value="${idx=idx+1}" />
	<tr> 
	<td>  ${idx}  </td>
	<td>  ${m.pid}  </td> 
	<td>  <a href=shoppingEdit.do?pid=${m.pid} > ${m.pname} </a>  </td> 
	<td>  ${m.pprice}  </td> 
	<td>  ${m.pbaesongbi}  </td>
	<td align="center"> ${m.pimgStr}   
	<img src=${path}/shoppingmall/img/${m.pimgStr} width=50 height=50 >  </td> 

	</tr>
	</c:forEach>
</c:if>
</table>
</div>
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>