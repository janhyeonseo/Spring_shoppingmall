<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>
<script>
  function Update(){
	  f1.action="${path}/cartUpdate.do"
      f1.submit();  
  }
  
  function cartDelone(cid){
	  alert("cid:" + cid)
	  location.href="${path}/cartDeleteOne.do?cart_id="+cid
  }

</script>

<section>
<br>
 <div align="center"> <h2> 장바구니 목록 </h2> </div>
 <div align="center">

 <form action="${path}/PaymentServlet.do"  method="post"  name="f1">

 <table  border=1 width=750 >
 <thead>
 <tr align="center">
 <th> idx </th><th> pname </th><th> pprice </th><th> pimg </th>
 <th> cart_id </th><th >mid </th> 
 <th  >pid</th> <th> amount  </th> <th > del </th> 
 </tr>
 </thead>
<c:if test="${li.size() == 0}">
	<tr><td colspan=8 align="center"> 레코드가 존재 하지 않습니다. </td> </tr>
</c:if>
<c:if test="${li.size() != 0}">

	<c:forEach var="m"  items="${li}" >
	<c:set var="idx" value="${idx=idx+1}" />
	<tr> 
	<td> ${idx}    </td>
	<td> ${m.pname}  </td>
	<td> ${m.pprice} </td>
	<td> <img src="${path}/shoppingmall/img/${m.pimg}" width=50  height=50 >    </td>
	<td> <input type=text  name=cart_id value="${m.cart_id}" size=6 >    </td>
	<td> <input type=text  name=mid value="${m.mid}"  size=6  >    </td>
	<td> <input type=text  name=pid value="${m.pid}"  size=6  >    </td>
	<td> <input type=text  name=amount value="${m.amount}"  size=6  >    </td>
	
	<td> <input  type="checkbox" onChange="cartDelone(${m.cart_id})" >   </td>
	
	</tr>
    <c:set var="Pay" value="${Pay = m.pprice * m.amount}" />
    <c:set var="totalPay" value="${totalPay = totalPay + Pay}" />
	</c:forEach>
	
    <tr><td colspan=9 align="center"> 
    총 결제금액 :   <input  type=text  name=total_amount value="${totalPay}"  readonly >
    &emsp;&emsp;   <input type=submit value="주문하기" >
    <input type=button value="수정하기" onClick="Update()"  >
      </td> </tr>
</c:if>

</table>

</form>
</div>
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>