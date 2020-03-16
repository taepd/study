/*
 * User 사용자: provider 제공자
 * 
 * class A {}, class B{}
 * 관계: A는 B를 사용합니다
 * 
 * 1. 상속: A extends B
 * 2. 포함: A클래스 안에서 Member Field B 사용 >> class A {B b;}
 * 
 * 2.1 전체 포함
 * 
 * class B{}
 * class A{
 *      int i;
 *      B b; //A는 B를 사용합니다... 포함
 *      A(){
 *          b= new B();
 *      }
 * }
 * A a = new A();  >> A객체가 만들어지면 B객체도 같이 생성  >> A객체가 사라지면 B객체도 사라짐
 * ---------------------------------------------
 * 2.2 부분 포함
 * 
 * class B{}
 * class A{
 *      int i;
 *      B b;  //A는 B를 사용합니다... 포함
 *      A(B b){
 *          this.b = b
 *      }
 * }
 * 
 * B b = new B();
 * A a = new A();   >> A와 B 객체가 별개로 존재
 * --------------------------------------
 * 3. 의존
 * class B{}
 * class A{
 *      int i;
 *      //위와의 차이: member field B라는 타입을 가지는 변수가 없다
 *      void print(B b){}
 *      
 *      B print(){
 *          B b = new B();
 *          return B;
 *      }
 * }
 * 
 * >>B b = new B();
 * >> A a = new A();
 * 
 * a.print(b);          //이렇게도 되고    >> 아래 예제는 이 방법 활용
 * B b2 = a.print();   //두 가지로 사용 가능      
 * 
 * 
 * ***** parameter로 사용되는 타입을 직접 명시*****
 * 
 *    
*/

interface Icall{
    void m();
}

class D implements Icall{

    @Override
    public void m() {
        System.out.println("D가 Icall 인터페이스의 m() 구현");
    }
    
}

class F implements Icall{

    @Override
    public void m() {
        System.out.println("F가 Icall 인터페이스의 m() 구현");
    }
    
}

//interface 활용  >> 현대에 있어서 프로그래밍 경향 >> 유연하게
//의존관계에서 interface 활용법
class C{
    void method(Icall ic) { //함수 ic 변수는 어떤 타입의 객체를 받을 수 있을까요
        ic.m();
    }
}




public class Ex_05_User_Provider {

    public static void main(String[] args) {
        C c = new C();
        D d = new D();
        F f = new F();
        c.method(d);
        c.method(f);  //둘 다 가능하다. 인터페이스 활용의 장점
        
        
        
        
        
        
        
    }

}
