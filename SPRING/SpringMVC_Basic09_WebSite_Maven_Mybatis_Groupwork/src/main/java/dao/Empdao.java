package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import dto.Admin;
import dto.Emp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public interface Empdao {
	
	public Admin getAdmin(String id);

	// 전체 데이터 read (where 조건절이 없어요)
	public List<Emp> getEmpList(int cpage, int pagesize); 

	// 사원 상세정보 보기
	public Emp getDetail(int empno);

	// Insert
	// 사원 등록
	// Parameter (id,ename,cotent)
	// 권장: public int insertMemo(memo m){} >> FrameWork 자동화..
	public int insertEmp(Emp emp);

	// Update
	// 사원 정보 수정
	// Update
	// 사원 정보 수정
	public int updateEmp(Emp emp);

	// Delete
	// 사원정보 삭제
	public int deleteEmp(int empno);

	// 추가함수 (사원번호 존재 유무 판단 함수)
	public String isCheckByEmpno(int empno);

	public int getEmpCount();

	// 사원번호로 검색하기
	public List<Emp> getEmpListByEmpno(int empno);

	// 부서번호로 검색하기
	public List<Emp> getEmpListByDeptno(int deptno);

	// 차트 데이터
	public JSONArray getEmpChartJob();

	//ajax 직종 불러오기
	public List<String> getEmpJob();
	
	//ajax 부서번호 불러오기
	public List<Integer> getDeptno();
	
	// datatable용 emplist데이터
	public JSONArray getJsonEmpList();
	

}
