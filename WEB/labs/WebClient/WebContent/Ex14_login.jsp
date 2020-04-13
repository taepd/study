<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//JAVA 코드(back단 코드: 서버에서 동작(컴파일)되는 코드)
	//목적지 주소(Form action="Ex14_login.jsp")
	//클라이언트가 가지고 있는 데이터를 받아서 처리
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("userpwd");
	
	//실제 로그인 처리
	//JDBC 사용 >>DB 연결 >> select .. >> 회원여부 판단 >> 클라이언트 응답
			

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h3>당신이 입력한 데이터</h3>
	ID: <%=userid %><br>   <!-- 퍼센트는 자바 코드 영역 의미'='은 서버의 응답이라는 표현 -->
	PWD: <%=pwd %><br>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>