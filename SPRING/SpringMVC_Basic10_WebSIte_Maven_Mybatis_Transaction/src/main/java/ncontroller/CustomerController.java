package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import service.CustomerService;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	/*
	   NoticeDao  구현한 객체는 사용하지 않아요
		private NoticeDao noticedao;
		@Autowired
		public void setNoticedao(NoticeDao noticedao) {
			this.noticedao = noticedao;
		}
	*/
	 private CustomerService customerservice;
	 @Autowired	 
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	/*
	    메소드의 리턴 타입이 [String]이면 [리턴 값]은 [뷰 이름]으로 사용된다
	  View 에 데이터 전달 위해 Model interface 사용
	  Model model > 함수의 parameter 사용시 자동 객체 생성  > Spring에서 ....
	
	*/
	//글 목록보기
	@RequestMapping("notice.htm") //    /customer/notice.htm
	public String notices(String pg , String f , String q , Model model) {
		       //서비스에 업무 요청
		   List<Notice> list =      customerservice.notices(pg, f, q);
		   model.addAttribute("list", list); //view까지 전달 (forward)
				
		return  "customer.notice"; //"notice.jsp";
	}
	
	//글 상세보기
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		Notice notice =  customerservice.noticeDetail(seq);
		model.addAttribute("notice",notice);
		
		return  "customer.noticeDetail"; //"noticeDetail.jsp";
	}
	
	
	//글쓰기 화면 GET
	//@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	//글쓰기 처리 POST (파일업로드)
	//@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	//글삭제하기 (페이지 새로 요청)
	//hint) location.href 
	//return "redirect:notice.htm"
	
	//글쓰기 화면 (noticeReg.htm)
	//@RequestMapping(value="noticeReg.htm" , method=RequestMethod.GET)
	
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	public String noticeReg() {
		return  "customer.noticeReg";//"noticeReg.jsp";
	}

	
	//글쓰기 처리 (noticeReg.htm)
	//@RequestMapping(value="noticeReg.htm" , method=RequestMethod.POST)
	//return "redirect:notice.htm" 
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		String url="redirect:notice.htm";
		
		//트랜잭션 처리 .... 코드 수정......
		try {
					url = customerservice.noticeReg(n, request);
		}catch (Exception e) {
				    System.out.println(e.getMessage());
		}
		//예외 발생에 상관없이 목록 페이지 새로고침 처리
		return url;
		
	}
	
	//글삭제하기 (noticeDel.htm) : seq(parameter)
	//return "redirect:notice.htm
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		return customerservice.noticeDel(seq);
	}
	
	
	//글수정하기 (화면 : select .... where seq=?) : GET   : seq (parameter)
	//noticedao.getNotice(seq)
	//Model model  >> 화면 >> 데이터 >> noticeEdit.jsp
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.GET)
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		Notice notice = customerservice.noticeEdit(seq);
		model.addAttribute("notice", notice);
		return   "customer.noticeEdit";//"noticeEdit.jsp";
	}
	
	
	//글수정하기(처리 : update..... where seq=?) : POST 
	//parameter Notice n >> Insert  동일  >> 무조건 파일 첨부 하는 형태로
	//return "redirect:noticeDetail.htm?seq="+n.getSeq();
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.POST)
	public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
			return customerservice.noticeEdit(n, request);
	}
	
	//파일 다운로드 
	@RequestMapping("download.htm")
	public void download(String p , String f , HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
			customerservice.download(p, f, request, response);
	}
}





