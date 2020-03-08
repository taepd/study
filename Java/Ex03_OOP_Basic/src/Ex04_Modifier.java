import kr.or.bit.Car;

/*
접근자(한정자) : Ex04_modifier
    public (공유: package 구분(폴더) 구분없이 모든 자원 공유)
    private (개인: 클래스 내부 공유자원, 참조변수 입장에서 접근 불가(사용 불가))
    
    
객체지향언어 특징
    1. 캡슐화(은닉화)
    1.1 클래스 내부에 있는 자원(member field, method)에 적용
        private int number;   직접 할당을 막고 간접 할당을 통해서 자원을 보호(방법: setter, getter)
        private void call();  다른 함수의 보조, 공통 함수
    1.2 [직접 할당]
    public class Car {public int door;} >> Car c = new Car(); c.door=100; <- 이게 직접 할당
        만약에 원치 않는 c.door = -1  넣으면, 
    public class Car {private int door;} <이렇게 하면 아무도 못씀 
    
    public class Car {
        private int door;                  
        public void writeDoor(int data){   //door변수 write 
            if(data>=0){
                door=data;
            }else{
                door=0;
            }
        }
        public int readDoor(){   //door변수 read
            return door;
        }    
     }
     
     Car c = new Car(); c.writeDoor(10); c.writeDoor(-1); >> door >>0
                        int result=c.readDoor();
                        
          이렇게 항상 private 변수 하나 당 함수 2개(write,read)를 쓰는건 불편하다. 그래서,
     java에서는 특수한 목적의 함수: setter(private 자원write), getter(private 자원 read) 
          필요에 따라  setter, getter 둘 중 하나만 생성해서 사용 가능 
          
          
*/



public class Ex04_Modifier {

    public static void main(String[] args) {
        
        Car c = new Car();
        
//        c.writeSpeed(100);
//        int result = c.readSpeed();
//        System.out.println("현재속도 : "+result);
        
        c.setSpeed(-100);
        int result = c.getSpeed();
        System.out.println("속도: "+result);
        
        c.speedUP();
        c.speedUP();
        c.speedUP();
        result=c.getSpeed();
        System.out.println("속도: "+result);
        c.speedDown();
        c.speedDown();
        c.speedDown();
        c.speedDown();
        c.speedDown();
        result=c.getSpeed();
        System.out.println("속도: "+result);
    }

}
