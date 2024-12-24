<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>


<section>
<br>
  <div align="center"><h2> 게시판 상세보기 </h2>  </div> 
  <div align="center"> 
   
<form name="f1" >
<input type=hidden name="seq" value="${m.seq}" >
<table border=1>
<tr> <td>제목 </td> <td><input type=text name="title" value="${m.title}" > </td> </tr>
<tr> <td>작성자 </td> <td><input type=text name="writer"  value="${m.writer}" > </td> </tr>
<tr> <td>글내용 </td> <td> <textarea cols=60  rows=5 name="content" >${m.content}</textarea></td> </tr>
<tr> <td colspan=2 align="center">
     <input  type=submit value="수정하기" 
             onClick="JavaScript:f1.action='boardUpdate.do'"> 
             
     <input  type=submit value="삭제하기" 
             onClick="JavaScript:f1.action='boardDelete.do'">
     </td> 
</tr>
</table>
</form>
 
  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>