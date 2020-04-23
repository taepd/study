<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 한글처리(페이지 상단에)
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id"); //클라이언트 ip를 가져온다
	
	/* 
		WAS 내장 request 객체 사용
		[jsp 파일에서는 default로 내장객체를 선언없이 사용 가능]
				
		request객체(요청 객체)
		1. 요청 페이지당 한 개의 request 객체 생성****
		2. 클라이언트의 정보를 서버에서 read(request)
		
		request 내장 객체는 클라이언트에서 서버로 요청할 때 생성되는
		HttpServletRequest 타입을 갖는 객체가 자동 생성되고 그 주소를 request가 참조
		HttpServletRequest request = ...코드...		
		
	 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

ID: <%= id %><hr>
접속한 클라이언트 IP : <%= request.getRemoteAddr() %><br>  <!--접속한 클라이언트 IP : 192.168.0.9  -->

서버(요청한 방식 : 인코딩) <%= request.getCharacterEncoding() %><br>  <!-- 서버(요청한 방식 : 인코딩) UTF-8 -->

전송방식: <%=request.getMethod() %><br>

포트: <%=request.getServerPort() %><br>

context root(홈 디렉토리, 가상디렉토리, 웹 경로):<%=request.getContextPath() %><br>

<!-- 
	request.getContextPath()
	가상경로(웹 경로): /WebJSP
	실경로: D:\bit155\WebJSP\Labs\WebJSP
	
	http://192.168.0.9:8090/WebJSP/Ex04_request.jsp
	/WebJSP 서비스 하는 내용: D:\bit155\WebJSP\Labs\WebJSP\WebContent

	파일 업로드(실경로로 해야 함) >> 웹 경로(가상이므로) >> 실경로화 필요

 -->
현재 파일 경로: <%=request.getRequestURI()%><br>







</body>
</html>