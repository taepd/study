package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

		//요청당 함수 표현
	    @RequestMapping("/cookie/make.do")
		public String make(HttpServletResponse response) {
	    	 response.addCookie(new Cookie("auth","1004"));
	    	 //servlet 처리 하는 방법 동일
	    	 return "cookie/CookieMake";
	    }
	    
	    //전통적인 방법 cookie read
	    //public String view(HttpServletRequest request)
	    @RequestMapping("/cookie/view.do")
	    public String view(@CookieValue(value="auth" , defaultValue = "1000") String auth) {
	    	System.out.println("클라이언트에서 read 한 쿠키 값 : " + auth);
	    	return "cookie/CookieView";
	    }
	    
}











