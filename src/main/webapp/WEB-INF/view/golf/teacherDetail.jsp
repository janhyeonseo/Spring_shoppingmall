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

	
	<tr align="center">
	   <td> ${m.getTEACHER_CODE() } </td> 
	   <td> ${m.getTEACHER_NAME()} </td> 
	   <td> ${m.getCLASS_NAME() }</td> 
	   <td> &#8361;
	   <fmt:formatNumber value="${m.getCLASS_PRICE() }" type="number" groupingUsed="true" />
	 </td> 
	   <td>
	    <c:set var="dateString" value="${m.getTEACHAR_REGIST_DATE()}" />
	    <fmt:parseDate var="parsedDate" value="${dateString}" pattern="yyyyMMdd" />
	    <fmt:formatDate value="${parsedDate}" pattern="yyyy년 MM월 dd일" />
	    </td> 
	   <td> ${m.getAddr() }</td> 
	</tr>

</table>

  <form action = "${path}/TeacherEvaluation.do">
  <table border=1  width=800 >
  <tr align="center"><td width=600 >강&emsp;의&emsp;평</td><td width=100> 강 의 점 수 </td><td width=100> 입력 </td></tr>
  <tr>
  <td>
  <input type=hidden  name=TEACHER_CODE  value="${m.getTEACHER_CODE() }" > 
  <input type=text  name=Evaluation  size=80 > 
  </td>
  <td>
  <input type=text  name=rating  size=10 >
  </td>
  <td> 
  <input type=submit  value="저장하기"  >
  </td>
  </tr>
  </table> 
  </form>
 
 <table border=1  width=800>
 <tr align="center"> <th>순번</th><th>강사코드</th><th>평가내용</th>
                    <th>평점</th><th>날짜</th> </tr>
	<c:forEach  var="m"  items="${li}">
	<tr align="center">
	   <td> ${m.idx } </td> 
	   <td> ${m.TEACHER_CODE} </td> 
	   <td> ${m.getEvaluation() }</td> 
	   <td> ${m.rating }</td> 
	   <td> ${m.today }</td> 
	</tr>
    </c:forEach>
</table>

 
 
 
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
              content: '<div style="width:150px;text-align:center;padding:6px 0;">'  + '${m.TEACHER_NAME}' + '</div>',
              removable : true
          });
              
          // 마커에 클릭이벤트를 등록합니다

          kakao.maps.event.addListener(marker, 'click', function() {
                // 마커 위에 인포윈도우를 표시합니다
                infowindow.open(map, marker);  
          });
     
	    } 
	});

</script>
<%@ include file="/include/bottom.jsp" %>