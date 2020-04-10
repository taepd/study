import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DAO.DeptDao;
import DTO.Dept;

public class Program {

	public static void main(String[] args) {
		//화면과 로직
//		DeptDao dao = new DeptDao();
//		Dept dept = new Dept();
//		dept.setDetpno(50);
//		dept.setDname("IT");
//		dept.setLoc("SEOUL");
//		int row = dao.insertDept(dept);
		
		Scanner sc = new Scanner(System.in);
		
//		전체 조회
		DeptDao dao = new DeptDao();
		System.out.println("[전체조회]**********");
		List<Dept> deptlist = dao.getDeptAllList();
		//화면출력
		if(deptlist != null) {
			DeptPrint(deptlist);
		}
		
		//조건 조회
//		DeptDao dao = new DeptDao();
		Dept dept;
		int deptno;
		String dname, loc;
		System.out.println("[조건 조회]***********");	
		System.out.println("조회할 deptno를 입력해 주세요");
		deptno = Integer.parseInt(sc.nextLine());
		dept = dao.getDeptListByDeptno(deptno);
		System.out.println(dept.toString());
	
		//데이터 삽입
		System.out.println("[데이터 삽입]**********");
		System.out.println("입력할 deptno를 입력해 주세요");
		deptno = Integer.parseInt(sc.nextLine());
		System.out.println("입력할 dname을 입력해 주세요");
		dname = sc.nextLine();
		System.out.println("입력할 loc을 입력해 주세요");
		loc = sc.nextLine();
		dao.insertDept(new Dept(deptno, dname, loc));
		
		//데이터 수정
		System.out.println("[데이터 수정]**********");
		System.out.println("바꾸고자 하는 row의 deptno를 입력해 주세요.");
		deptno = Integer.parseInt(sc.nextLine());
		dept = dao.getDeptListByDeptno(deptno);
		dao.updateDept(dept);
		
		//데이터 삭제
		System.out.println("[데이터 삭제]**********");
		System.out.println("삭제하고자 하는 row의 deptno를 입력해 주세요.");
		deptno = Integer.parseInt(sc.nextLine());
		dao.deleteDept(deptno);
		if(deptlist != null) {
			DeptPrint(dao.getDeptAllList());
		}
		
	}
	public static void DeptPrint(Dept dept) {
		System.out.println(dept.toString());
	}
	public static void DeptPrint(List<Dept> list) {
		for(Dept dept : list) {
			System.out.println(dept.toString());
		}
	}

}
