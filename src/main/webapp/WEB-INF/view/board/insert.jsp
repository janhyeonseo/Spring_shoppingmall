<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>


<section>
<br>
  <div align="center"><h2> 게시판 저장하기 </h2>  </div> 
  <div align="center"> 
   
<form name="f1"  action="boardInsert.do" >

<table border=1>
<tr> <td>제목 </td> <td><input type=text name="title" > </td> </tr>
<tr> <td>작성자 </td> <td><input type=text name="writer" > </td> </tr>
<tr> <td>글내용 </td> <td> <textarea cols=60  rows=5 name="content" ></textarea></td> </tr>
<tr> <td colspan=2 align="center">
     <input  type=submit value="저장하기"> 
     <input  type=reset value="다시쓰기">
     </td> 
</tr>
</table>
</form>
 
  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>