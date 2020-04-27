<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	/*
		요청에 대한 흐름 제어
		
		include
		forward
		
		공통점: request 객체를 공유한다
		차이점: include: 제어권 가지고 있다
			   forward 제어권을 넘겨준다(Point: 요청 주소는 동일한데 다른 Page의 내용을 서비스)
			   why? 처음 요청했던 주소의 Buffer를 그대로 사용
			   192.168.0.9:8090/WebJSP/login.jsp.... forward >>A.jsp, B.jsp, C.jsp
			      담는 그릇은 login.jsp이지만 내용은 A.jsp, B.jsp, C.jsp 중에 하나일 수 있다
			      
			   http://192.168.0.9:8090/WebJSP/ex15_foward_main.jsp?code=C
 	*/
 	String code = request.getParameter("code");
	String viewURI= null;
	if(code.equals("A")){
		viewURI="/forward/A.jsp";
	}else if(code.equals("B")){
		viewURI="/forward/B.jsp";
	}else if(code.equals("C")){
		viewURI="/forward/C.jsp";
	}
	


%>    
    
<jsp:forward page="<%=viewURI %>"></jsp:forward>

<!-- 아래 코드가 의미가 있을까???? -->
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	나는 forward 페이지입니다.

</body>
</html>