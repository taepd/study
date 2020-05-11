<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Connection Pool</title>
</head>
<body>
<%
	Connection conn = null;
	
	Context context = new InitialContext(); //현재 프로젝트에서 이름을 기반으로 검색할 수 있는 객체(like 윈도우 탐색기 >> 특정 단어 검색)
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  //java:comp/env(default이름) + jdbc/oracle(내가 만든 이름)
	
	//대여소(pool)안에서 connection 빌리고 반납
	conn = ds.getConnection(); //대여
	
	//연결여부 확인
	out.print("db 연결여부: "+ conn.isClosed()+"<br>");
	
	//반드시 (반납) pool connection 반환
	conn.close(); //반환(pool에선 연결을 끊는게 아니라 반환하는 명령이 close())
	
	//연결여부 확인
	out.print("db 연결여부: "+ conn.isClosed()+"<br>");
%>

</body>
</html>