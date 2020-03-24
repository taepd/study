/*
 * 동기화
 * 한강 고수부지 화장실(공유자원) : 여러 개의 스레드가 동시에 접근 가능한 자원
 * 화장실 1개(자원 1개), 사람 10명(Thread 10개)
 * 
 * 비동기화
 * 한강 비빔밥 축제: 동시접근 허용
 * 
 * 객체: lock
 * 함수: lock
*/

class Wroom{
    synchronized void openDoor(String name) {   //synchronized 동기화 걸어준 것
        System.out.println(name + "님 화장실 입장^^");
        for (int i = 0; i < 100; i++) {
            System.out.println(name + "사용: "+i);
            if(i==10) {
                System.out.println(name + "님 끙~~");
            }
        }
        System.out.println("시원하다 ^^!");
    }
}

class User extends Thread{
    Wroom wr;
    String who;
    
    User(String name, Wroom w){
        this.who=name;
        this.wr =  w;
    }
    @Override
    public void run() {
        wr.openDoor(this.who);
    }
    
    
}

public class Ex10_Sync_Thread {

    public static void main(String[] args) {
        //한강 둔치
        Wroom w = new Wroom();
        
        //사람들
        User kim = new User("김씨", w);
        User park = new User("박씨", w);
        User lee = new User("이씨", w);
        
        //사람들 배가 아파요
        
        kim.start();
        park.start();
        lee.start();
        
        
        
        

    }

}
