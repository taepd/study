/*
 * this : 객체 자신을 가리키는 참조변수 (this.empno)
 * this() : 생성자를 호출하는 this 메서드 (this(100,"홍길동")
 * 
 * 상속
 * 부모: 자식
 * super(현재 자식이 부모에 접근하는 주소값) : super(부모의 주소)
 * 
 * super
 * 1. 상속 관계에서 자식이 부모 자원에 접근
 * super()
 * 2. 상속 관계에서 부모의 생성자를 호출하는 메서드
 * 
*/

class Base{
    String basename;
    Base(){
        System.out.println("Base 기본 생성자 함수");
    }
    Base(String basename){
        this.basename = basename;
        System.out.println("bname : "+this.basename);
    }
    void method() {
        System.out.println("부모 method");
    }
}

class Derived extends Base{
    String dname;
    Derived(){
        System.out.println("Derived 기본 생성자 함수");
    }
    
    Derived(String dname){
        //자식 입장에서 부모쪽 제어위해선 부모의 주소가 필요
        super(dname);  //부모의 String 타입 매개변수 하나를 갖는 생성자 호출해서 dname 입력
        this.dname = dname;
        System.out.println("dname : "+this.dname);
    }
    @Override
    void method() {
        System.out.println("자식 method");
    }
    //어느날 부모의 자원이 그리워 부모 method 함수를 호출하고 싶을 때
    //유일한 방법: super  (자식의 함수 내에서만 사용 가능)
    
    void p_method() {
        super.method();
    }
    
}

public class Ex06_Inherit_Super {

    public static void main(String[] args) {
//        Derived d = new Derived();
        Derived d = new Derived("Hello");
        d.method();
        d.p_method();

    }

}
