package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

import jdk.nashorn.internal.objects.annotations.Getter;
/*
클라이언트 요청 
1. 화면 주세요 (글쓰기 , 로그인 화면)  : write.do 
2. 처리해 주세요 (글쓰기 완료 처리 , 로그인 완료 처리)   : writeok.do
>> 요청 주소가 : 화면 >> write.do 
>> 요청 주소가 : 처리 >> writeok.do

**요청 주소가 하나의 일때 (그 주소를 가지고 화면 , 처리) 판단
/article/newArticle.do  하나를 가지고 (전송방식)
1. 화면 : GET 전송 >> 화면
2. 처리 : POST 전송 >> 처리  (insert)


*/
@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	   //NewArticleController 클래스는  ArticleService 클래스에 의존한다 (필요)
	  //주입 (생성자 , setter )
	  private ArticleService articleservice;
	  
	  @Autowired
	  public void setArticleservice(ArticleService articleservice) {
			this.articleservice = articleservice;
		}


	   //참고
		
	
	//@GetMapping("/article/newArticle.do")  ...5.x.x
	   @RequestMapping(method = RequestMethod.GET)  //화면 보여주기
		public String form() {
			   return "article/newArticleForm";
			//viewResolver >> /WEB-INF/views/ + article/newArticleForm + ".jsp"
		}
	   /*
	    1. 가장 전통적인 방법 Client 데이터 받아서 DTO 연결 (Spring 에서 x) 
	     
	   @RequestMapping(method = RequestMethod.POST) //처리 insert 해주세요
	   public ModelAndView submit(HttpServletRequest request) {
		   NewArticleCommand article = new NewArticleCommand();
		   article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		   article.setTitle(request.getParameter("title"));
		   article.setContent(request.getParameter("content"));
		   
		   articleservice.writeArticle(article);
		   //처리 완료
		   
		   ModelAndView mv = new ModelAndView();
		   mv.addObject("newArticleCommand", article);
		   mv.setViewName("article/newArticleSubmitted");
		   
		   return mv;
	   }
	   */

	   /*
	     2. Spring 에서 parameter 를  DTO 객체 받기
	     2.1 자동화 >> 전제조건 : <input name="값" >> 값이 DTO 객체 >> member field 명과 동일
	     
	     submit(NewArticleCommand command) 
	     1. 자동  DTO 객체 생성  >> NewArticleCommand article = new NewArticleCommand();
	     2. 넘어온 parameter setter 통해서 자동 주입
	     3. NewArticleCommand 객체는  IOC 컨테이너 안에 자동 생성   >> id="newArticleCommand"
	     
	       >>  public ModelAndView submit()
	       ModelAndView mv = new ModelAndView();
		   mv.addObject("newArticleCommand", command);
		   mv.setViewName("article/newArticleSubmitted");
		   return mv;
	       위 코드를 사용해도 문제 없어요
	       조금더 코드를 줄여 .....
	        >> mv.addObject("newArticleCommand", command); 
	             자동 생성
	       NewArticleCommand() >> IOC 컨테이너 생성
	       <bean id="newArticleCommand"   class="">
	       >> forward >> view >> newArticleCommand 이름 객체 
	    
	    
	    public String submit(NewArticleCommand command) {
	    1. NewArticleCommand 객체 생성
	    2. setter 자동 주입
	    3. forward 되는 페이지에 자동 전달 (key) >> newArticleCommand
	    
	    */
	   /*
	   @RequestMapping(method = RequestMethod.POST) //처리 insert 해주세요
	   public String submit(NewArticleCommand command) {
		   //System.out.println(command.toString());
		   articleservice.writeArticle(command);
		   	   
		   return "article/newArticleSubmitted";
	   }
	   */
	   
	   //객체의 이름(key) 자동 생성되는게 싫어요
	   
	   @RequestMapping(method = RequestMethod.POST) //처리 insert 해주세요
	   public String submit(@ModelAttribute("Articledata")NewArticleCommand command) {
		   //System.out.println(command.toString());
		   articleservice.writeArticle(command);
		   	   
		   return "article/newArticleSubmitted";
	   }
	   
	   
	   
}
















