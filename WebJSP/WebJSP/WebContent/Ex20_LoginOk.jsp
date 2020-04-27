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
ID , PWD , CHK 값 받아서

1. id, pwd 같다면 로그인 성공 (if(id.equals(pwd)...
   chk 값이 체크되어있다면
   >쿠키를 생성해서 사용자의 id값을 쿠키에 담으세요 : 유효타임(24시간)
   >쿠키 쓰기 완료
      

2. id, pwd 같다면 로그인 성공
   chk 값이 체크되어 있지 않으면
   >기존 생성했던 쿠키 삭제 :setMaxAge(0)
   
3. id ,pwd 같지 않다면
   response.sendRedirect() >> Ex20_Login.jsp       
-->

<%
	request.setCharacterEncoding("UTF-8");
	

	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	String chk=null;
	chk = request.getParameter("chk");

	
	if(uid.equals(pwd)){ //로그인 성공
		if(chk !=null){
		if(chk.equals("on")){ //쿠키 생성
			Cookie c = new Cookie("uid",uid);
			c.setMaxAge(24*60*60);
			response.addCookie(c);
		}
		}else{ //쿠키 삭제
			Cookie delco = new Cookie("uid","");
			delco.setMaxAge(0);
			response.addCookie(delco);
		}
		
	}else{
		response.sendRedirect("Ex19_Login.jsp");
		//out.print("<script>location.href='Ex19_Login.jsp'</script>"); 이것도 같은 의미 실제로 이렇게 전달됨
	}

%>
로그인 성공

</body>
</html>