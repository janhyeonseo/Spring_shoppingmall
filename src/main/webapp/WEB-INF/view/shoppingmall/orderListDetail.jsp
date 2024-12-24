<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
 <div align="center"> <h2> 주문서 상세보기 </h2> </div>
 <div align="center">
 <font size=4>
  구매자명 : ${name} , &emsp; 구매자코드: ${code} , &emsp; 구매자 클래스 : ${className}
 </font>
 <table  border=1 width=900>
 <thead>
 <tr align="center">
 <th  width=100> idx </th>  <th  width=100> orderG </th>
 <th  width=100> 상품명</th>  
 <th  width=150> 상품수량  </th>  <th  width=150> 상품가격  </th> <th  width=150> 구매가격  </th> 
 <th  width=150> today  </th> 
 </tr>
 </thead>

	<c:forEach var="m"  items="${li}" >
	<c:set var="idx" value="${idx=idx+1}" />
	<tr  align="center"> 
	<td> ${idx} </td>   
	<td> ${m.orderG}     </td>
	
	<td> ${m.pname}     </td>
	<td> ${m.amount}     </td>
	<td align=right> ${m.pprice}   </td>
	<td align=right> ${m.pprice * m.amount }   </td>
	<c:set var="total"  value="${m.pprice * m.amount }" />
	<c:set var="totalPay" value="${ totalPay + total}" />
	<td> ${m.today}   </td>
	</tr>
	</c:forEach>

</table>
 전체 구매금액 : ${totalPay}
</div>
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>