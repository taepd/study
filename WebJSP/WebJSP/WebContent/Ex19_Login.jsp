<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//요구사항 : uid 쿠키가 존재하면  input type=text name=uid 
//value값에 cookie 보여주고 싶어요
	String userid="";
	Cookie[] cookies = request.getCookies();
	if(cookies == null){
		response.sendRedirect("Ex19_Login.jsp");
	}else{
		for(int i = 0 ; i < cookies.length ; i++){
			if(cookies[i].getName().equals("uid")){
				userid= cookies[i].getValue();
			}
		}
	}

%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
 /* 주의 사항 : 문자열 처리 하기 */
 console.log(userdata);
 //let data = document.getElementById("uid");
 //data.value=userdata
</script>
</head>
<body>
	<form action="Ex20_LoginOk.jsp" method="get">
		ID:<input type="text" id="uid" name="uid" value="<%=userid%>"><br> <!-- value에 %코드를 넣는 방법과 아래 스크립트문으로 처리하는 방법 2가지 존재 -->
		PWD:<input type="password" name="pwd"><br>
		<hr>
		ID값 유지하기<input type="checkbox" name="chk">
		<hr>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">	
	</form>
	

<!-- 
<script type="text/javascript">
 /****** 주의 사항 : 문자열 처리 하기 *********/
 var userdata = '<%=userid%>';
 let data = document.getElementById("uid");
 data.value=userdata;
</script>
-->
</body>
</html>
