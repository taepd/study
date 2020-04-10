import java.sql.*;
import java.util.Scanner;

/*
 * DML(insert, update, delete)
 * JDBC API 통해서
 * 1. 결과 집합이 없다 <-> select(결과 집합 있다)
 * 2. 반영 결과 row return
 * java 코드
 * update emp set sal=0 >>14건 변경 >>return 14
 * update emp set sal=0 where empno=11111 >> return 0 >>11111 사원이 없기 때문에
 * java 코드를 활용해서 return을 활용해 로직을 짤 수 있다
 * 
 * KEY POINT
 * 1. Oracle에서 DML 작업(Tool, cmd)하면 반드시 commit or rollback 강제
 * 2. JDBC API에서는 기본값이 auto commit
 * 3. java code: delete from emp >> 실행 >> 자동 commit >> 실반영
 * 4. >> 필요에 따라서 commit(), rollback()을 java코드에서 제어 가능
 * 
 * 
ex)
시작
 A계좌 인출(update)
  ..
 B게좌 입금(update)
끝(commit을 강제할 수 있다.)
>>하나의 논리적 단위(transaction)로써의 작업이 필요
>>auto commit옵션을 >> false로 가능
>>자바코드에서 명시적으로 commit과 rollback을 호출할 수 있다.
*/



public class Ex02_Oracle_DML {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//DriverManager.getConnection: Oracle 서버와의 연결 주소값(연결 객체의 주소값)을 리턴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bit","1004"); //주소찾기
			System.out.println(conn.isClosed()); //false가 나와야 연결된 것
			
			stmt = conn.createStatement();
			
			
			int empno=0;
			String ename="";
			int deptno=0;
			
			/*
			//insert
			Scanner sc = new Scanner(System.in);
			System.out.println("사번입력:");
			empno = Integer.parseInt(sc.nextLine());
			
			System.out.println("이름입력:");
			ename=sc.nextLine();
			
			
			System.out.println("부서번호입력:");
			deptno=Integer.parseInt(sc.nextLine());
						
			//insert into dmlemp(empno,ename,deptno) values(100,'홍길동',10);
			
			//무식한 코드
			String sql="insert into dmlemp(empno,ename,deptno) ";
			sql+="values("+empno+",'"+ename+"',"+deptno+")";
			
			//실제) parameter 사용
			//values(?,?,?);
			
			//executeUpdate() >> insert, update, delete 다 한다
			int resultrowcount = stmt.executeUpdate(sql);
			
			if(resultrowcount >0) {
				System.out.println("반영된 행의 수 : "+ resultrowcount);
			}else {
				//0또는 작은 경우..
				System.out.println("실패: "+resultrowcount);
			}
			
			//insert 실패한 경우: stmt.executeUpdate(sql) 실행 시 발생 예외
			//resultrowcount 값을 반환 받기 전에 발생
			//1. pk 위반
			//2. 컬럼의 길이
			//3. 타입 설정 오류
			*/
			
			/*
			//update
			Scanner sc = new Scanner(System.in);
			System.out.println("부서번호입력:");
			deptno=Integer.parseInt(sc.nextLine());
			
			String sql="update dmlemp set sal=0 where deptno="+deptno;
			
			int resultrowcount = stmt.executeUpdate(sql);
			
			if(resultrowcount >0) {
				System.out.println("반영된 행의 수 : "+ resultrowcount);
			}else {
				//0또는 작은 경우..
				System.out.println("실패: "+resultrowcount);
			}
			*/
			
			//delete
			//delete from dmlemp where deptno=?
			Scanner sc = new Scanner(System.in);
			System.out.println("부서번호입력:");
			deptno=Integer.parseInt(sc.nextLine());
			
			String sql="delete from dmlemp where deptno="+deptno;
			
			int resultrowcount = stmt.executeUpdate(sql);
			
			if(resultrowcount >0) {
				System.out.println("반영된 행의 수 : "+ resultrowcount);
			}else {
				//0또는 작은 경우..
				System.out.println("실패: "+resultrowcount);
			}
			
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
