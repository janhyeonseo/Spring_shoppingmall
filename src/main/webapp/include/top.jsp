<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="path" scope="session" 
       value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마주스토리</title>
<link  href="${path}/include/css/top.css"  rel="stylesheet" type="text/css" />
<style type="text/css">
        nav a {
            text-decoration: none;
            color: white;
            font-weight: bold;
        }
</style>

</head>
<body>

<header> 마주스토리 골프 회원관리 프로그램  </header>
<nav > &emsp;&emsp;

&emsp;<a href="${path}/teacherList.do"> 강사조회 </a> 
&emsp;&emsp;<a href="${path}/enrolMent.do"> 수강신청 </a> 
&emsp;&emsp;<a href="${path}/memberList.do"> 회원정보조회 </a> 
&emsp;&emsp;<a href="${path}/teacherMoney.do"> 강사매출현황 </a> 
&emsp;&emsp;&emsp;<a href="${path}/index.jsp">홈으로</a> 

<c:if test="${empty id}">
&emsp;&emsp;<a href="${path}/login.do"> 로그인 </a> 
</c:if>

<c:if test="${not empty id}">
&emsp;&emsp;<a href="${path}/logout.do"> ( ${id} ) 로그아웃 </a> 
&emsp;&emsp;<a href="${path}/shoppingmall.do"> shoppingmall </a> 
</c:if>

&emsp;&emsp;<a href="${path}/selectAll.do"> 방명록보기 </a> 

<c:if test="${Test == '100'}">
&emsp;&emsp;<a href="${path}/boardForm.do"> 게시판글등록 </a> 
&emsp;&emsp;<a href="${path}/selectAll.do"> 게시판목록보기 </a> 
&emsp;&emsp;<a href="${path}/bigInsert.do"> 빅데이터추가 </a> 
&emsp;&emsp;<a href="${path}/selectTop.do"> 게시판목록보기 </a> 
</c:if>

</nav>