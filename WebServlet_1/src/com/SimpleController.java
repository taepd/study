package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 서블릿(servlet)
 * java로 만든 파일로 웹 서비스할 목적
 * 서블릿 파일 조건: extends HttpServlet >> 웹 request, response 객체 사용가능
 * 
 * 1. extends HttpServlet 반드시 상속(웹 환경에서 요청, 응답) 처리
 * 2. SimpleController 서블릿
 * 3. 서블릿은 이벤트 기반의 동작(특정 함수들이 특정 상황에(사건이 발생) 자동 호출)
 * ex) 페이지가 로드 되면.. 함수 호출
 * protected void doGet
 * protected void doPost 2개의 함수가 자동 호출
 * 
 * 클라이언트가 SimpleController 요청하면 
 * 요청방식(Get) >> doGet 자동 호출
 * 				>> <form method="GET"
 * 				>> <a herf="login.jsp?num=1000">게시판</a>
 * 
 * 요청방식(Post) >> doPost 자동 호출
 * 				>> <form method="POST"
 * doGet, doPost : request.getParameter
 * 
 * Model1 방식> http://192.168.0.12:8090/WebServlet_1/index.jsp >> jsp 요청 방식
 * Model2 방식> http://192.168.0.12:8090/WebServlet_1/SimpleController.java(x)
 * 			   web.xml 파일에 주소
 * 			   <url-pattern>/simple<url-pattern>
 * 			   http://192.168.0.12:8090/WebServlet_1/simple 요청이 오면
 * 
 * 			   **서블릿(java) >> 컴파일 >> class 파일 생성 >> 실행(doGet, doPost) >> 결과리턴
 * 
 * 			   12시 서버 오픈 -> 서버(SimpleController) 자바 파일
 * 				-> 12시 10분 돌이: 최초요청(http://192.168.0.12:8090/WebServlet_1/simple) >> 컴파일(class 파일 생성)
 * 								>> 최초실행 >> 생성자 >> init함수 >> doGet, doPost 실행 >> 그 결과를 Client return
 * 
 * 				-> 12시 15분 순이: http://192.168.0.12:8090/WebServlet_1/simple >> 기존 실행파일 존재
 * 								>> 실행 >> doGet, do Post 실행 >> 그 결과를 Client return
 * 				-> SimpleController 자바 파일 언제 다시 컴파일 ? >> 서버리부팅, 코드 수정
 * 
 * 4. Model1 방식
 * 4.1 JSP 요청과 응답을 처리(DAO, DTO) + JSP
 * 4.2 클라이언트의 모든 요청을 JSP가 처리
 * 4.3 UI + 업무(로직): JSP 처리
 * 
 * 5. Model2 방식(MVC)
 * 5.1 MVC(Model, View, Controller)
 * --Model(순수한 자바 파일) : DAO(DeptDao.java), DTO(VO,DOMAIN)(Dept.java), SERVICE(처리)
 * --View: JSP(서버 쪽에서 받은 데이터를 화면에 출력): EL & JSTL) , html
 * --Controller : servlet(112 상황실. 중앙 통제)
 * 	--1. 클라이언트 요청 파악(로그인, 게시판 글쓰기, 게시판 상세보기 등)
 * 	--2. 요청을 처리(화면 제공, 로직 처리 후 결과 리턴)
 * 
*/



/**
 * Servlet implementation class SimpleController
 */
//@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleController() {
        super();
        System.out.println("생성자 호출");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("클라이언트 요청");
		
		//1. 한글 처리
		
		//2. 사용자의 요청 파악(요청값 받기)
		String type= request.getParameter("type");
		
		//3. 요청에 따른 업무 수행(Service)
		Object resultobj = null;
		if(type==null || type.equals("greeting")) {
			resultobj = "hello world";
		}else if(type.equals("date")) {
			resultobj=new Date();
		}else {
			resultobj="invalid String type";
		}
		
		//4. 요청 완료에 따른 결과를 저장
		//결과를 저장하는 방법: request, session, application 객체(차이 scope)
		request.setAttribute("result", resultobj);
		
		//5. 저장한 결과를 Client에게 전달(화면(UI) JSP) >> 어떤 JSP 사용할지 지정
		//출력할 페이지를 정하고 >> 출력할 데이터 페이지에 넘겨주고 => forward(방식) > 제어권 넘김
		//**request 객체는 >> include, forward 페이지에서 공유된다
		
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		//출력 페이지 지정(Dispatcher)
		//화면지정
		//지정한 화면에 데이터 전달(forward)
		
		dis.forward(request, response);
		//현재 페이지가 가지고 있는 request, response 객체 주소를 넘겨준다
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
