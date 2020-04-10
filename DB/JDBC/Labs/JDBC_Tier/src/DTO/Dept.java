package DTO;

/*
 * Dept 클래스는 (DTO, VO, Domain)
 * DB 테이블과 1:1 매핑
 * Dept 테이블의 데이터를 1건 담을 수 있는 클래스
 * Dept dept = new Dept(); 1건
 * List<Dept> deptlist = new ArrayList<Dept>();
*/
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	public int getDetpno() {
		return deptno;
	}
	public Dept(){};
	
	public Dept(int deptno, String dname, String loc){
		this.deptno=deptno;
		this.dname=dname;
		this.loc=loc;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int detpno) {
		this.deptno = detpno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [detpno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	

}
