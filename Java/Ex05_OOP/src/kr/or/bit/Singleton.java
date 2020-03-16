package kr.or.bit;
//<싱글톤 패턴>
//디자인 패턴(생성패턴) >> new >>객체를 만드는 방법
//객체 하나를 만들어서 공유
//회사: 공유프린터

//보장: 객체의 주소가 항상 동일하다. 
//즉, 클래스 영역의 p를 모든 객체 참조변수의 주소값이 되게 해서 힙 메모리에 하나의 객체만 생성하고 사용하게 된다.

//활용: JDBC: JAVA <- (JDBC: CRUD) -> DB

//main
//Singleton singleton = new Singleton(); //생성자 호출 >> 노출x(private)
public class Singleton {
    
    private static Singleton p;   //private static으로 클래스타입 변수 생성
    private Singleton() { //생성자(default)  //직접 객체 생성 불가하게 private 생성자 선언
        
    }
    public static Singleton getInstance() {   //getInstance 메서드를 통해 객체 생성 시 단일한 객체만 참조하게 함
        if(p==null) {
            p=new Singleton(); //singleton = new Singleton(); 
                                 //클래스 내부에서는 public, private을 구분하지 않음
        }
        return p;
    }
    
    
    
    

}
