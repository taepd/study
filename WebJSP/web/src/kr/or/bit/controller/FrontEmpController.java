package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.AdminLogin;
import kr.or.bit.service.AdminLogout;
import kr.or.bit.service.DeptDetail;
import kr.or.bit.service.EmpDelete;
import kr.or.bit.service.EmpDetail;
import kr.or.bit.service.EmpInsert;
import kr.or.bit.service.EmpList;
import kr.or.bit.service.EmpSearchDeptno;
import kr.or.bit.service.EmpSearchEmpno;
import kr.or.bit.service.EmpTotalCount;
import kr.or.bit.service.EmpUpdate;




@WebServlet("*.do")
public class FrontEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontEmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    
    	System.out.println(url_Command);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}