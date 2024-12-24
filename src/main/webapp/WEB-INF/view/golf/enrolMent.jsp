<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<Script>
 function  fn_function1(){
	// alert("확인");
	f1.C_NO.value = f1.C_NAME.value;
 }
 
  // 회원번호가 2000 번 이상이면 50% 할인된 수강료가 자동으로 계산.
  function  fn_function2(){
	// 수강료 
	price = f1.TEACHER_CODE.value * 1000;	
	if (f1.C_NO.value >= 20000) {
		price = price * 0.5
	}	
	f1.TUITION.value = price;	
 }
 
 function ck1(){
	 if (f1.REGIST_MONTH.value=="") {
		 alert("수강월을 입력해주세요");
		 f1.REGIST_MONTH.focus();
		 return false;
	 }else if(f1.CLASS_AREA.value==""){
		 alert("강의장소를 입력해주세요");
		 f1.CLASS_AREA.focus();
		 return false; 
	 }
 }
 
</Script>

<section>
<br>
  <div align="center"><h2> enrolMent ( 수강신청 ) </h2>  </div> 
  <div align="center"> 
   
<form name="f1"  action="enrolMent.do"  method="post"   onSubmit="return ck1()">

<table border=1>
<tr> <td>수강월 </td> <td><input type=text name="REGIST_MONTH" > 예) 2022년03월 -> 202203  </td> </tr>
<tr> <td>회원명 </td> 
     <td>
     <select name="C_NAME" onChange="fn_function1()">
       <option value="">회원명 </option>
       <c:forEach var="m"  items="${member}">
         <option value="${m.getC_NO()}">${m.getC_NAME()} </option>
	   </c:forEach>
     </select>
     </td> 
</tr>
<tr> <td>회원번호 </td> <td><input type=text name="C_NO" readonly > 예) 10001 </td> </tr>
<tr> <td>강의장소 </td> <td> <input type=text name="CLASS_AREA" ></td> </tr>
<tr> <td>강의명 </td> 
    <td>
    <select name="TEACHER_CODE" onChange="fn_function2()" >
       <option value="">강의신청 </option>
       <c:forEach var="m"  items="${teacher}">
         <option value="${m.getTEACHER_CODE()}"> ${m.getTEACHER_NAME()} </option>
	   </c:forEach>
     </select>
    </td> 
</tr>
<tr> <td>수강료 </td> <td><input type=text name="TUITION"  readonly> 원 </td> </tr>
<tr> <td colspan=2 align="center">
     <input  type=submit value="수강신청"> &emsp;
     <input  type=reset value="다시쓰기">
     </td> 
</tr>
</table>
</form>
 
  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>