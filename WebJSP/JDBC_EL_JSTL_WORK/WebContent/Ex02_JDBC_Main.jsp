<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS 추가 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- 사용자 CSS 추가 -->
<link rel="stylesheet" href="./css/common.css">

<!-- pure CSS 추가 -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.1/build/pure-min.css"
	integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47"
	crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">

<link rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">





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

body {
	background-color: white;
}

.bottom{
	text-align: center; 
	background-color: #343a40;
	border-top: #ffffff 2px solid;
	color: white;	
}

#main {
	display:flex;

}

.nav a {
	color:white;
	text-decoration: none;
	 
}

.nav a:hover{
	color: gray;
}






/* * { */
/*     border: 1px solid black; */
/* } */
</style>
</head>




<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">


	<div class="container">
		<section>
			<div class="top">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</div>
		</section>





				<div id="main">
				<div class="col-4" style="background-color: #343a40;" id="left">
					<jsp:include page="/common/Left.jsp"></jsp:include>
				</div>

				<div class="col-8" style="text-align:center; margin:0px; padding:200px; background-color:gray" >
					
					<!-- MAIN PAGE CONTENT  -->
					<%
						String id = null;
						id = (String) session.getAttribute("userid");

						if (id != null) {
							//회원
							out.print(id + " 회원님 방가방가^^<br>");
							if (id.equals("admin")) {
								out.print("<a href='Ex03_Memberlist.jsp'>회원관리</a>");
							}
						} else {
							//로그인 하지 않은 사용자
							//메인 페이지는 회원만 볼수 있어요 (강제 링크 추가)
							out.print("사이트 방문을 환영합니다 ^^ <br>회원가입 좀 하지 ...");
						}
					%>
					
				</div>
				</div>





		<section>
			<div class="bottom">
				<jsp:include page="/common/Bottom.jsp"></jsp:include>
			</div>
		</section>

	</div>



	<script src="https://kit.fontawesome.com/880ed703ab.js"
		crossorigin="anonymous"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/jquery.timepicker.min.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>
</body>
</html>


