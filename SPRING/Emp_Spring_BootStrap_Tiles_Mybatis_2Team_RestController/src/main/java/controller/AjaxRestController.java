package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dao.Empdao;
import dto.Emp;

@RestController // @Controller + @ResponseBody 비동기를 위한 Restcontroller는 따로 빼는게 좋다
public class AjaxRestController {

	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	// ajax 직종 불러오기
	@RequestMapping("EmpJobSelect.emp")
	public List<String> empJobSelect() {

		List<String> list = null;
		try {
			Empdao dao = sqlsession.getMapper(Empdao.class);
			list = dao.getEmpJob();
			System.out.println(list);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	// ajax 부서번호 불러오기
	@RequestMapping("EmpDeptnoSelect.emp")
	public List<Integer> deptnoSelect() {

		List<Integer> list = null;
		try {
			Empdao dao = sqlsession.getMapper(Empdao.class);
			list = dao.getDeptno();
			System.out.println(list);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	// ajax 페이징
	@RequestMapping("EmpListAjax.emp")
	public Map<String, Object> empListAjax(HttpServletRequest request, HttpServletResponse response) {

		String ps = request.getParameter("ps"); // pagesize
		String cp = request.getParameter("cp"); // current page

		// List 페이지 처음 호출 ...
		if (ps == null || ps.trim().equals("")) {
			// default 값 설정
			ps = "5"; // 5개씩
		}

		if (cp == null || cp.trim().equals("")) {
			// default 값 설정
			cp = "1"; // 1번째 페이지 보겠다
		}
		System.out.println(ps);
		System.out.println(cp);
		int pagesize = Integer.parseInt(ps);
		int cpage = Integer.parseInt(cp);
		int pagecount = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		List<Emp> emplist = null;
		try {
			Empdao dao = sqlsession.getMapper(Empdao.class);
			emplist = dao.getEmpList(cpage, pagesize);
			// request.setAttribute("emplist", emplist);

			int totalempcount = dao.getEmpCount();
			System.out.println(totalempcount);

			if (totalempcount % pagesize == 0) {
				pagecount = totalempcount / pagesize;

			} else {
				pagecount = (totalempcount / pagesize) + 1;
			}

			map.put("emplist", emplist);
			map.put("cpage", cpage);
			map.put("totalempcount", totalempcount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;

	}

	/*
	 * //사원번호 검색 비동기
	 * 
	 * @RequestMapping(value="EmpSearchEmpno.emp") public List<Emp>
	 * empSearchEmpno(HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * 
	 * String en = request.getParameter("empno");
	 * 
	 * int empno = Integer.parseInt(en); List<Emp> emplistByEmpno = null;
	 * 
	 * try { Empdao dao = sqlsession.getMapper(Empdao.class); emplistByEmpno =
	 * dao.getEmpListByEmpno(empno);
	 * 
	 * 
	 * 
	 * }catch (Exception e) { System.out.println(e.getMessage()); } return
	 * emplistByEmpno;
	 * 
	 * }
	 */

	// 사원번호 검색 비동기
	@RequestMapping(value = "EmpSearchEmpno.emp")
	public Map<String, Object> empSearchEmpno(HttpServletRequest request, HttpServletResponse response) {

		String ps = request.getParameter("ps"); // pagesize
		String cp = request.getParameter("cp"); // current page

		// List 페이지 처음 호출 ...
		if (ps == null || ps.trim().equals("")) {
			// default 값 설정
			ps = "5"; // 5개씩
		}

		if (cp == null || cp.trim().equals("")) {
			// default 값 설정
			cp = "1"; // 1번째 페이지 보겠다
		}

		String en = request.getParameter("empno");

		int empno = Integer.parseInt(en);
		List<Emp> emplistByEmpno = null;
		Map<String, Object> empmap = new HashMap<String, Object>();

		int pagesize = Integer.parseInt(ps);
		int cpage = Integer.parseInt(cp);
		int pagecount = 0;

		try {

			Empdao dao = sqlsession.getMapper(Empdao.class);
			emplistByEmpno = dao.getEmpListByEmpno(cpage, pagesize, empno);

			int totalempcount = dao.getEmpCount("empno", empno);

			if (emplistByEmpno.size() % pagesize == 0) {
				pagecount = emplistByEmpno.size() / pagesize; // 20 << 100/5
			} else {
				pagecount = (emplistByEmpno.size() / pagesize) + 1;
			}
			empmap.put("emplistByEmpno", emplistByEmpno);
			empmap.put("cpage", cpage);
			empmap.put("totalempcount", totalempcount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return empmap;

	}

	// 부서번호 셀렉트 비동기 처리
	@RequestMapping("EmpSearchDeptno.emp")
	public Map<String, Object> empSearchDeptno(HttpServletRequest request, HttpServletResponse response) {

		String ps = request.getParameter("ps"); // pagesize
		String cp = request.getParameter("cp"); // current page

		// List 페이지 처음 호출 ...
		if (ps == null || ps.trim().equals("")) {
			// default 값 설정
			ps = "5"; // 5개씩
		}

		if (cp == null || cp.trim().equals("")) {
			// default 값 설정
			cp = "1"; // 1번째 페이지 보겠다
		}

		String en = request.getParameter("deptno");

		int deptno = Integer.parseInt(en);
		List<Emp> emplistByDeptno = null;
		Map<String, Object> empmapbydeptno = new HashMap<String, Object>();

		int pagesize = Integer.parseInt(ps);
		int cpage = Integer.parseInt(cp);
		int pagecount = 0;

		try {

			Empdao dao = sqlsession.getMapper(Empdao.class);
			emplistByDeptno = dao.getEmpListByDeptno(cpage, pagesize, deptno);
			int totalempcount = dao.getEmpCount("deptno", deptno);
			if (totalempcount % pagesize == 0) {
				pagecount = totalempcount / pagesize; // 20 << 100/5
			} else {
				pagecount = (totalempcount / pagesize) + 1;
			}
			empmapbydeptno.put("emplistByDeptno", emplistByDeptno);
			empmapbydeptno.put("cpage", cpage);
			empmapbydeptno.put("totalempcount", totalempcount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return empmapbydeptno;

	}

}
