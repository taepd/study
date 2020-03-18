import java.util.ArrayList;

/*
 * 8가지 기본 타입(값타입) : JAVA API 제공
 * 
 * 8가지 기본 타입에 대해서 객체 형태로 사용가능 하도록 만든 것 (wrapper class)
 * 
 * 기본 타입을 때로는 객체 형태로 다루어야 할 때가 있음
 * 1. 매개변수로 객체가 요구될 때
 * 2. 기본형 값이 아닌 객체로 저장되어야 할 때
 * 3. 객체 간 값 비교가 필요할 때
 * 4. 타입 변환시 처리하기 위해
*/

public class Ex08_Wrapper_Class {

    public static void main(String[] args) {
        int i = 100;
        Integer n = new Integer(500); //()안에 int값 넣으면 됨
        System.out.println("n : "+ n);  //사실 주소값이 출력되어야 하지만, toString이 오버라이딩돼서 값이 출력
        System.out.println(n.MAX_VALUE);
        System.out.println(n.MIN_VALUE);
        
        //POINT 활용 ...
        //parameter 활용
        //generic
        
        ArrayList<Integer> li = new ArrayList<Integer>();
        li.add(100);
        li.add(200);
        for(int value : li) {
            System.out.println(value);
        }
        
        Integer i2 = new Integer(100);
        Integer i3 = new Integer(100);
        
        int i4=100;
        int i5=100;
        System.out.println(i4==i5);   //true
        
        System.out.println(i2==i3);   //false. 이건 주소값 비교이기 때문
        System.out.println(i2.equals(i3)); //값을 비교하려면 이렇게 비교해야 한다
        
        Integer t = new Integer(500);
        integerMethod(t); //t라는 참조변수의 주소값
        intMethod(t);    //t라는 참조변수가 가지는 값. 이어야 하지만 toString 오버라이딩에 의해 값 출력
        
    }
    
    static void integerMethod(Integer i) {
        System.out.println("integer param: "+ i);  //toString() 오버라이딩에 의해 값 출력
        System.out.println(i.MAX_VALUE);
    }
    
    static void intMethod(int i) {
        System.out.println("int param: "+ i);
    }

}
