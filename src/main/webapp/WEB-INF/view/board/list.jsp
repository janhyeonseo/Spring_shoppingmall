<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
  <div align="center"><h2> 방명록 보기 </h2>  </div> 
  <div align="center"> 
	1.페이지 사이즈 : ${pageSize} &emsp;&emsp;
	2.페이지 List사이즈(아래숫자갯수) : ${pageListSize}&emsp;&emsp;
	3.전체레코두 수 : ${totalCount}&emsp;&emsp;
	4.총페이지수 : ${totalPage}  <br>
	5.현재레코드 : ${start}&emsp;&emsp;
	6.현재페이지 : ${nowPage}&emsp;&emsp;
	7.가로하단 시작 :${listStartPage}&emsp;&emsp;
	8.가로 하단 마지막 : ${listEndPage}

  
 <table border=1  width=700>
<tr align="center">
 <th>SEQ</th><th>TITLE</th><th>WRITER</th>
 <th>REGDATE</th><th>CNT</th> 
</tr>

<c:forEach  var="m" items="${li}" >
	
<tr align="center">
   <td> ${m.getSeq()} </td> 
   <td> ${m.getTitle() } </td> 
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
  
 <c:url  value="selectAll.do"  var="url">
   <c:param name="searchCondition"  value="${searchCondition}"   />
   <c:param name="searchKeyword"  value="${searchKeyword}"   />
 </c:url>
 
 <a href="${url}&start=1">처음으로</a> &emsp;
 
 <c:if test="${listStartPage > pageListSize}">
   <c:set var="start"  value="${(listStartPage - pageListSize -1) * pageSize  + 1}" />
   <a href="${url}&start=${start}">이전${pageListSize}페이지</a> &emsp;
</c:if>

<c:if test="${listStartPage <= pageListSize }">
   이전${pageListSize}페이지&emsp;
</c:if>

<c:forEach var="i" begin="${listStartPage }"  end="${listEndPage}"  >
  <c:set var="start"  value="${(i-1) * pageSize + 1}" />
     <c:if test="${i <= totalPage}">   
       [<a href="${url}&start=${start}">${i}</a>]  
     </c:if>
</c:forEach>


<c:if test="${listEndPage < totalPage}">
   <c:set  var="start" value="${listEndPage * pageSize + 1}" />
   &emsp;<a href="${url}&start=${start}">다음${pageListSize}페이지</a> &emsp;
 </c:if>
 
  <c:if test="${ listEndPage >= totalPage }">
   &emsp;다음${pageListSize}페이지 &emsp;
 </c:if>   

 <c:set var="start"  value="${endPage}"   />
 <a href="${url}&start=${start}">마지막으로 </a>

  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>