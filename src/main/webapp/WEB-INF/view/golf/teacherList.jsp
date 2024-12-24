<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<section>
<br>
  <div align="center"> 
  <div  style="border: solid black 2px; width:795px;height:400px;"	 id="map" ></div>
   
<table border=1  width=800>
<tr align="center"> <th>강사코드</th><th>강사명</th><th>강의명</th>
                    <th>수강료(원)</th><th>강사자격취득일</th><th>강사주소</th> </tr>
<c:forEach  var="m" items ="${li}" >
	
	<tr align="center">
	   <td> ${m.getTEACHER_CODE() } </td> 
	   <td> <a href=${path}/teacherDetail.do?TEACHER_CODE=${m.TEACHER_CODE}>${m.getTEACHER_NAME()}</a></td> 
	   <td> ${m.getCLASS_NAME() }</td> 
	   <td> &#8361; ${m.getCLASS_PRICE() }</td> 
	   <td> ${m.getTEACHAR_REGIST_DATE()} </td> 
	   <td> ${m.getAddr() }</td> 
	</tr>
</c:forEach>

</table>
 
 <form action="${path}/teacherList.do">
 <select name=searchCondition >
  <option value="TEACHER_CODE" > 강사코드 </option>
  <option value="TEACHER_NAME" > 강사이름 </option>
  <option value="addr" > 강사주소 </option>
 </select>
 <input  type=text  name=searchKeyword>
 <input  type=submit  value="검색하기" > 
 </form>
 
  </div> 
<br> 
</section>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=108fd5969e1c36f2b7cbd5a913507317&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {             
        center: new kakao.maps.LatLng(37.5665851, 126.9782038), // 지도의 중심좌표
        level: 9 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

<c:forEach var="m"  items="${li}">	

    geocoder.addressSearch('${m.addr}', function(result, status) {
        	
    	// 정상적으로 검색이 완료됐으면
        if (status === kakao.maps.services.Status.OK) {
         
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
          
          // 결과값으로 받은 위치를 마커로 표시합니다
          var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
          });

          // 인포윈도우를 생성합니다
          var infowindow = new kakao.maps.InfoWindow({
              content: '<div style="width:150px;text-align:center;padding:6px 0;"><a href=${path}/teacherDetail.do?TEACHER_CODE=${m.TEACHER_CODE}>'  + '${m.TEACHER_NAME}' + '</a></div>',
              removable : true
          });
              
          // 마커에 클릭이벤트를 등록합니다

          kakao.maps.event.addListener(marker, 'click', function() {
                // 마커 위에 인포윈도우를 표시합니다
                infowindow.open(map, marker);  
          });
     
	    } 
	});
</c:forEach>

</script>
<%@ include file="/include/bottom.jsp" %>