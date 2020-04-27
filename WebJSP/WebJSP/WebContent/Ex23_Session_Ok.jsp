<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//한글처리
	request.setCharacterEncoding("UTF-8");

	//데이터 받기
	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	
	//확인하기
	out.print(uid+"/"+pwd);
	
	//로직(비지니스) 업무 처리
	//DB 연결 > select > 회원테이블 > id, pwd 존재
	//지금은 id, pwd 같으면 회원 인정
	boolean success = false;
	if(uid.equals(pwd)){
		//로그인 성공
		//****** session 객체 안에 변수를 만들어서 ID담기
		session.setAttribute("memberid", uid);
		success= true;
	}

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if(success==true){
		out.print("<b>로그인 성공</b><br>");
		String user = (String)session.getAttribute("memberid");  //session객체 안에는 다양한 타입의 정보가 저장되므로 object타입으로 받는다
		out.print(user+"님 로그인 되었습니다<br>");
		out.print("<a href='Ex23_Session_Member.jsp'>회원전용</a>");
	}else{
%>		
	<script type="text/javascript">
		alert("다시 로그인해 주세요");
		//location.href="Ex23_Session_Login.jsp" (권장)
		window.history.go(-1); //방문했던 사이트에서 바로 전 페이지로 보내기 (비권장)
	</script>	
<%		
	}
%>









</body>
</html>