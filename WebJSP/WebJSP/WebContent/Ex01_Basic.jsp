<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date day = new Date(); 
	/* 
	JSP 페이지: UI >(html + css + javascript) + (JAVA코드: JDBC >> <% 안에서 구현)
	>> 디자인 코드 + 서버 로직 코드 >> 혼재된 방식(불편하다... 특히 서버로직 불편)
	>> [결론]
	>> Servlet (Java 페이지로 web 서비스 기술) >> 디자인 작업 어려움
	>> JSP(UI)
	>> Servlet (Controller (조정: 요청 응답 처리))
	>> MVC(Model(DAO,DTO,Service)>> JAVA
		   View(UI)>> JSP,HTML
		   Controller >> Servlet)
	>> 잘하는 것만 해 >> model 2기반의 MVC패턴 (중간 프로젝트)
	
	>> JSP와 HTML의 차이점
	>> Tomcat(WAS) 처리
	>> 1. html로 구성: Web Server(클라이언트 요청... 응답)
	>> 2. jsp로 구성: WAS를 통해서 컴파일 >> 변환(text/html/script) >> 응답
	>> WAS(jsp) > compile(1.jsp.java) > 1.jsp.class > 실행 > 정적+동적 > 정적 파일 > 전달
	>> 주의 1.jsp.class 파일은 코드(java)가 변환된 경우 >> 재컴파일 >> WAS가 알아서 처리
	>> 컴파일된 코드 확인
	>> D:\tae\Git\study\WebJSP\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\WebJSP\org\apache\jsp
	Ex1_005fBasic_jsp.java/Ex1_005fBasic_jsp.class
	
	JSP 구성 요소
	1. 선언부(jsp 페이지에 대한 기본 설정 세팅)
	<% page lanuage="java" .....
	page 지시자: 사용언어, 인코딩, import 지원..
	
	2. 스크립트 요소
	2.1 스크립트릿 <% ... java코드 구현
	2.2 표현식(출력 방법) : 출력하는 대상(client 웹 브라우저) : <%= 내용을 전달
	2.3 선언부 (공통적인 자원(scope page 안에서): 공통함수 >> <%! ... 코드)
		
	*/

%>
<%!
	//java code(공통함수)
	public int add(int i, int j){
		return i+j;
	}


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= day %><hr>
	<%= add(10,20) %>
	<%
		int result=add(100,200);
	%>
	<hr>
	최종결과:<%= result %>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>