package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Service
public class CustomerService {

	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	public List<Notice> notices(String pg , String f , String q) {
		
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
					
					NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
					list = noticedao.getNotices(page, field, query);
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		return list;
	}
	
	//글 상세보기
	public Notice noticeDetail(String seq) {
		
		Notice notice = null;
		try {
			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	
	//글쓰기 처리
	public String noticeReg(Notice n , HttpServletRequest request, Principal principal) throws IOException, ClassNotFoundException, SQLException {
		
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
		
		n.setWriter(principal.getName());
		
		//DB 파일명 저장
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));
		
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.insert(n);
		return "redirect:notice.htm"; //들어주는 주소 ...
	
	}
	
	//글 삭제 처리
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.delete(seq);
		return "redirect:notice.htm";
	}
	
	//글 수정 view
	public Notice noticeEdit(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		Notice notice = noticedao.getNotice(seq);
		return notice;
	}
	
	//글 수정 처리
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
