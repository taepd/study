<%@page import="java.util.HashMap"%>
<%@ page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- import와 같은 기능 prefix는 축약어 -->
<%
	Emp e = new Emp();
	e.setEmpno(2000);
	e.setEname("bituser");
	
	HashMap<String, String> hp = new HashMap<>();
	hp.put("data", "1004");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

기존방식: <%= e %><br>
기존방식: <%= e.getEmpno() %><br>
기존방식: <%= e.getEname() %><br>

<h3>EL (출력)</h3>
자바객체 출력하기(객체에 대한 직접 접근 불가): ${e }<br>
자바객체 속성 출력하기: ${e.getEname() }<br>

1. JSTL (core) : 변수 생성, 제어문<br>
<c:set var="m" value="<%=e %>"></c:set>
JSTL을 사용해서 변수 m을 생성(e 객체의 주소값): ${m}<br>
<hr>
EL 출력: JSTL 변수값을 출력: ${m}<br>
EL 출력: JSTL 변수(가능하지만 잘 안씀): ${m.getEmpno()}<br>
EL 출력: JSTL 변수(자동 getter 함수 호출)(m.member field명) :${m.empno}<br>
EL 출력: JSTL 변수(자동 getter 함수 호출)(m.member field명) :${m.ename}<br>
<hr>
<h3>EL & JSTL 사용하기</h3>
****** EL을 통해서 Java 객체에 대한 직접 접근 불가 ******<br>
****** JSTL set 구문을 사용해서 변수 생성 > 이용 ******<br>
**1. EL: parameter값 받기 (param)<br>
**2. 객체(requsetScope, sessionScope)가지고 있어서 <br>
	request객체, session객체가 가지고 있는 값을 출력<br>
c:set 태그의 값으로 EL구문이 올 수 있다: <c:set var="username" value="${m.ename}"></c:set>
변수값 출력: ${username}<br> 
<hr>
<h3>JSTL 변수 만들고 scope 정의하기</h3>
<c:set var="job" value="농구선수" scope="request"></c:set>
당신의 직업은: ${job}<br>
scope: request > 만약에 당신이 [include],[forward]를 한 페이지가 있다면 그 페이지에서도 job을 사용할 수 있다.
<br>
<c:set var="job2" value="야구선수" scope="request"/> 
값 출력<br>
${job2}<br>
변수 삭제 기능(거의 안씀)<br>
<c:remove var="job2"/><br>
job2 변수 삭제(에러나지 않고 출력이 안됨): ${job2}<br>
<hr>
hp객체(객체 직접 접근 불가): ${hp}<br>
<c:set var="vhp" value="<%=hp %>"/>
hp객체: ${vhp}<br>
hp객체: ${vhp.data}<br>


<!-- 
	hp.put("color", "red")
 -->
객체 값 넣기 (가능하지만 잘 안씀) 
<c:set target="${vhp}" property="color" value="red"/>
hp객체: ${vhp}<br>



























</body>
</html>