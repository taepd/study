<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="kr.or.bit.Member"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
	/*  
	 1.관리자만 접근 가능한 페이지
	 2.로그인한 일반 회원이 주소값을 외워서 ... 접근불가 
	 3.그러면  회원에 관련되 모든 페이지 상단에는 아래 코드를 ..... : sessionCheck.jsp >> include 
	*/
	 if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){
		//강제로 페이지 이동
		//out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
		response.sendRedirect("Ex02_JDBC_Login.jsp");
	} 


%>	


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
			<!--  
				회원 목록(리스트) 출력
				목록 (select id, ip from koreamember)
			-->	
				<%
						Connection conn = null;
											PreparedStatement pstmt = null;
											ResultSet rs = null;
											try{
												conn = Singleton_Helper.getConnection("oracle");
												String sql="select id, ip from koreamember";
												pstmt = conn.prepareStatement(sql);
												rs = pstmt.executeQuery(); 
												
												
											List<Member> list = new ArrayList<>();
											
											while(rs.next()){
												Member m = new Member();
												m.setId(rs.getString("id"));
												m.setIp(rs.getString("ip"));
														
												list.add(m);
											 }
					%>
					
                    <c:set var="list" value="<%=list %>"/>
					<table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto">
							<tr><th colspan="4">회원리스트</th></tr>
						
						<c:forEach var="m" items="${list}">
						<tr>
								<td width="100px">
										<a href='Ex03_MemberDetail.jsp?id=${m.id}'>${m.id}</a>
								</td>
								<td width="100px">${m.ip}</td>
								<td>
									<a href="Ex03_MemberDelete.jsp?id=${m.id}">[삭제]</a>
								</td>
								<td>
									<a href="Ex03_MemberEdit.jsp?id=${m.id}">[수정]</a>
								</td>
							</tr> 
						</c:forEach>
 				   </table> 
					
					<hr>
						<form action="Ex03_MemberSearch.jsp" method="post">
							회원명:<input type="text" name="search">
							<input type="submit" value="이름검색하기">
						</form>
					<hr>					
				<%	
					}catch(Exception e){
						
					}finally{
						Singleton_Helper.close(rs);
						Singleton_Helper.close(pstmt);
					}
				%>
			
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>