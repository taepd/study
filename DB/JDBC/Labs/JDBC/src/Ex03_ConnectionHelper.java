import java.sql.*;
import java.sql.SQLException;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex03_ConnectionHelper {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn = ConnectionHelper.getConnection("Oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println("연결여부: "+conn.isClosed()); 
		ConnectionHelper.close(conn);
		System.out.println("연결여부: "+conn.isClosed()); 
		
//		Connection conn1 = ConnectionHelper.getConnection("Oracle");
//		System.out.println(conn1.toString());
//		
//		Connection conn2 = ConnectionHelper.getConnection("Oracle");
//		System.out.println(conn2.toString());  
//		oracle.jdbc.driver.T4CConnection@3fd7a715
//		oracle.jdbc.driver.T4CConnection@711f39f9
		//주소가 다르다. getConnection은 내부에서 new 작업을 통해서 연결 객체를 생성
		//그런데 하나의 APP 연결객체 하나만 사용해도 되지 않나?
		//하나를 만들어서 재사용(공유)	>> singleton
		
		Connection conn3 = ConnectionHelper.getConnection("Oracle","hr" , "1004");
		System.out.println(conn3.toString());
		System.out.println(conn3.getMetaData().getDatabaseProductName());
		Connection conn4 = ConnectionHelper.getConnection("Oracle","bit" , "1004");
		System.out.println(conn4.toString());
		System.out.println(conn4.getMetaData().getDatabaseProductName());
		
		///////////////////////////////////////
		//싱글톤 활용
		
		Connection sconn = SingletonHelper.getConnection("Oracle");
		System.out.println(sconn.toString());
		sconn = SingletonHelper.getConnection("Oracle");
		System.out.println(sconn.toString());
		//다른 DB연결하려면 싱글톤 커넥션 객체를 close하고 null 초기화도 해줘야 한다. 그 작업은 해놓은게 dbclose()
		ConnectionHelper.close(sconn);
		sconn = SingletonHelper.getConnection("mysql");
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
