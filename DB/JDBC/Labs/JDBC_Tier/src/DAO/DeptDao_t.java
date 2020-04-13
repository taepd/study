package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import Utils.SingletonHelper;

//DAO
//1. DB연결
//2. CRUD 함수
//3. 하나의  테이블을 대상으로 () >> Dept 테이블 대상으로 함수 몇개 만들까요 
//(select (전체조회) , select (1건 .. 조건(pk) where , insert , update , delete)
public class DeptDao_t {
	//1. 전체조회 >> select 결과 >> return Multi row
	public List<Dept> getDeptAllList(){
		//DB연결 >> 명령  >> 명령실행  >> 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> deptlist = new ArrayList<Dept>();
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql="select deptno , dname , loc from dept";
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				deptlist.add(dept); //[dept][dept]...
			}
		}catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return deptlist;
	}
	
	//2. 조건조회 >> select ..where deptno=? >> parameter 설정 >> return Single row
	public Dept getDeptListByDeptno(int deptno) {
		//DB연결 >> 명령  >> 명령실행  >> 처리
		Dept dept = null; //

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname, loc from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dept = new Dept(); // 하나의 row 담기 위한 객체
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return dept;
	}
	
	//3. 데이터 삽입
	//public int insertDept(int deptno , String dname, String loc) ... 
	public int insertDept(Dept dept) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, dept.getDeptno());
			 pstmt.setString(2, dept.getDname());
			 pstmt.setString(3, dept.getLoc());
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
    
	//4. 데이터 수정 (수정할 컬럼 결정)
	//update dept set dname=? , loc=? where deptno=?
	public int updateDept(Dept dept) {
		//DB연결 >> 명령  >> 명령실행  >> 처리
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="update dept set dname=? , loc=? where deptno=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, dept.getDname());
			 pstmt.setString(2, dept.getLoc());
			 pstmt.setInt(3, dept.getDeptno());
			 
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	
	//5. 데이터 삭제 (1건)
	public int deleteDept(int deptno) {
		//DB연결 >> 명령  >> 명령실행  >> 처리
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="delete from dept where deptno=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, deptno);
			 rowcount = pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;

	}
}





