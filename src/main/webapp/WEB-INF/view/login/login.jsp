<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>


<section>
<br>
  <div align="center"><h2> LOGIN  </h2>  </div> 
  <div align="center"> 
   
<form name="f1"  action="login.do"  method="post" >

<table border=1>
<tr> <td> 아이디 </td>
     <td><input type=text name="id" > </td> </tr>
<tr>     
     <td> 암호 </td> <td><input type=text name="pwd" > </td> </tr>
<tr> <td colspan=2 align="center">
     <input  type=submit value="로 그 인"> &emsp;
     <input  type=reset value="다시쓰기">
     </td> 
</tr>
</table>
</form>
 
</div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>