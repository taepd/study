package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Board;

//CRUD 함수 >> ConnectionPool >> 함수 단위 연결,반환
public class BoardDao {
	DataSource ds = null;
	
	public BoardDao() throws NamingException {
		Context initContext = new InitialContext();
		ds = (DataSource) initContext.lookup("java:comp/env/jdbc/oracle");
	}
	
	//글쓰기(원본글)
	public int writeok(Board boarddata) {
		//insert into jspboard(idx,writer,pwd,subject,content,email,homepage,writedate,readnum,filename,filesize,refer)
		// values(jspboard_idx.nextval,?,?,?,?,?,?,sysdate,0,?,0,?)
		
		//계층형 게시판
		//refer , step , depth
		//1. 원본글 : refer  , step(0) default , depth(0) default
		//2. 답변글 : refer  , step + 1 , depth + 1
		
		//원본글 : step , depth >>  NUMBER DEFAULT 0  (insert 하지 않으면 .. 0 default)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row=0;
		try {
				conn = ds.getConnection();
				String sql="insert into jspboard(idx,writer,pwd,subject,content,email,homepage,writedate,readnum,filename,filesize,refer)"
				            + "values(jspboard_idx.nextval,?,?,?,?,?,?,sysdate,0,?,0,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, boarddata.getWriter());
				pstmt.setString(2, boarddata.getPwd());
				pstmt.setString(3, boarddata.getSubject());
				pstmt.setString(4, boarddata.getContent());
				pstmt.setString(5, boarddata.getEmail());
				pstmt.setString(6, boarddata.getHomepage());
				pstmt.setString(7, boarddata.getFilename());
		
				//refer 
				int refermax = getMaxRefer();
				int refer = refermax + 1;
				
				pstmt.setInt(8,refer);
				
				row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			    System.out.println(e.getMessage());
		}finally {
			try {
				pstmt.close();
				conn.close(); //반환하기
			} catch (Exception e2) {
				
			}
			
		}
		
		return row;
	}
	
	//원본글 대한 refer 값 구하기
	public int getMaxRefer() {
		//select nvl(max(refer),0) from jspboard >> 처음 글 >> 0	>> refer + 1 값을	
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int refer_max=0;
		try {
			conn = ds.getConnection(); //빌려주세여^^  이따 반납할게요 
			String sql="select nvl(max(refer),0) from jspboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				refer_max = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close(); // 반납이요 ^^
			}catch (Exception e) {
				
			}
		}
		
		return refer_max;
	}
	
	//글쓰기(답글)
	//게시물 목록보기
		public List<Board> list(int cpage, int pagesize){
			//int cpage: 현재 보고 싶은 페이지 번호[5]
			//int pagesize: 나누고 싶은 pagesize 5
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Board> list = null;
			
			try {
				conn = ds.getConnection();
				String sql = "select * from  "
						+ "(select rownum rn , idx ,writer , email, homepage, pwd , subject , content, writedate, readnum "
						+ "	                 , filename, filesize , refer , depth , step "
						+ "             from ( SELECT * FROM jspboard ORDER BY refer DESC , step ASC ) "
						+ "             where rownum <= ?" + // end row
						") where rn >= ?"; // start row
			pstmt = conn.prepareStatement(sql);
			
			//공식같은 로직(어떤 개발자 알고리즘)
			int start = cpage*pagesize -(pagesize-1);
			int end = cpage*pagesize;
			
			pstmt.setInt(1,  end);
			pstmt.setInt(2,  start);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Board>();
			while(rs.next()) {
				Board board = new Board();
				board.setIdx(rs.getInt("idx"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setWritedate(rs.getDate("writedate"));
				board.setReadnum(rs.getInt("readnum"));
				
				//계층형
				board.setRefer(rs.getInt("refer"));
				board.setStep(rs.getInt("step"));
				board.setDepth(rs.getInt("depth"));
				
				list.add(board);
								
			}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					pstmt.close();
					rs.close();
					conn.close();
				} catch (Exception e2) {
				}
			}
			return list;
			
			
			/*
		    [1][2][3][4][5][다음]
		    [이전][6][7][8][9][10][다음]
		    [이전][11][12] 
		    
		    [1] page 크기 > pagesize 정의
		    totaldata > 54건
		    pagesize = 5
		      규칙 > totalpagecount=11 (전체 페이지 개수)
		    
		    int cpage >> currentpage(현재 페이지 번호) >> 1page  ,2page
		    
		     현재 데이터 100건
		    cpage : 1 ,  pagesize : 5  > start(시작글번호) 1 ~ end(글번호) 5
		    cpage : 2 ,  pagesize : 5  > start(시작글번호) 6 ~ end(글번호) 10
		    cpage : 11 , pagesize : 5  > start(시작글번호) 51 ~ end(글번호) 55 
		    -5개씩 묶어서 11번째 묶음을 보여주세요 
		    
		      * 아래 2개의 계층형 페이징처리 쿼리 테스트 하기 
		      * SELECT * FROM ( SELECT ROWNUM rn , idx ,
		      * writer , email, homepage, pwd , subject , content, writedate, readnum
		      * , filename, filesize , refer , depth , step FROM ( SELECT * FROM
		      * jspboard ORDER BY refer DESC , step ASC ) ) WHERE rn BETWEEN ? AND ?;
		      * 
		      * --------------------------------------------------------------------
		      *  select * from ( select rownum rn , idx ,
		      *  writer , email, homepage, pwd , subject , content, writedate, readnum
		      * , filename, filesize , refer , depth , step from ( SELECT * FROM
		      * jspboard ORDER BY refer DESC , step ASC ) where rownum <= 6 --endrow
		      * ) where rn >= 4; --firstrow
		    
		     SELECT * 
		     FROM 
		             ( SELECT ROWNUM rn , idx ,  writer , email, homepage, pwd , subject , content, writedate, readnum
		                      , filename, filesize , refer , depth , step 
		               FROM 
		                      ( SELECT * FROM jspboard ORDER BY refer DESC , step ASC )
		              )
		     WHERE rn BETWEEN 1 AND 5;
		     
		     
		      select * 
		    from
		            ( select rownum rn , idx , writer , email, homepage, pwd , subject , content, writedate, readnum
		               ,filename, filesize , refer , depth , step 
		              from 
		                   ( SELECT * FROM jspboard ORDER BY refer DESC , step ASC ) 
		              where rownum <= 10 --endrow
		      ) 
		    where rn >= 6; --firstrow
		  */

			
		}
		
		
		//게시물 총 건수
		public int totalBoardCount() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int totalcount=0;
			
			try {
				conn = ds.getConnection();
				String sql="select count(*) cnt from jspboard";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					totalcount = rs.getInt("cnt");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					pstmt.close();
					rs.close();
					conn.close(); //반환하기
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
			return totalcount;
		}
}
































