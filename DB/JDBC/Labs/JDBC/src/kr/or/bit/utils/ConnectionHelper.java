package kr.or.bit.utils;
/*
 * 전체 프로젝트(회원: 전체 조회, 조건 조회, 삭제, 수정.. 각각 페이지 별도 구현)
 * 각각의 페이지에 공통적으로 필요한 요소...
 * (반복적인 코드)
 * 1. 드라이버 로딩
 * 2. 연결, 객체, 자원해제
 * 3. 반복적인 코드는 ... 제거
 * 4. Oracle, Mysql 사용 연동
 * 5. 공통 설계도 
 * 6. ConnectionHelper 클래스 >> 기능(method) 자주  >> static >> overloading >> 다형성
 * 7. 패턴 >> 하나의 객체 공유 >> singleton
*/

import java.sql.*;


public class ConnectionHelper {
	 //oracle, mysql 하나의 함수... dsn > oracle, mysql
	
	
	//연결 설정
	public static Connection getConnection(String dsn) {
		Connection conn=null; 		
		try {
			if(dsn.equals("Oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bit","1004");
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","bit","1004");
			}
		
		} catch (Exception e) {
		}
		
		return conn;
	
	}	
	public static Connection getConnection(String dsn, String id, String pwd) {
		Connection conn=null; 	
				try {
			if(dsn.equals("Oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",id,pwd);
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","bit","1004");
			}
		
		} catch (Exception e) {
		
		
		}return conn;
	}
	
	//연결해제
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	
	
}
