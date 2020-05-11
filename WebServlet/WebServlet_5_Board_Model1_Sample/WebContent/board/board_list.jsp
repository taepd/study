<%@page import="kr.or.bit.dto.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="<%=request.getContextPath()%>/style/default.css" />
</head>
<body>
	<c:import url="/include/header.jsp" />
	<%
		BoardService service = BoardService.getInBoardService();
	
		out.print("전체 게시물 건수: "+service.totalBoardCount()+"<br>");
		out.print("게시물 리스트: " + service.list(1, 5));
		
		List<Board> list = service.list(1, 5);
		
		for(Board board : list){
			out.print(board.getIdx()+"/"+board.getSubject()+"/"+board.getWriter()+"<br>");
		}
	
	%>
	
	
	
	
	
</body>
</html>
















