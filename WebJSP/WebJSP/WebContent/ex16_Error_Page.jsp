<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
404: 요청페이지 없는 것
500: 서버쪽 코드 문제 > 0으로 나누는 것, null 처리 연산, 함수

 -->


<%
	String data = request.getParameter("name").toLowerCase();

%>

전달받은 내용<%= data %>
</body>
</html>