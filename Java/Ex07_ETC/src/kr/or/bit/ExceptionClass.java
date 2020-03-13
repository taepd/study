package kr.or.bit;
import java.io.IOException;
/*
 * 설계도(class) 만들 때
 * 내 설계도를 사용하는 개발자가 예외를 처리해 주었으면 [강제로]
 * 
 * 예외처리 강제
 * 생성자 throws IOException NullPointerException > throw's'인 이유: 여러 예외 나열할 수 있음
 * 함수 throws 도 마찬가지
 * 
*/

public class ExceptionClass {
    public ExceptionClass(String path) throws IOException, NullPointerException{  //이 생성자를 쓰면 이런 문제가 생길 수 있다고 알려줌  //예외처리를 하도록 강제
        
    }
    
    public void call() throws ArithmeticException, IndexOutOfBoundsException{
        System.out.println("call 함수 start");
        int i = 0/0;
        System.out.println("call 함수 end");
        
    }

}
