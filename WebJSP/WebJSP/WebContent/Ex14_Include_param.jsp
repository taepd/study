<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	String userid = request.getParameter("userid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	type:<%=type%><br>
	userid:<%=userid %><br>
	<jsp:include page="Ex14_param.jsp">
		<jsp:param name="hobby" value="baseball" />
		<jsp:param name="pwd" value="1004" />
	
	</jsp:include>

</body>
</html>