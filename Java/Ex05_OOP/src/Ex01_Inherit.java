/* OOP 특징
 * 1. 상속
 * 2. 캡슐화(은닉화) >> private
 * 3. 다형성 (요즘은 상속보다 다형성을 선호한다)
 * 
 * 
 * 1. 상속 표현
 * java: child extends Base
 * C#: child : Base
 * 
 * 2. 상속 특징
 * 2.1 다중 상속은 불가능
 * 2.2 단일상속(계층적 상속지원: 통해서 여러 개의 클래스를 상속...)
 * 2.3 다중상속을 지원(유일한 자원: Interface)
 * 
 * 3. 상속의미
 * 3.1 진정한 의미: 재사용성 (장점)
 * 3.2 단점: 초기 비용(설계)가 많이 듬
 * 
 * 재사용성 >> 설계 >> 비용(시간, 공통자원(분모, 추상화))
 * 
 * 4. 상속관계에서 Memory?
 * GrandFather > Father > Child
 * 사용자가 만드는 모든 클래스는 default로 Object라는 클래스를 상속받음
 * class Car{} >> 내부적으로 >> class Car extends Object{}
 * Object는 모든 클래스의 root(최상위) : 모든 클래스의 부모클래스
*/
class GrandFather {
    public GrandFather() {
        System.out.println("GrandFather");
    }
    public int gmoney = 5000;
    private int pmoney=10000;  //private : 접근 불가: 해당 클래스 내부에서만 사용(캡슐화)
}

class Father extends GrandFather {
    public Father() {
        System.out.println("Father");
    }
    public int fmoney = 1000;
}

class Child extends Father {
    public Child() {
        System.out.println("Child");
    }
    public int cmoney = 500;
}






public class Ex01_Inherit {

    public static void main(String[] args) {
        Child ch = new Child();
        System.out.println(ch.gmoney);  //할아버지 돈 내 돈
        System.out.println(ch.fmoney);  //아버지 돈 내 돈
        System.out.println(ch.cmoney);  //내 돈
        
        
        
        
        
        
        
        
        
        

    }

}
