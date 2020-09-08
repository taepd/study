package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.Empdao;
import dto.Emp;
import dto.User;
import net.sf.json.JSONObject;
import dto.Admin;

@Controller
public class EmpController {

	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	
	
	
	// 관리자 로그인
	@RequestMapping("AdminLogin.emp")
	public String adminLogin(String userid, String pwd, HttpSession session, Model model) {

		Admin admin = null;
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		admin = empdao.getAdmin(userid);

		String msg = "";
		String url = "";

		if (admin != null && userid.equals(admin.getUserid()) && pwd.equals(admin.getPwd())) {
			session.setAttribute("userid", userid);
			msg = "로그인 성공";
			url = "EmpList.emp";

		} else {
			msg = "로그인 실패";
			url = "./authentication-login.html";
		}
		// request.setAttribute("msg", msg);
		// request.setAttribute("url", url);
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "redirect"; // "noticeDetail.jsp";
	}
	
	@RequestMapping("AdminLogout.emp")
	public String adminLogout(HttpSession session, Model model) {

		session.invalidate();
		

		String msg = "로그아웃 되었습니다.";
		String url = "./authentication-login.html";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		

		
		return "redirect";
	}


	// UserList 전체 리스트 호출
	@RequestMapping("/index.htm")
	public String empList(String cp, String ps, Model model) {
		
		System.out.println("이거 나오면 성공");

		// DAO 데이터 받아오기
		List<User> userlist = null;

		// mapper 를 통한 인터페이스 연결
		Empdao empdao = sqlsession.getMapper(Empdao.class);


		userlist = empdao.getUserList(); 

		model.addAttribute("userList", userlist);
		
		System.out.println(userlist.toString());
		
		return "UserList";
	}
	
	// User Cstate 갱신 
	@RequestMapping("UpdateCstate.emp")
		public String updateCstate(HttpServletRequest request, Model model) {
			
			String[] users = request.getParameterValues("check");
			
					
			System.out.println("이거 나오면 성공");

			// DAO 데이터 받아오기
			List<User> userlist = null;

			// mapper 를 통한 인터페이스 연결
			Empdao empdao = sqlsession.getMapper(Empdao.class);

			int updateResult = empdao.updateCstate(users);
			userlist = empdao.getUserList(); 

			model.addAttribute("userList", userlist);
			
			System.out.println(userlist.toString());
			
			return "UserList";
		}

	// EmpList 상세보기
	@RequestMapping("EmpDetail.emp")
	public String empDetail(String empno, Model model, String cp, String ps) {

		Emp emp = null;
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		emp = empdao.getDetail(Integer.parseInt(empno));

		model.addAttribute("cpage", cp);
		model.addAttribute("pagesize", ps);
		model.addAttribute("emp", emp);

		return "EmpDetail";
	}

	// Insert 사원 등록 화면
	@RequestMapping(value = "EmpInsert.emp", method = RequestMethod.GET)
	public String empInsert() {
		return "EmpInsert";
	}

	// Insert 사원 등록 처리
	@RequestMapping(value = "EmpInsert.emp", method = RequestMethod.POST)
	public String empInsert(Emp emp, HttpServletRequest request, Model model) throws IOException {
		System.out.println("insert 테스트");
		List<CommonsMultipartFile> files = emp.getFiles();
		List<String> filenames = new ArrayList<String>(); // 파일명관리

		if (files != null && files.size() > 0) { // 최소 1개의 업로드가 있다면
			for (CommonsMultipartFile multifile : files) {
				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/upload");

				String fpath = path + "\\" + filename;

				if (!filename.equals("")) { // 실 파일 업로드
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); // 파일명을 별도 관리 (DB insert)
			}

		}

		// DB 파일명 저장
		emp.setImg(filenames.get(0));

		Empdao empdao = sqlsession.getMapper(Empdao.class);
		int result = 0;
		result = empdao.insertEmp(emp);

		String msg = "";
		String url = "";
		if (result > 0) {
			msg = "등록성공";
			url = "EmpList.emp";
		} else {
			msg = "등록실패";
			url = "EmpInsert.emp";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "redirect";
	}

	// Update 사원 수정 화면
	@RequestMapping(value = "EmpUpdate.emp", method = RequestMethod.GET)
	public String empUpdate(String empno, Model model, String cp, String ps) {
		Emp emp = null;
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		emp = empdao.getDetail(Integer.parseInt(empno));

		model.addAttribute("cpage", cp);
		model.addAttribute("pagesize", ps);
		model.addAttribute("emp", emp);
		return "EmpUpdate";
	}

	// Update 사원 수정 처리
	@RequestMapping(value = "EmpUpdate.emp", method = RequestMethod.POST)
	public String empUpdate(Emp emp, HttpServletRequest request, Model model, String cp, String ps) throws IOException {
		System.out.println("insert 테스트");
		List<CommonsMultipartFile> files = emp.getFiles();
		List<String> filenames = new ArrayList<String>(); // 파일명관리

		if (files != null && files.size() > 0) { // 최소 1개의 업로드가 있다면
			for (CommonsMultipartFile multifile : files) {
				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/upload");

				String fpath = path + "\\" + filename;

				if (!filename.equals("")) { // 실 파일 업로드
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); // 파일명을 별도 관리 (DB insert)
			}

		}

		// DB 파일명 저장
		emp.setImg(filenames.get(0));

		Empdao empdao = sqlsession.getMapper(Empdao.class);
		int result = 0;
		result = empdao.updateEmp(emp);

		String msg = "";
		String url = "";
		if (result > 0) {
			msg = "수정 성공";
			url = "EmpList.emp";
		} else {
			msg = "수정 실패";
			url = "EmpUpdate.emp";
		}
		model.addAttribute("cp", cp);
		model.addAttribute("ps", ps);
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "redirect";
	}

	// 사원 정보 삭제
	@RequestMapping("EmpDelete.emp")
	public String empDelete(String empno, String cp, String ps, Model model)
			throws ClassNotFoundException, SQLException {

		int result = 0;
		Empdao empdao = sqlsession.getMapper(Empdao.class);
		result = empdao.deleteEmp(Integer.parseInt(empno));

		String msg = "";
		String url = "";
		if (result > 0) {
			msg = "삭제 성공";
			url = "EmpList.emp";
		} else {
			msg = "삭제 실패";
			url = "EmpDetail.emp?empno=" + empno;
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "redirect";

	}

}
