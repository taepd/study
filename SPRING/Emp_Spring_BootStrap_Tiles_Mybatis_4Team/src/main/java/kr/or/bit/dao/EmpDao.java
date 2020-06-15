package kr.or.bit.dao;

import java.util.List;

import kr.or.bit.dto.Admin;
import kr.or.bit.dto.Emp;

public interface EmpDao {
	public List<Emp> getEmpList(int cpage, int pagesize);
	
	public Emp getDetail(int empno);
	
	public int insertEmp(Emp emp);
	
	public int updateEmp(Emp emp);
	
	public int deleteEmp(int empno);
	
	public String isCheckByEmpno(int empno);
	
	public Admin getAdmin(String id);
	
	public List<Emp> getEmpListByEmpno(int empno);
	
	public List<Emp> getEmpListByDeptno(int deptno);
	
	public List<String> getEmpJob();
	
	public List<Integer> getDeptno();
	
	public int getEmpCount();

}
