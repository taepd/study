package com.bit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "이 녀석은 설명입니다^^", urlPatterns = { "/action.do" })
public class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontServletController() {
        super();
    }
    /*
    //doProcess와 같아요
    //protected void service 만들면  doGet, doPost 호출되지 않아요
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 실행");
	}
	*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		String msg = "";
		if (cmd.equals("greeting")) {
			// 자바의 다양한 객체 사용
			Message m = new Message();
			msg = m.getMessage(cmd);
		}

		request.setAttribute("msg", msg);

		RequestDispatcher dis = request.getRequestDispatcher("/greeting.jsp");
		dis.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
