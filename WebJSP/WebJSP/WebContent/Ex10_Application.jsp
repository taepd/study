<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

/* 

	web.xml(환경설정 파일은 서버가 시작되면 가장 먼저 loading)
	<welcome-file>index.html</welcome-file>
	웹사이트 기본 페이지 설정: http://192.168.0.9:8090/WebJSP/ >>index.html (세부 파일명 표시X)

	WAS는 (웹서버는: 여러 개의 웹 어플리케이션을 서비스 할 수 있다)
	>> http://192.168.0.9:8090/WebJSP/index.html >>webAPP
	>> http://192.168.0.9:8090/Web/index.html >> webAPP
	
	/WebJSP >> 웹 프로젝트 이름/가상 디렉토리/웹 프로젝트
	실경로: D:\bit155\WebJSP\labs\WebJSP
	가상경로(웹): http://192.168.0.12:8090/WebJSP/
	
	\WebJSP 서비스하는 파일들의 기본 경로(default) >> WebContent(Context root)
	>> http://192.168.0.12:8090/WebJSP/ >>WebContent 안에 있는 파일을 서비스
	
	**우리가 만드는(서비스)하는 소스파일은(html, html, css, js, json, jsp)
	**WebContent 폴더 안에 있어야 서비스가 된다
	**WebContent >> a.jsp, b.jsp, c.jsp 3개의 페이지가 공유할 수 있는 자원?
			
	a.jsp >> <% String str="A" 		
	a.jsp >> <% String str="A" 		
	a.jsp >> <% String str="A" 	
	
	위 변수 str은 각 페이지 안이 scope이므로 충돌없이 각기 사용된다.
			
	어떤 자원은 3개의 sjp 페이지에서 모두 사용하고 싶어요
	**웹APP은 설정파일을 가진다 (web.xml)
	**web.xml: 웹 환경 설정 파일 >> 서버 시작 >> 가장 먼저 해석 실행
	**web.xml의 위치 경로 :WebContent > WEB-INF > web.xml
	
	ex) registerok.jsp >> register.html 요청해서..
	ex) http://192.168.0.12:8090/WebJSP/registerok.jsp (500 for null...)

	위와 같은 문제에 대응하기 위해 WEB-INF(보안폴더)에 xml파일 위치시킴 >> 클라이언트 접근 불가
	
	실제 프로젝트에서는 
	1. client 직접 요청하는 파일: main, login, register >> WebContent
	2. client 요청해서는 안되는 파일: WEB-INF >> views >> member >> registerok.jsp 식으로 만듬
	
	<application 객체>
	
	현재 page
	int sum =0; 현재 페이지 유효..
	
	web.xml >>사이트 전체에서 공유할 수 있는 자원 생성
	email
	FilePath
	application 객체는  환경설정 정보를 read
	
	
*/
%> 
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application 객체</title>
</head>
<body>

	<%
		String param = application.getInitParameter("email");
		out.print("<h3>"+param+"</h3>");
		
		String param2 = application.getInitParameter("FilePath");
		out.print("<h3>"+param2+"</h3>");
	
	%>


























</body>
</html>