package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//@WebFilter("/EncodingFilter")
//@WebFilter(
//		description = "어노테이션 활용하기", 
//		urlPatterns = { "/*" }, 
//		initParams = { 
//				@WebInitParam(name = "encoding", value = "UTF-8", description = "한글처리")
//		})

public class EncodingFilter implements Filter {
	
	//변수 만들기
	private String encoding;
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		//최초 요청시 컴파일되고 한 번만 실행
		//fConfig parameter통해서 변수값을 read(web.xml)
		
		this.encoding = fConfig.getInitParameter("encoding");
		System.out.println("Filter init : " + this.encoding);
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청 시 실행
		if(request.getCharacterEncoding() == null) {
			System.out.println("before: "+request.getCharacterEncoding());
			
			request.setCharacterEncoding(this.encoding);  //한 줄.. 공통(보조)
			
			System.out.println("after: "+request.getCharacterEncoding());
		}
		//기준
		chain.doFilter(request, response);
		//응답 시 실행
		System.out.println("response 응답 처리");
	}
	
	
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	


	

}
