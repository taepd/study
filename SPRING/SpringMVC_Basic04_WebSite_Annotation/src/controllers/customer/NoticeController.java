package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

public class NoticeController  implements Controller{
	public NoticeController() {
		System.out.println("[NoticeController]");
	}
	
	//게시판 목록 조회 
	//DAO 객체 필요 (NoticeDao 객체에 의존)
	//주소를(injection) .... 1. xml ,    2. annotation 
	
	private NoticeDao noticedao;
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[NoticeController HandleRequest]");
		
		//public List<Notice> getNotices(int page, String field, String query) 실행
		
		//검색처리
		String  _page = request.getParameter("pg");
		String  _field = request.getParameter("f");
		String  _query = request.getParameter("p");
		
		//default
		int page=1;
		String field="TITLE";
		String query ="%%";
		
		if(_page != null && !_page.equals("")) {
			page = Integer.parseInt(_page);
		}
		
		if(_field != null && !_field.equals("")) {
			field = _field;
		}
		
		if(_query != null && !_query.equals("")) {
			query = _query;
		}
		//DAO 작업
	   List<Notice> list =	noticedao.getNotices(page, field, query);
	   
	   //Spring 적용 
	  ModelAndView mv = new ModelAndView();
	  mv.addObject("list", list);
	  mv.setViewName("notice.jsp");
		
		return mv;
	}

}
