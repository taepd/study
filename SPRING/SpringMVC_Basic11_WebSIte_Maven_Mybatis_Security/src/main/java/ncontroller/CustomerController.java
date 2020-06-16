package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
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
	  private SqlSession sqlsession;
	 @Autowired 	
	 public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	 }

	/*
	    메소드의 리턴 타입이 [String]이면 [리턴 값]은 [뷰 이름]으로 사용된다
	  View 에 데이터 전달 위해 Model interface 사용
	  Model model > 함수의 parameter 사용시 자동 객체 생성  > Spring에서 ....
	
	*/
	//글 목록보기
	@RequestMapping("notice.htm") //    /customer/notice.htm
	public String notices(String pg , String f , String q , Model model) {
		
		//default
		int page =1;
		String field = "TITLE";
		String query = "%%";
				
					
		//조건처리
				if(pg != null && !pg.equals("")) {
					page = Integer.parseInt(pg);
				}
				
				if(f != null && !f.equals("")) {
					field = f;
				}
				
				if(q != null && !q.equals("")) {
					query = q;
				}
				
		//DAO 데이터 받아오기
				List<Notice> list=null;
				try {
					//mapper 를 통한 인터페이스 연결
					NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
					//
					list = noticedao.getNotices(page, field, query);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				model.addAttribute("list", list); //view까지 전달 (forward)
				
		return  "customer.notice"; //"notice.jsp";
	}
	
	//글 상세보기
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		
		Notice notice = null;
		try {
			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
	public String noticeReg(Notice n , HttpServletRequest request, Principal principal) throws IOException, ClassNotFoundException, SQLException {
		
		//Notice DTO
		//private List<CommonsMultipartFile> files;
		//files[0] = new CommonsMultipartFile()  >> 1.jpg
		//files[1] = new CommonsMultipartFile()  >> 2.jpg
		
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); //파일명관리
		
		if(files != null && files.size() > 0) { //최소 1개의 업로드가 있다면 
			for(CommonsMultipartFile multifile : files) {
				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				
				String fpath = path + "\\"+ filename; 
				
				if(!filename.equals("")) { //실 파일 업로드
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); //파일명을 별도 관리 (DB insert)
			}
			
		}
		
		/*
		//security 사용한 로그인 ID 를 가져와서 저장하기
		SecurityContext  context =   SecurityContextHolder.getContext();
		Authentication auth = context.getAuthentication();
		
		UserDetails userinfo =  (UserDetails)auth.getPrincipal();
		//로그인한 사용자 ID, 로그인한 사용자 권한 (*********)
		System.out.println(userinfo.getAuthorities()); //권한정보 
		System.out.println(userinfo.getUsername()); //사용자 ID 로그인한 ID
		System.out.println(userinfo.getPassword() + "....");
		
		
		n.setWriter(userinfo.getUsername()); //사용자 정보 ID
		*/
		n.setWriter(principal.getName());
		
		//DB 파일명 저장
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));
		
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.insert(n);
		return "redirect:notice.htm"; //들어주는 주소 ...
	
		//spring : "redirect:notice.htm" 
		//servlet
		//클라이언트 페이지 재 요청(F5 , 주소창에서 Enter)
		//location.href
		//response.sendredirect 
	}
	
	//글삭제하기 (noticeDel.htm) : seq(parameter)
	//return "redirect:notice.htm
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.delete(seq);
		return "redirect:notice.htm";
	}
	
	
	//글수정하기 (화면 : select .... where seq=?) : GET   : seq (parameter)
	//noticedao.getNotice(seq)
	//Model model  >> 화면 >> 데이터 >> noticeEdit.jsp
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.GET)
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		Notice notice = noticedao.getNotice(seq);
		model.addAttribute("notice", notice);
		return   "customer.noticeEdit";//"noticeEdit.jsp";
	}
	
	
	//글수정하기(처리 : update..... where seq=?) : POST 
	//parameter Notice n >> Insert  동일  >> 무조건 파일 첨부 하는 형태로
	//return "redirect:noticeDetail.htm?seq="+n.getSeq();
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.POST)
	public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); //파일명관리
		
		if(files != null && files.size() > 0) { //최소 1개의 업로드가 있다면 
			for(CommonsMultipartFile multifile : files) {
				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				
				String fpath = path + "\\"+ filename; 
				
				if(!filename.equals("")) { //실 파일 업로드
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); //파일명을 별도 관리 (DB insert)
			}
			
		}
				
		//DB 파일명 저장
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));
		
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.update(n);
		return "redirect:noticeDetail.htm?seq="+n.getSeq();
	}
	
}





