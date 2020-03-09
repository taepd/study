import kr.or.bit.Emp;

public class Ex05_Array_Object {

    public static void main(String[] args) {
        
        //1. 사원 3명을 만드세요 (단 배열을 사용하세요)
        //1000, "홍길동"
        //2000, "김유신"
        //3000, "유관순"
        //각각의 정보를 출력하세요
        
        Emp[] emplist = new Emp[3];
//        for(int i=0;i<emplist.length;i++) {
//            emplist[i] = new Emp();
//        }
//        emplist[0].setEmpno(1000);
//        emplist[0].setEname("홍길동");
//        
//        emplist[1].setEmpno(2000);
//        emplist[1].setEname("김유신");
//        
//        emplist[2].setEmpno(3000);
//        emplist[2].setEname("유관순");
        
        emplist[0] = new Emp(1000,"홍길동");
        emplist[1] = new Emp(2000,"김유신");
        emplist[2] = new Emp(3000,"유관순");
        
        //2. 사원 3명의 사번과 이름을 출력하세요
        for(int i=0;i<emplist.length;i++) {
            System.out.println(emplist[i].getEmpno()+"/"+emplist[i].getEname());
        }
        
        //int[] arr = new int[]{10,20,30}
        
        //사원 2명 만드세요
        
        //두 번째 방법으로
        
        Emp[] emplist2 = new Emp[] {new Emp(1,"이씨"), new Emp(2,"박씨")};
        for(int i=0;i<emplist2.length;i++) {
            System.out.println(emplist2[i].getEmpno()+"/"+emplist2[i].getEname());
        }
        
        
        //int[] arr ={10,20}
        Emp[] emplist3 = {new Emp(3,"김씨"), new Emp(4,"최씨")};
        
        for(int i=0;i<emplist3.length;i++) {
            System.out.println(emplist3[i].getEmpno()+"/"+emplist3[i].getEname());
        }
        
        
        
        
        
        
        
        
        
        
        

    }

}
