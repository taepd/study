<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
	<h2>로그인</h2>
	<h3 class="hidden">방문페이지 로그</h3>
	<ul id="breadscrumb" class="block_hlist clear">
		<li>HOME</li>
		<li>회원가입</li>
		<li>로그인</li>
	</ul>
	<h3 class="hidden">회원가입 폼</h3>
	<div id="join-form" class="join-form margin-large">
		
		<!-- 로그인 시 에러가 발생하면... url > /login?error -->
		<c:if test="${param.error != null}">
			<div>
				로그인 실패<br>
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
					<!-- SPRING_SECURITY_LAST_EXCEPTION : 예외가 나면 스프링이 자동으로 만드는 객체 -->
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />				
				</c:if>
			</div>
		</c:if>
	
	
		<form action="${pageContext.request.contextPath}/login" method="post">
					<!-- 위는 웹사이트명이 바뀌어도 바로 반영될 수 있게끔 만든 EL -->
			<fieldset>
				<legend class="hidden">로그인 폼</legend>
				<h3>
					<img src="images/txtTitle.png" />
				</h3>
				<ul id="loginBox">
					<li><label for="uid">아이디</label><input name="username" class="text" /></li>
					<li><label for="pwd">비밀번호</label><input type="password" name="password" class="text" /></li>
					<!-- name 속성도 스프링에 맞춰줘야 함  -->
				</ul>
				<p>
					<input type="submit" id="btnLogin" value="" />
				</p>
				<ul id="loginOption">
					<li><span>아이디 또는 비밀번호를 분실하셨나요?</span><a href="/Member/FindID"><img
							alt="ID/PWD 찾기" src="images/btnFind.png" /></a></li>
					<li><span>아이디가 없으신 분은 회원가입을 해주세요.</span><a
						href="/Member/Agree"><img alt="회원가입" src="images/btnJoin.png" /></a></li>
				</ul>
			</fieldset>
		</form>





	</div>

</div>