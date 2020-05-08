<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.or.bit.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = new Member();
	//json 객체 형태(문자열)로 만들어서 보내고 싶다
	//String jsondata = "{" + "username:" + member.get ...
	//위처럼 무식하게 하지 않아도
	JSONObject obj = JSONObject.fromObject(member);
	//자동으로 JSON 객체문자열 생성
	//{"address":"서울시 강남구","admin":"1","password":"1004","username":"bit"}
%>

<%=obj %>
<hr>
<%
	List<Member> memberlist = new ArrayList<>();
	memberlist.add(new Member("hong","1004","서울시 강남구","0"));
	memberlist.add(new Member("kim","1004","서울시 양천구","1"));
	memberlist.add(new Member("park","1111","경기도 성남시","1"));
	
	JSONArray objarray = JSONArray.fromObject(memberlist);
%>
<%=objarray %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>