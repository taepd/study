

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;

public class NoticeController implements Controller {
	
	public NoticeController() {
		System.out.println("NoticeController 객체 생성");
	}
	
	//게시판 목록 조회
	//DAO 객체 필요(NoticeDao 객체에 의존)
	private NoticeDao noticedao;
	public void setNoticeDao(NoticeDao noticedao){
		this.noticedao = noticedao;
	}
	
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeController handleRuquest");
		return null;
	}
}














