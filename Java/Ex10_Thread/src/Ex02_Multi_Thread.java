/*
 * Thread : 프로세스에서 하나의 최소 실행단위
 * 
 * Thread 생성하는 방법
 * 1. Thread 클래스를 상속 -> class Test extends Thread >> 새로운 stack에 올라갈 준비
 * 반드시 Thread 가지는 run() 구현
 * >> Thread는 일반 클래스 >> 스스로 객체 생성 가능
 * 
 * 2. Runnable 인터페이스 구현 -> class Test extends Car implements Runnable 
 * 자바는 다중상속이 불가하므로, 다른 클래스의 자식클래스를 쓰레드화하기 위해 
 * 
*/

class Thread_1 extends Thread{

    @Override
    public void run() { //run() >> main함수와 동일한 역할 //새로운 stack 처음 올라가는 함수
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread_1: "+i+this.getName());
        }
        System.out.println("Thread_1 run() END");
    }
    
}

class Thread_2 implements Runnable{  
    @Override
    public void run() { //run() >> main함수와 동일한 역할 //새로운 stack 처음 올라가는 함수
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread_2: "+i);
        }
        System.out.println("Thread_2 run() END");
    }
}

public class Ex02_Multi_Thread {

    public static void main(String[] args) {  //main도 하나의 Thread
        //1번
        Thread_1 th = new Thread_1();
        th.start();  //POINT >> call stack 하고 그 stack에 run()함수 올려놓음
        
        //2번
        Thread_2 th2 = new Thread_2(); //Thread가 아니다. 인터페이스만 구현한 클래스
        Thread thread = new Thread(th2);  //Thread 객체의 생성자 이용해서 쓰레드화
        thread.start();
        
        for (int i = 0; i < 1000; i++) {
            System.out.println("main: "+i);
            
        }System.out.println("Main END");
        
        
        

    }

}
