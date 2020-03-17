package kr.or.bit;

//아래와 같은 class를  (데이터를 담은 클래스)
//vo(value object), dto(data transfer object), domain 이라 통칭 
public class Emp {
    private int empno;
    private String ename;
    private String job;
    
    public Emp(int empno, String ename, String job) {
        super();
        this.empno = empno;
        this.ename = ename;
        this.job = job;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + "]";
    }
    
    
}
