package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DTO.Dept;
import Utils.SingletonHelper;

/*
 * DAO
 * 1. DB연결
 * 2. CRUD 함수
 * 3. 하나의 테이블을 대상으로 () >> Dept 테이블 대상으로 함 수 몇 개 만들까요
 * (select(전체조회), select(1건 ... 조건(pk)), insert, update, delete)
*/
public class DeptDao {
	
	//1. 전체조회 >> select 결과 >> return Multi row
	public List<Dept> getDeptAllList(){
		//DB연결 >> 명령 >> 명령실행 >> 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> deptlist = new ArrayList<Dept>();
		try {
			conn = SingletonHelper.getConnection("Oracle");
			String sql = "select deptno , dname , loc from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	//excuteQuery: select 문을 처리하는 메서드
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				deptlist.add(dept); // [dept][dept]...
			}
		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
	
		return deptlist;
	}
	
	//2. 조건조회>> select .. where deptno=? >> parameter 설정 >> deptno가 pk이므로 return은 single row
	public Dept getDeptListByDeptno(int deptno) {
		//DB연결 >> 명령 >> 명령실행 >> 처리		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept dept = null;
		try {
			conn=SingletonHelper.getConnection("Oracle");
			String sql = "select deptno, dname, loc from dept where deptno="+deptno;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}			
			
		} catch (Exception e) {
			System.out.println("예외: "+ e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//연결은 계속 지속 app살아있는 한	
		}	
		return dept;
	}
	
	//3. 데이터 삽입
//	public int insertDept(int deptno, String dname, String loc) 이보다는
	public int insertDept(Dept dept) {
		//DB연결 >> 명령 >> 명령실행 >> 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row=0;
		try {
			conn=SingletonHelper.getConnection("Oracle");
			String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//객체 설정하기
			pstmt.setInt(1,  dept.getDetpno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			//실행
			row = pstmt.executeUpdate(); // excuteUpdate: insert, update, delete문 처리하는 메서드
			if(row>0) {
				System.out.println("insert row count : "+ row);
				System.out.println(getDeptListByDeptno(dept.getDeptno()).toString());
			}else {
				System.out.println("row count" + row);
			}
					
		
			
		} catch (Exception e) {
			System.out.println("예외: "+ e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//연결은 계속 지속 app살아있는 한	
			
		}	
		return row;
	}
	//4. 데이터 수정(수정할 컬럼 결정)
	//update dept set dname=?, loc=? where deptno=?
	public int updateDept(Dept dept) {
		//DB연결 >> 명령 >> 명령실행 >> 처리
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row=0;
		try {
			conn=SingletonHelper.getConnection("Oracle");
			String sql = "update dept set dname=?, loc=? where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
			//parameter 설정하기
			pstmt.setInt(3, dept.getDetpno());
			System.out.println("수정할 dname을 입력해 주세요.");
			String dname = sc.nextLine();
			pstmt.setString(1, dname);
			System.out.println("수정할 loc을 입력해 주세요.");
			String loc = sc.nextLine();
			pstmt.setString(2, loc);
								
			//실행
			row = pstmt.executeUpdate(); //쿼리문은 이미 DB서버에 컴파일돼서 존재
			if(row>0) {
				System.out.println("update row count : "+ row);
				System.out.println(getDeptListByDeptno(dept.getDeptno()).toString());
			}else {
				System.out.println("row count" + row);
			}
					
		
			
		} catch (Exception e) {
			System.out.println("예외: "+ e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//연결은 계속 지속 app살아있는 한	
			
		}	
		return row;
	}
	
	//5. 데이터 삭제(1건)
	public int deleteDept(int deptno) {
		//delete from copyemp where deptno
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row=0;
		try {
			conn=SingletonHelper.getConnection("Oracle");
			String sql = "delete from dept where deptno="+deptno;
			pstmt = conn.prepareStatement(sql);						
			//실행
			row = pstmt.executeUpdate(); //쿼리문은 이미 DB서버에 컴파일돼서 존재
			if(row>0) {
				System.out.println("delete row count : "+ row);
			}else {
				System.out.println("row count" + row);
			}
					
		
			
		} catch (Exception e) {
			System.out.println("예외: "+ e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//연결은 계속 지속 app살아있는 한	
			
		}	
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
