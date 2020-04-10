import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.SingletonHelper;

public class Ex05_Oracle_Prepare_DML {

	public static void main(String[] args) {
		//insert
		//insert into dmlemp(empno,ename,deptno) values(?,?,?)
		//update
		//update dmlemp set ename=?, sal=?, job=?, deptno=?
		//where empno=?
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		try {
			conn= SingletonHelper.getConnection("Oracle");
			String sql = "update dmlemp set ename=?, sal=?, job=?, deptno=? where empno=?";
			pstmt = conn.prepareStatement(sql);
			
			//parameter 설정하기
			pstmt.setString(1,  "홍길동");
			pstmt.setInt(2, 5000);
			pstmt.setString(3, "IT");
			pstmt.setInt(4, 20);
			pstmt.setInt(5,9999);
			
			//실행
			int row = pstmt.executeUpdate(); //쿼리문은 이미 DB서버에 컴파일돼서 존재
			if(row>0) {
				System.out.println("update row count : "+ row);
			}else {
				System.out.println("row count" + row);
			}
		} catch (Exception e) {
		}

	}

}
