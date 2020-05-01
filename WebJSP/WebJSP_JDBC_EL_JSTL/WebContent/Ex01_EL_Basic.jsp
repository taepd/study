<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("userid");

	request.setAttribute("name", "korea");
	session.setAttribute("user", "bit");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	EL(출력 표현식): JSP 페이지에서 사용되는 스크립트 언어(화면출력)
	이유: 스파게티(% 부분과 html 혼재되는 코드) >> 유지보수, 코드의 해석(가독성) 떨어짐
	     이 문제를 해결(개선)하기 위해서[html과 잘 어울려야 되고 서버쪽 코드 출력] Script개발
	     >>EL&JSTL (단점: JSP 페이지에서만 사용가능)
	EL: JSP 페이지에서 화면 출력 목적으로 만든 script 언어(%=없이 살자) 
	
	EL 기본 객체
	param        :  요청 파라미터의 <파라미터이름, 값> 매핑을 저장한 Map 객체
	paramValues  :  요청 파라미터의 <파라미터이름, 값배열> 매핑을 저장한 Map 객체
	requestScope :  request 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체
	sessionScope :  session 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체
	applicationScope : application 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체
 -->

스크립트릿:<b><%=id %></b><br>
스크립트릿:<%= request.getAttribute("name") %><br>
스크립트릿:<%= session.getAttribute("user") %><br>
parameter: <%= request.getParameter("uesrid") %>
<hr>
EL parameter : ${param.userid}<br>
EL request value: ${requestScope.name}<br>
EL request value: (requestScope 객체명 생략): ${name}<br>
EL session value: ${sessionScope.user}<br>
EL request value: (sessionScope 객체명 생략): ${user}<br>


<h3>EL 기본 문법(출력)</h3>
스크립트릿 <%=100+200 %><br>
EL : ${100+200}<br>
EL : ${"1"+1}<br><!-- 문자형 숫자(자동 형변환) >> 숫자 >>결과:2-->
EL : ${1==1}<br> 
EL : ${false}<br>
EL : ${!false}<br>
EL : ${empty x}<br> <!-- x라는 변수의 값이 비어있는지 여부 -->

</body>
</html>