package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.memo;
import kr.or.bit.utils.Singleton_Helper;

/*
 * DB작업
 * CRUD 함수 생성 
 * 
 * memo table CURD 작업
 * 전체 조회 : select id, email, content form memo;
 * 조건 조회 : select id, email, content form memo where id=?;
 * 삽입: insert into memo(id, email, content) values(?,?,?);
 * 수정: update memo set email=?, content=? where id=?;
 * 삭제: delete form memo where id=?;
 * 
 * 기본 5개 + 알파(필요하다면)
*/


public class memodao {
	Connection conn = null;
	public memodao() {
		conn = Singleton_Helper.getConnection("oracle");
	}
	
	//전체 데이터 조회
	public List<memo> getMemoList() throws SQLException{
		PreparedStatement pstmt = null;
		String sql="select id, email, content from memo"; //id, email, content를 *로 해도 무방
		
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<memo> memolist = new ArrayList<memo>();
		
		while(rs.next()) {
			memo m = new memo();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("email"));
			m.setContent(rs.getString("content"));
			memolist.add(m);
		}
		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);
		return memolist;
	}
	
	//조건 데이터 조회(where 사용되는 컬럼은: unique, primary key)
	public memo getMemoListById(String id) {
		return null;
	}
	
	//insert
	//권장사항: public int insertMemo(memo  m){}
	public int insertMemo(String id, String email, String content) {
		int resultrow=0;
		
		PreparedStatement pstmt=null;
		try {
			String sql="insert into memo(id, email, content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			pstmt.setString(3, content);
			
			resultrow = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Insert : " + e.getMessage());
		}finally {
			Singleton_Helper.close(pstmt);
		}
		
		return resultrow;
	}
	
	
	//update
	public int updateMemo(memo m) {
		return 0;
	}
	
	//delete
	public int deleteMemo(String id) {
		return 0;
	}
	
	//추가함수 구현...
	//id 존재 유무 판단 함수
	public String isCheckById(String id) {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
