<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//EL: 출력 담당하는 script(서버쪽 자원) >> <%= 대체
	//EL 사용한다고 해서 모든 Java객체를 지원하는 것은 아니다
	Date today = new Date();
	request.setAttribute("day", today);
	session.setAttribute("day2", today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>EL의 목적은 화면 출력</h3>
	<%= request.getAttribute("day") %><br>
	EL(습관 들이기) : ${requestScope.day}<br>
	EL : ${day}<br>
	Session EL : ${sessionScope.day2}<br>
	
</body>
</html>