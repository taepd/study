package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class HelloController implements Controller {
	
	public HelloController() {
		System.out.println("HelloController 객체 생성");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 요청 실행: handleRequest 함수 실행");
		
		//업무 수행(service 사용).. 게시판 목록보기, 글쓰기 판단 처리
		
		//*데이터 만들고 담고... view 지정
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "hong"); //request.setAttribute()
		//mav.setViewName("/WEB-INF/views/Hello.jsp"); //view지정 .. /WEB-INF/Board/Hello.jsp 이렇게 하던 것을
		mav.setViewName("Hello"); //resolver 활용
		return mav;
	}
}
























