package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/FrontBoardController")
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontBoardController() {
        super();
    }
    
    //GET, POST 두 가지 요청방식에 대해서 동작하는 함수
    //doGet(), doPost() 자동 호출
    //1. servlet 제공하는 함수: service() 함수
    //2. 별도의 함수(개발자 마음): doget, doPost
    //doProcess()
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
    	//이 메서드를 이용해서 GET, POST 요청을 둘 다 처리
    	System.out.println("클라이언트 요청: "+method);
    	
    	//1. 한글 처리
    	
    	//2. 요청 받기(request)
    	
    	//3. 요청 판단(판단의 기준: parameter) : **command 방식
    	//3.1 parameter 기준 판단
    	//3.2 http://192.168.0.12:8090/WebServlet_1/board?cmd=login&userid=kgilm
    	
    	//String str = request.getParameter("cmd");
    	//if(str.equals("login") {로그인 처리}
    	
    	//board?cmd=boardlist
    	//String str = request.getParameter("cmd");
    	//if(str.equals("boardlist") {게시판 처리}
    	
    	//cmd 반대 방식(url 주소 판단)  **url 방식
    	//http://192.168.0.12:8090/WebServlet_1/board/boardlist
    	//http://192.168.0.12:8090/WebServlet_1/board/boardwrite?title=hello&content=
    	//마지막 주소값으로 판단: /boardlist 목록보기
    						//boardwrite 글쓰기
    	
    	//4. 결과 저장(scope: request, session, application. 주로 request 씀)
    	
    	//5. view 지정
    	//view page: jsp
    	//WebContent > board > boardlist.jsp
    	//WebContent > error > error404.jsp
    	//위 코드 문제점: 보안 노출 : 클라이언트 직접 주소창에
    	//http://192.168.0.12:8090/WebServlet_1/board/boardEditOK.jsp >>URL명시
    	//실제 프로젝트에서는 JSP파일 ...
    	//해결: 보안 폴더: WEB-INF >> views 폴더 >
    	//1. WEB-INF >> views >> board >> boardlist.jsp
    	//2. WEB-INF >> views >> error >> error404.jsp
    	//WAS 내부에서 서버 접근 가능: forward 처리(서버 코드 read)
    	
    	//6. view에게 저장된 객체 전달(forward)
    	
    	/////////////////////////////////////////
    	request.setCharacterEncoding("UTF-8");
    	
    	//1. 요청 받기(command 방식)
    	//http://192.168.0.12:8090/WebServlet_1/board?cmd=list
    	String cmd = request.getParameter("cmd");
    	
    	//2. 요청 판단(업무 정의)
    	String viewPage = null;
    	//cmd >> null >> error.jsp 
    	//cmd >> boardlist >> list.jsp 
    	//cmd >> boardwrite >> write.jsp
    	
    	if(cmd == null) {
    		viewPage = "/error/error.jsp";
    	}else if(cmd.equals("boardlist")) {
    		
    		viewPage="/board/boardlist.jsp";
    		//실제 업무 처리
    		//DB 연결 ... select ... 객체에 담고 저장
    		//boardDad dao = new boardDao();
    		//List<board> boardlist = dao.selectBoardList();
    		//request.setAttribute("list",boardlist);
    		//forward >> view 전달 >> boardlist.jsp >>
    		//EL&JSTL
    		//<c:set var="list" value="<%=request.getAttribute("list")%>>
    		//<c: forEach 출력
    	}else if(cmd.equals("boardwrite")) {
    		
    		viewPage = "/board/boardwrite.jsp";
    		    		
    	}else if(cmd.equals("login")) { 
    		viewPage="/WEB-INF/views/login/login.jsp"; //실 개발에서 이렇게 보안폴더 사용 
    	}else {
    		viewPage = "/error/error.jsp";
    	}
    	
    	//3. 결과 저장
    	//가정.....
    	//List<Emp> list = new ArrayList<>();
    	//list.add(new Emp(2000, "김유신"));
    	//.....
    	//request.setAttribute("emplist", list);
    	
    	//4. view 지정
    	RequestDispatcher dis = request.getRequestDispatcher(viewPage);
    	
    	//5. 데이터 전달(forward)
    	dis.forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}























