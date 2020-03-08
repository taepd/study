import kr.or.bit.common.Car;

/*
 클래스 == 설계도 == 타입

 클래스 구성 요소: [필드+함수] + 생성자
 *필드(field) : 고유정보, 상태정보, 참조(부품)정보 자원을 담고 있는 변수
 *함수(function) : 기능 (행위 정보)
 *생성자(constructor) : 필드의 초기화를 목적으로 하는 함수
 
 클래스, 필드 , 생성자, 함수: 자신의 영역(범위) 정의(접근자, 한정자, 수정자)
 >접근제한자(Access Modifier) : public, private, default, protected 등

 1. public class Test{}

 2. class Test{} >> 컴파일러가 내부적으로 default라는 접근자를 붙여서 사용함
    defalut 접근자: 같은 폴더에서 접근 가능, 다른 폴더에 있으면 서로 접근 불가
    default
 3. 하나의 물리적인 자바 파일은 여러 개의 클래스를 가질 수 있다 
        단, 그럴 경우, public 클래스는 하나만 존재해야 한다    
    
    
    
    
    
    실습
    src 폴더 >> Ex01_main
    kr.or.bit.common >> public Bitmain
    kr.or.bit.common >> public Car
    kr.or.bit.common >> (default)Car
    
*/
//무조건 앞에 defualt가 생략되어 있음
class Test {
    int d_iv;  //컴파일러가 자동으로 default를 접근자로 해석
    public int p_iv; //어디에서나 공유가능
    private int pri_iv; //개인적인(감추어진/숨김)
}



public class Ex02_main {

    public static void main(String[] args) {
       Car car = new Car();
      // kr.or.bit.common.Person p = new Person(); // default 클래스라 같은 폴더에서만 접근 가능
       car.color="red"; // color는 public이라 접근 가능
      //car.door=100; //door는 default라 접근 불가능
       
       Test t = new Test();
       t.d_iv = 100; //default 접근 가능
       t.p_iv = 200; //public 접근 가능
       //t.pri_iv  // private 이라 접근 불가능
       
 
       
       
       

    }

}
