<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
  <div align="center"><h2> 상위 15개 출력  </h2>  </div> 
  <div align="center"> 
  
 <table border=1  width=700>
<tr align="center">
<th>idx</th> <th>SEQ</th><th>TITLE</th><th>WRITER</th>
 <th>REGDATE</th><th>CNT</th> 
</tr>

<c:forEach varStatus="status" var="m" items="${li}" >
	
<tr align="center">
   <td> ${status.count} </td> 
   <td> ${m.getSeq()} </td> 
   <td> 
   <a href=boardEdit.do?seq=${m.seq}>
      ${m.getTitle() }
   </a>
   </td> 
   <td> ${m.getWriter() }</td> 
   <td> ${m.getRegdate()}</td> 
   <td> ${m.getCnt()}</td> 
</tr>

</c:forEach>

</table>  

<form action="${path}/selectAll.do"  method="post">
<table >
<tr>
 <td><select name="searchCondition">
     <option value="title" > 제목  </option>
     <option value="writer" > 글쓴이  </option>
     </select> 
 </td>  
 <td> <input type=text  name="searchKeyword" > </td>
 <td> <input type=submit value="검색"> </td> 
</tr>
</table>
</form>
 
  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>