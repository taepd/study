package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
public class HelloController  implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
1. 	implements Controller  단점 :   10개의 요청이 오면 .... Controller 10개 생성
    ex)     ListController  , DeleteController .....

2. @Controller 사용하면 method 단위로 매핑을 할 수 있다
	@Controller 함수 단위 매핑
	하나의 컨트롤러가 여러개의 요청을 처리 할 수 있다
	
*/

@Controller
public class HelloController {
	  public HelloController() {
		  System.out.println("HelloController  생성자");
	  }
	
	  @RequestMapping("/hello.do")  //<a href="hello.do">hello.do</a>
	   public ModelAndView hello() {
			System.out.println("[hello.do method call]");
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("greeting", getGreeting());
			mv.setViewName("Hello");
		  	return mv;
		}
	  
	  //@RequestMapping 를 가지지 않는 별도의 함수는 필요시 생성해서 사용
	  private String getGreeting() {
		  int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		  String data="";
		  if(hour >= 6 && hour <= 10) {
			  data="학습시간";
		  }else if(hour >= 11 && hour <= 13) {
			  data="배고픈 시간";
		  }else if(hour >= 14 && hour <= 18) {
			  data="졸려운 시간";
		  }else {
			  data = "go home";
		  }
		  return data;
	  }
	  
	  
	  @RequestMapping("/hello2.do")
	   public ModelAndView hello2() {
			return null;
		}
}






