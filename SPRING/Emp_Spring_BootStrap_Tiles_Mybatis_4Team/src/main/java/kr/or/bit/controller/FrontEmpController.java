package kr.or.bit.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import kr.or.bit.dao.EmpDao;

import kr.or.bit.dto.Admin;
import kr.or.bit.dto.Emp;
import net.sf.json.JSONObject;



@Controller
public class FrontEmpController {
	
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
		
	}
	
	@RequestMapping(value = "/AdminLogin.emp", method = RequestMethod.GET)
	public String adminLogin() {
		return "Login";
	}
	
	@RequestMapping(value = "/AdminLogin.emp", method = RequestMethod.POST)
	public String adminLogin(String userid, String pwd, Model model, HttpSession session) {
		Admin admin = null;
		String view = null;
		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			admin = empdao.getAdmin(userid);
			if(admin != null && userid.equals(admin.getUserid()) && pwd.equals(admin.getPwd())) {
				session.setAttribute("userid", userid);
				view = "redirect:EmpList.emp";
			}else {
				view = "Login";
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return view;
	}
	
	@RequestMapping("/EmpList.emp")
	public String empList(String ps, String cp, Model model) {
		//List 페이지 처음 호출 ...
		if(ps == null || ps.trim().equals("")){
			//default 값 설정
			ps = "5"; //5개씩 
		}
	
		if(cp == null || cp.trim().equals("")){
			//default 값 설정
			cp = "1"; // 1번째 페이지 보겠다 
		}
		
		int pagesize = Integer.parseInt(ps);
		int cpage = Integer.parseInt(cp);
		int pagecount=0;
		
		try {
			 EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			 List<Emp> emplist = empdao.getEmpList(cpage, pagesize);
			 
			 int totalempcount = empdao.getEmpCount();
				//23건  % 5
				if(totalempcount % pagesize == 0){
					pagecount = totalempcount / pagesize; //  20 << 100/5
				}else{
					pagecount = (totalempcount / pagesize) + 1; 
				}
				model.addAttribute("emplist", emplist);
				model.addAttribute("pagesize", pagesize);
				model.addAttribute("cpage", cpage);
				model.addAttribute("pagecount", pagecount);
				model.addAttribute("totalempcount", totalempcount);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "EmpList";
	}
	
	@RequestMapping("/EmpDetail.emp")
	public String empDetail(int empno, String ps, String cp, Model model) {	
		Emp emp = null;
		try {
			 EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			 emp = empdao.getDetail(empno);
			 
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.addAttribute("emp", emp);
		model.addAttribute("ps", ps);
		model.addAttribute("cp", cp);
		return "EmpDetail";
	}
	
	@RequestMapping(value = "/EmpInsert.emp", method = RequestMethod.GET)
	public String empInsert() {
		return "EmpInsert";
	}
	
	
	@RequestMapping(value = "/EmpInsert.emp",method = RequestMethod.POST)
	public String empInsert(Emp emp, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		CommonsMultipartFile file = emp.getFile();
		String img = null;
		if(file != null) {
			String filename = file.getOriginalFilename();
			String path = request.getServletContext().getRealPath("/upload");
					
			String fpath = path + "\\" + filename;
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(file.getBytes());
			fs.close();
			img = filename;
		}		
		//파일명
		emp.setImg(img);
				
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);		
		empdao.insertEmp(emp);		
		return "redirect:EmpList.emp";
	}
	
	
	@RequestMapping("/EmpJobSelect.emp")
	public String empJobSelect(Model model) {
		List<String> list = null;
		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			list = empdao.getEmpJob();
			System.out.println(list.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.addAttribute("joblist", list);
		return "EmpJobSelect";
	}
	
	@RequestMapping("/EmpDeptnoSelect.emp")
	public String empDeptnoSelect(Model model) {
		List<Integer> list = null;
		JSONObject deptnoJson = null;
		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			list = empdao.getDeptno();
			
			deptnoJson = new JSONObject();
			deptnoJson.put("deptnolist", list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		model.addAttribute("deptnojson", deptnoJson);
		
		return "DeptnoSelect";
	}
	
	@RequestMapping(value = "/EmpUpdate.emp", method = RequestMethod.GET)
	public String empUpdate(int empno, String ps, String cp, Model model) {
		
		Emp emp = null;
		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			emp = empdao.getDetail(empno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.addAttribute("emp", emp);
		model.addAttribute("ps", ps);
		model.addAttribute("cp", cp);
		return "EmpUpdate";
	}
	
	@RequestMapping(value = "/EmpUpdate.emp", method = RequestMethod.POST)
	public String empUpdate(Emp emp, String ps, String cp, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		CommonsMultipartFile file = emp.getFile();
		String img = null;
		if(file != null) {
			String filename = file.getOriginalFilename();
			String path = request.getServletContext().getRealPath("/upload");
					
			String fpath = path + "\\" + filename;
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(file.getBytes());
			fs.close();
			img = filename;
		}		
		//파일명
		emp.setImg(img);
				
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);		
		empdao.updateEmp(emp);		
		return "redirect:EmpDetail.emp?empno="+emp.getEmpno()+"&ps="+ps+"&cp="+cp;
	}
	
	@RequestMapping("/EmpDelete.emp")
	public String empDelete(int empno, String ps, String cp) {
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		empdao.deleteEmp(empno);
		return "redirect:EmpList.emp?ps="+ps+"&cp="+cp;
	}
	
	@RequestMapping("/AdminLogout.emp")
	public String adminLogout(HttpSession session) {
		session.invalidate();
		return "Login";
	}
	

}






