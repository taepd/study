import kr.or.bit.Emp;


class Test2{
    void print() {
        System.out.println("부모함수(Test2)");
    }
}

class Test3 extends Test2{
    @Override
    void print() {
        System.out.println("자식이 부모함수를 재정의");
    }
    //오버로딩(상속과 상관이 없다)
    void print(String str) {
        System.out.println("나 오버로딩 함수야^^"+str);
    }
}


public class Ex05_Inherit_Override {

    public static void main(String[] args) {
        
        Emp emp = new Emp(1000,"김유신");
//        System.out.println(emp.toString()); //kr.or.bit Emp@15db9742
//        System.out.println(emp);  //kr.or.bit.Emp@15db9742 같은 결과값. toString()을 생략해도 쓴 것으로 컴파일 해 줌
        
        System.out.println(emp.toString()); //Emp [empno=1000, ename=김유신]  :toString 오버라이딩
        System.out.println(emp);  //Emp [empno=1000, ename=김유신]   :생략된 toString 오버라이딩. 컴파일이 알아서 적용해  줌 
        
        Test3 test3 = new Test3();
        test3.print();
        test3.print("오버로딩");
        
        
    }

}
