<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//로그아웃(sessionID에 해당하는 session객체 소멸)
	session.invalidate(); //server객체 소멸
	out.print("<script>location.href='Ex23_Session_Login.jsp'</script>");
	
	//session.removeAttribute("memberid");  //객체 안에 있는 특정 자원만 소멸
	

%>

</body>
</html>