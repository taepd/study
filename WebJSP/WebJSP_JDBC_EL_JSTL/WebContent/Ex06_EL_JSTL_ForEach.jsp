<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.bit.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL for</h3>
	<!-- 
		JAVA
		int sum=0;
		for(int i=0;i<=10;i++){
			sum+=1;
		}
		for(String s : list){}
	 -->
	<c:forEach var="i" begin="1" end="10">
		<c:set var="sum" value="${sum+i}"/>
		${i}<br>
	</c:forEach>
	sum 누적값 : ${sum}<br>
	
	<h3>구구단</h3>
	<c:forEach var="i" begin="1" end="9">
		<li>5*${i}=${5*i}</li>
	</c:forEach>
	<hr>
	
	<table border="1">
		<c:forEach var="i" begin="2" end="9">
			<c:forEach var="j" begin="0" end="9">
				<c:choose>
					<c:when test="${j==0}">
						<tr bgcolor="yellow"><th>${i}단</th></tr>
					</c:when>
					<c:otherwise>
						<tr><td>${i}*${j}=${i*j}</td></tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:forEach>
	</table>
	
	<h3>JSTL forEach 출력하기</h3>
	<%
		int[] arr = new int[]{10,20,30,40,50};
		for(int i : arr){
			out.print("출력값:<b> "+i+"</b><br>");
		}
	%>
	<h3>EL JAVA 객체에 직접 접근 불가능 [JSTL 변수에 데이터 담은 후에...]</h3>
	arr 객체[배열]접근 불가 : ${arr}<br>
	<c:set var="arr" value="<%=arr %>"/>
	c:set 변수에 접근: ${arr}<br>
	<hr>
	<h3>JAVA 개선된 for문(JSTL 개선 >> items)</h3>
	<c:forEach var="i" items="${arr}">
		배열값: ${i}<br>
	</c:forEach>
	
	<h3>단순하게 편하게</h3>
	<c:forEach var="i" items="<%=arr %>">
		배열값2: ${i}<br>
	</c:forEach>
	
	<h3>재미삼아서</h3>
	<c:forEach var="i" items="<%=new int[]{10,20,30,40,50} %>">
		배열값3: ${i}<br>
	</c:forEach>
	
	<h3>forEach 활용하기2</h3>
	<h5>varStatus를 사용하면, index, count,length등을 추출할 수 있음</h5>
	<c:forEach var="i" items="${arr}" varStatus="status">
		index:${status.index} &nbsp;&nbsp;&nbsp;
		count:${status.count} &nbsp;&nbsp;&nbsp;
		value:${i} &nbsp;&nbsp;&nbsp;
		<br>	
	</c:forEach>
	<hr>
	<h3>Today Point(모르면 게시판 못 만들어요^^)</h3>
	<%
		List<Emp> emplist = new ArrayList<>();
		emplist.add(new Emp(1000,"A"));
		emplist.add(new Emp(2000,"B"));
		emplist.add(new Emp(3000,"C"));
		
		//출력
		for(Emp e : emplist){
			out.print(e.getEmpno()+"/"+e.getEname()+"<br>");
		}
	%>
	
	<h3>JSTL 출력하세요</h3>
	<c:set var="list" value="<%=emplist%>"/>
	<table border="1">
		<tr><td>사번</td><td>이름</td></tr>
		<c:forEach var="e" items="${list}">
			<tr><td>${e.empno}</td><td>${e.ename}</td></tr>
		</c:forEach>
	</table>
	
	<!-- c:set구문 사용하지 말고 출력하세요 -->
	<h3>JSTL 출력하세요2</h3>
	<c:set var="list" value="<%=emplist%>"/>
	<table border="1">
		<tr><td>사번</td><td>이름</td></tr>
		<c:forEach var="emp" items="<%=emplist%>">
			<tr><td>${emp.empno}</td><td>${emp.ename}</td></tr>
		</c:forEach>
	</table>
	<h3>JSTL 사용 Map 다루기</h3>
	<%
		Map<String, Object> hm = new HashMap<>();
		hm.put("name", "hong");
		hm.put("pwd", "1004");
		hm.put("date", new Date());
	%>
	<h3>Java Map 객체 EL&JSTL 사용 출력하기(key, value)</h3>
	<c:set var="hm" value="<%=hm %>"/>
	<c:forEach var="obj" items="${hm}">
		${obj.key} ->${obj.value}<br>	
	</c:forEach>
	(key)name: ${hm.name}<br>
	(key)pwd: ${hm.pwd}<br>
	(key)date: ${hm.date}<br>
	
	<h3>JSTL 구분처리</h3>
	<c:forTokens var="token" items="A.B.C.D" delims=".">
		${token}<br>
	</c:forTokens>
	
	<h3>JSTL 복합구분처리</h3>
	<c:forTokens var="token" items="A.B/C-D" delims="./-">
		${token}<br>
	</c:forTokens>
	
	<!-- 
		step이 마이너스 값을 사용할 수 없다
		step = -1 편법적으로 사용
	 -->
	<c:set var="nownum" value="10"/>
	<c:forEach var="i" begin="0" end="${nownum}" step="1">
		${nownum-i}<br>
	</c:forEach>
	
	<select>
	<c:forEach var="i" begin="0" end="${2016-1900}">
		<c:set var="yearOption" value="${2016-i}"/>
		<option value="${yearOption}">${yearOption}</option>
	</c:forEach>
	</select>

</body>
</html>