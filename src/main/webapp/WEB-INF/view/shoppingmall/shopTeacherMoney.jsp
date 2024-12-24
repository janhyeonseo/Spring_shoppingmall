<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<%@ include file="/include/top.jsp" %>

<style>
  table{    width:800px;  height: 250px; }  
  .td1 {
    height: 40px; /* td의 높이를 이미지의 높이에 맞게 조정 */    
  }
  
  #img1{
   display:block; margin:auto;
   height: 50px;  width:50px;
  }
  

  .hidden-table {
            display: none;
  }
  
</style>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script> 
<script src="http://code.highcharts.com/modules/data.js"></script>    

<section>
<br>
<div id="container" style="width: 800px; height: 400px; margin: 0 auto;"></div>

<div align="center"> 

<table  border=1 width="800" id='datatable1' class="hidden-table" >
<tr align="center">
 <th>강사명</th><th>쇼핑금액</th> </tr>
 
<c:forEach  var="m" items ="${li}" >
<tr class=td1> 
 <td> ${m.TEACHER_NAME }</td> 
 <td> ${m.amount}</td> 
</tr>
</c:forEach>
</table>
</div> 
<br>
<script>
$(document).ready(function() { 
   var data = {
      table: 'datatable1'
   };
   var chart = {
      type: 'column'
   };
   var title = {
      text: '강사별 쇼핑몰 매출'   
   };      
   var yAxis = {
      allowDecimals: false,
      title: {
         text: '쇼핑금액'
      }
   };
   var tooltip = {
      formatter: function () {
         return '<b>' + this.series.name + '</b><br/>' +
            this.point.y + ' ' + this.point.name.toLowerCase();
      }
   };
   var credits = {
      enabled: false
   };  
      
   var json = {};   
   json.chart = chart; 
   json.title = title; 
   json.data = data;
   json.yAxis = yAxis;
   json.credits = credits;  
   json.tooltip = tooltip;  
   $('#container').highcharts(json);
});
</script>
 
<div align="center">    
<table border=1  width=700  height=250>
<tr align="center">
 <th>강사코드</th><th>강사명</th>
 <th>강의명</th><th>쇼핑금액</th> </tr>
 
<c:forEach  var="m" items ="${li}" >
	
	<tr align="center">
	   <td> ${m.TEACHER_CODE } </td> 
	   <td> ${m.TEACHER_NAME }</td> 
	   <td> ${m.CLASS_NAME  }</td> 
	   <td align=right> 
	      <fmt:formatNumber value="${m.amount}" type="number" pattern="#,###"/>   
	  </td> 
	</tr>
</c:forEach>

</table>

  </div> 
<br> 
</section>

<%@ include file="/include/bottom.jsp" %>