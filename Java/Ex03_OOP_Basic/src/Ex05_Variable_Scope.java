/*
instance variable >> class Car {public String color;}
local variable >> class Car {public void move() {int speed}}
main 함수 안에 있는 모든 변수는 : lv >> 초기화가 필요하다
static variable >> 객체간 공유자원, 객체 생성 이전에 memory에 올라가는 자원
*/

class Variable {
    int iv;
    /*
     * 1. member field, instance variable
     * 2. Variable v = new Variable(); new연산자를 통한 인스턴스 생성을 통해 heap메모리에 iv가 생성
     *    Variable v2 = new Variable(); heap메모리에 iv가 또 생성
     * 3. 목적: 정보를 담으려 한다 (정보에 맞는 Type을 가져야 한다)
     *    -정보(속성) >> 고유, 상태, 부품(참조)
     *    -정보는 생성되는 객체마다 다른 값을 가질 수 있다.
     *    -그러기 때문에 굳이 초기화를 하지 않아도 된다.
     *    -기본적으로 default값을 가지고 있다 : int > 0, float > 0.0, boolean >> false, 참조타입 >> null
     * 4. -new라는 연산자를 통해서 heap 객체가 만들어지고 나서 바로 변수 생성
     */
    static int cv;
    /*
     * 1. class variable(클래스 변수), static variable ((객체 간)공유 변수)
     * 2. 목적: 정보를 담는 것 ***생성되는 모든 객체가 공유하는 자원*** : 객체간 공유자원
     *    heap 영역에 생성된 객체들의 공통 자원(공유 자원)
     * 3. 특징: 접근 방법 : 클래스이름.static변수명(객체가 만들어 지지 않은 상황에서도 접근 가능)
     * ex) Math.Random()을 사용하기 위해서 Math m = new Math() >> m.Random() 하지 않음
     *         접근 방법2: 누구의 것도 아니기에 >> 참조변수.static변수명 
     * ex) Variable v = new Variable();
     *     Variable v2 = new Variable();
     *     1. variable.cv   클래스 이름으로
     *     2. v.cv          참조 주소로
     *     3. v.cv2         참조 주소로    다 접근 가능
     * 4. 생성시점: Hello.java > javac Hello.java > Hello.class
     *            >java.exe Hello 엔터 실행...  
     *            >class loader System에 의해서 
     *            >클래스 정보(metadata: 설명)를 class area(method area)에 올림
     *             이 클래스를 언제 만들었고 어떤 자원을 import 하고 있고 변수가 몇 개.. 기술...
     *             이 클래스 안에 static variable 또는 static method 있으면
     *             이 녀석을 memory(class area)에 올려 놓는다               
    */
    void method() {
        int lv = 0;
        /*
         * local variable (함수 지역변수: 사용 전에 반드시 초기화)
         * 생명 주기: 함수 호출되면 생성되었다가... 함수 끝나면 같이 소멸
         * 함수 안에는 제어문 존재 그 안에 블럭 변수도 지역 변수
         * for(int i...) >> i변수는 for이 실행되면 생성... for 끝나면 소멸
        */
    }
    
}



public class Ex05_Variable_Scope {

    public static void main(String[] args) {
        Variable.cv = 100;
        Variable v = new Variable();
        Variable v2 = new Variable();
        v2.cv = 500;
      
        
        
        
        
        
        
        
        
        
        
        
       
    }

}
