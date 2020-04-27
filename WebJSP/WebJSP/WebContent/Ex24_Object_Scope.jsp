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
Tomcat 제공(WAS) 기본적인 내장 객체
1. request(요청: 클라이언트 정보)
2. response(응답: 특정 페이지 이동, 정보 출력, 쿠키 쓰기)
3. application(전역객체: web.xml 자원 read, 전역자원)
4. session(접속한 사용자(브라우저) 고유하게 부여되는 객체, 고유한 변수)
5. out(out.print())

session 객체
[내부에 session 변수 생성]
scope: a.jsp(session.setAt.. "member"변수 생성)
	   b.jsp(session.getAt.. "member" read 가능)
session 변수는 (현재 WebContent 폴더 안에 있는 모든 페이지에서 사용가능)
Life-cycle: 1. session 변수는 session 객체와 동일(sessionID 소멸)
			2. 서버 리부팅, session.invaildate() ...

application 객체
[내부에 application 변수 생성: 전역변수 >> 모든 session이 공유가능 >> 접속하는 모든 사용자]
scope: (현재 WebContent 폴더 안에 있는 모든 페이지에서 사용가능) >> java >>static
Life-cycle : 서버 리부팅 시 소멸

+

request 객체
[request 변수]: request.setAttribute("type","A");
scope: 요청 페이지(login.jsp -> request 객체 >> scope >> 생성된 page)
예외적으로
login.jsp(include, forward) request객체는 그 페이지에 공유된다******


 -->
<%
	Emp emp =new Emp();
	emp.setEmpno(2000);
	emp.setEname("홍길동");
	
	session.setAttribute("empobj",emp);
	
	//다른 페이지 가정(member.jsp)
	Emp e = (Emp)session.getAttribute("empobj");
	out.print(e.getEmpno()+"<br>");
	out.print(e.getEname()+"<br>");
	
	//request
	request.setAttribute("who", "king"); //scope>> 생성된 페이지
	String who = (String)request.getAttribute("who");
	out.print("who"+who);
	
	//<jsp:include page="b.jsp"></jsp:include>
	//<jsp:forward page="b.jsp"></jsp:forward>
	
	//b.jsp
	//session.getAttribute("empobj") >> 가능
	//request.getAttribute("who") >>가능
	

%>




























</body>
</html>