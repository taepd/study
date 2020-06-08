package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller{
	
	public IntroController() {
		System.out.println("IntroController 객체 생성");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("IntroController 요청 실행: handleRequest 함수 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "bituser"); //request.setAttribute()
		//mav.setViewName("/WEB-INF/views/Hello.jsp"); //view지정 .. /WEB-INF/Board/Hello.jsp 이렇게 하던 것을
		mav.setViewName("Intro"); //resolver 활용
		return mav;
	}

}
