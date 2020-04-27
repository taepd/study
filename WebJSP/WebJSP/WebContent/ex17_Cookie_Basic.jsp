<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
정보(데이터) > 어디에 저장

클라이언트(개인 로컬 pc 브라우저) : 서버(웹서버 or DB서버)

정보(데이터, 자료) >> 어디에 저장(보관)?

고민: 보안 요소(정보의 중요성), 소멸(일시적/영속적)

Client (Local PC: 웹 브라우저)
1. Cookie(메모리 쿠키, 파일쿠키(loval txt파일 저장: 암호화)
2. Local Storage(저장소: key, value)

Server(WebServer: Tomcat)
1. server memory : session 객체(접속한 사용자 식별값, 개인정보, 접속시간) >> 서버꺼지거나, 리부팅되면 소멸(영속적이지 않음)
2. server momory: Apllication 객체(접속한 모든 사용자가 공유하는 객체) >> 서버꺼지거나, 리부팅되면 소멸(영속적이지 않음)
3. server 영속적: 파일 >> login.txt >> 영속 >> 관리가 힘들어요
4. DB server: 보안, 영속 관리 편하다
 -->

<%
	Cookie mycookie = new Cookie("cname","1004");
	//생성
	//만든 쿠키를 Client 브라우저 전달 >> response
	response.addCookie(mycookie);

%>

<a href="Ex17_Cookie.Read.jsp">Cookie read</a><br>
서버에서 설정한 쿠키 이름: <%= mycookie.getName() %><br>
서버 설정한 값: <%=mycookie.getValue() %><br>
서버 설정한 쿠키 소멸설정: (session 소속: -1): <%=mycookie.getMaxAge() %><br>














</body>
</html>