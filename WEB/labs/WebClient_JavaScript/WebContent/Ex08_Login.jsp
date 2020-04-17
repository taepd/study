<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//name="txtuserid"
//name="txtpwd" id="txtpwd"
//Ex08_Login.jsp?txtuserid=hong&txtpwd=1004
	String id = request.getParameter("txtuserid");
	String pwd = request.getParameter("txtpwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버 전송 완료^^ 처리 중 <br>
<%= id %> <br> <!--%!: 선언/  %=:출력(response)/ %--: 주석  -->
<%= pwd %>
</body>
</html>