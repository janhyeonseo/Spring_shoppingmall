# Spring기반 웹 쇼핑몰 서비스
### 💡 서비스 개요
- 쇼핑몰의 제품 관리와 결제 처리, 고객 관리 기능을 제공하는 웹 서비스.
- 사용자 인증 로그인 기능, 게시판 관리, 카카오 결제 시스템 통합 등의 기능을 구현. 
- 각 기능은 MVC 패턴을 기반으로 구현됨.
### 🛠️ 기술 스택
</div>
    <div style="text-align: left;">
    <div> <img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white">
          <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white">
          <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Security&logoColor=white">
          <img src="https://img.shields.io/badge/Jsp-607396?style=flat-square&logo=Jsp&logoColor=white">
          <img src="https://img.shields.io/badge/Mybatis-003496?style=flat-square&logo=Mybatis&logoColor=white">
          <img src="https://img.shields.io/badge/OpenAPI-004596?style=flat-square&logo=OpenAPI&logoColor=white">
          <br>
          <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=flat-square&logo=Javascript&logoColor=white">
          <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white">
          <img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white">
          <img src="https://img.shields.io/badge/Oracle-F80000?style=flat-square&logo=Oracle&logoColor=white">
          <img src="https://img.shields.io/badge/Github-181717?style=flat-square&logo=Github&logoColor=white">
          </div>
    </div>
<br>

## 주요 기능 및 역할

### 📝 Kakao 결제 API
- Kakao 결제 API를 활용하여 결제 처리 기능을 구현.
- 결제 성공 및 실패에 따른 리디렉션 처리.

### 📝 쇼핑몰 관리
- MyBatis를 사용하여 상품 정보 등을 데이터베이스에서 처리.
- `BoardCountRowMapper`, `TeacherRowMapper` 등의 RowMapper 클래스를 활용하여 SQL 쿼리 결과를 객체로 변환하는 기능을 제공.
- CRUD, 검색, 장바구니 및 결제 기능 구현.

### 📝 로그인 및 사용자 인증
- `LoginDao` 클래스를 사용하여 사용자 인증 및 로그인 기능을 처리.
- Spring Security를 통해 안전한 로그인 구현.


