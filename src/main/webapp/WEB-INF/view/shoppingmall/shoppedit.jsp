<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
  <div> </div> 
    <div align="center"> 
	<h2> 상품 구매하기  </h2>
	<form name="f1"   action="${path}/shoppingCart.do"  method="post"  >

	<table border="1" width=600 >
	<tr align=> <td class="td1" width=20%  align="center"> 상품번호  </td>
	     <td>&emsp;<input  type=text  name=pid  value="${m.pid}" readonly />  </td>
	     <td rowspan=4> <img src=${path}/shoppingmall/img/${m.pimgStr} width=100 height=150 > </td> </tr>
	<tr> <td class="td1"  align="center"> 상품이름  </td>
	     <td >&emsp;<input  type=text  name=pname size=40 value="${m.pname}"  readonly />  </td></tr>
	<tr> <td class="td1"  align="center"> 상품가격  </td>
	     <td>&emsp;<input  type=text  name=pprice value="${m.pprice}"  readonly />  </td></tr>
	<tr> <td class="td1"  align="center"> 배송비  </td>
	     <td>&emsp;<input  type=text  name=pbaesongbi value="${m.pbaesongbi}"  readonly />  </td></tr>     
	     
	<tr> <td class="td1"  align="center"> 상품상세  </td>
	     <td  colspan=2>&emsp;<textarea  cols=50  rows=4 name=pdesc>${m.pdesc}</textarea>   </td></tr>
	<tr> <td class="td1"  align="center"> 구매수량  </td>
	     <td  colspan=2>&emsp;<input  type=text  name=amount >   </td></tr>

	<tr> <td colspan=3 align="center" >
	       <input  type=submit  value="상품구매" /> &emsp;
	      </td>
	</tr>

</table>
</form>
</div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>