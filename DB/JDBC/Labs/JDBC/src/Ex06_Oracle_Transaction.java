import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.bit.utils.SingletonHelper;

/*
create table trans_A(
	num number,
	name varchar2(20)
);

create table trans_B(
	num number constraint pk_trans_B_num primary key,
	name varchar2(20)
);

JDBC >> default(DML) >> auto commit

JDBC >> autocommit >> false >> 개발자가 (commit, rollback 강제)

*/
public class Ex06_Oracle_Transaction {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		conn = SingletonHelper.getConnection("Oracle");
		String sql="insert into trans_A(num,name) values(100,'A')";
		String sql2="insert into trans_B(num,name) values(100,'B')";
		try {
			conn.setAutoCommit(false); //App에서 커밋, 롤백 할 수 있다
			//begin tran
			//transaction이므로 둘 다 성공, 둘 다 실패  경우만 있다
			pstmt=conn.prepareStatement(sql);
			pstmt.executeQuery();
			
			pstmt2=conn.prepareStatement(sql2);
			pstmt2.executeQuery();
			
			//여기까지 오면 >> 둘 다 성공이면
			conn.commit(); // 이 시점에서 실 반영
			System.out.println("commit");
			//end tran			
			
		} catch (Exception e) {
			//예외처리
			System.out.println("실패하면..."+e.getMessage());
			try {
				conn.rollback();
				System.out.println("rollback");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			SingletonHelper.close(pstmt2);
			SingletonHelper.close(pstmt);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
