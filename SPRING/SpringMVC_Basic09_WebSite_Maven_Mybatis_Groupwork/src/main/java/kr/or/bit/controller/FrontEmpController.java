package kr.or.bit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.Empdao;
import kr.or.bit.dto.Admin;
import kr.or.bit.service.AdminLogin;
import kr.or.bit.service.AdminLogout;
import kr.or.bit.service.DataTable;
import kr.or.bit.service.DeptDetail;
import kr.or.bit.service.EmpChart;
import kr.or.bit.service.EmpDelete;
import kr.or.bit.service.DeptnoSelect;
import kr.or.bit.service.EmpDetail;
import kr.or.bit.service.EmpInsert;
import kr.or.bit.service.EmpJobSelect;
import kr.or.bit.service.EmpList;
import kr.or.bit.service.EmpListAjax;
import kr.or.bit.service.EmpSearchDeptno;
import kr.or.bit.service.EmpSearchEmpno;
import kr.or.bit.service.EmpTotalCount;
import kr.or.bit.service.EmpUpdate;





@Controller
public class FrontEmpController {
	
	  private SqlSession sqlsession;
		 @Autowired 	
		 public void setSqlsession(SqlSession sqlsession) {
			this.sqlsession = sqlsession;
		 }

	
	

	//관리자 로그인
	@RequestMapping("AdminLogin.emp")
	public String noticeDetail(String userid , Model model) {
		
		Admin admin = null;
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		admin = empdao.getAdmin(userid);
		
		String msg = "";
		String url = "";
		
		if(admin != null && userid.equals(admin.getUserid())) {
				//HttpSession session = request.getSession();
				//session.setAttribute("userid", userid);
				
				msg = "로그인 성공";
				url = "EmpList.emp";
			
		}else {
				msg = "로그인 실패";
				url = "LoginView.emp";
		}
		//request.setAttribute("msg", msg);
		//request.setAttribute("url", url);
		
		return  "empList"; //"noticeDetail.jsp";
	}


}






