<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servelt TEST</title>
</head>
<body>
	<h3>servelt 요청하기</h3>
	<h3>getContextPath(): <%=request.getContextPath() %></h3>
	<!-- getContextPath() >> /WebServlet_1 -->
	<a href="<%=request.getContextPath() %>/simple">일반 요청하기</a>
	<br>
	<a href="<%=request.getContextPath() %>/simple?type=date">날짜 요청하기</a>
	<br>
	<a href="<%=request.getContextPath() %>/simple?type=abcd">비정상 요청하기</a>
	<br>
	<hr>
	<h3>FrontBoardController 사용하기</h3>
	<a href="<%=request.getContextPath() %>/board?cmd=boardlist">게시판 목록보기</a>
	<br>
	<a href="<%=request.getContextPath() %>/board?cmd=boardwrite">게시판 글쓰기</a>
	<br>
	<a href="<%=request.getContextPath() %>/board">Error 유도하기</a>
	<br>
	<a href="<%=request.getContextPath() %>/board?cmd=boarddelete">게시판 삭제하기</a>
	<br>
	<a href="<%=request.getContextPath() %>/board?cmd=login">페이지 보안 (로그인)</a>
	<hr>
	<h3>FrontServletController 사용하기</h3>
	<a href="<%=request.getContextPath() %>/action.do?cmd=greeting">요청 보내기</a>
	<br>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>