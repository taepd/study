package kr.or.bit;
//클래스 >> 목적>>  DTO, VO, DOMAIN

public class Emp { // class Emp extends Object
    private int empno;
    private String ename;

    //

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }
    // 필요하다면 setter, getter를 구현할 수 있다

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

    // 기능 (정보 출력)
    public void empInfoPrint() {
        System.out.println(this.empno + "/" + this.ename);
    }

    @Override
    public String toString() {
        return "Emp [empno=" + empno + ", ename=" + ename + "]";
    }

    // toString() 함수 주인은 Object
    // 상속 관계에서 ... toString() 내 멋대로 하고 싶어요
    // private > 설계한대로만 써 , public > 맘대로 재정의해서 써
    
    
    
    
    
    
    
    
    

}
