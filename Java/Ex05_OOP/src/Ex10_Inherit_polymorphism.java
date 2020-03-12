/*
 * 다형성 (상속 관계에서 존재)
 * 다형성: 여러 가지 성질(형태)를 가질 수 있는 능력
 * 
 * C#: 다형성(overloading, override) 능력
 * 
 * JAVA: [상속 관계]에서 [하나의 참조변수]가 [여러 개의 타입]을 가질 수 있는 능력
 *       단, 하나의 참조변수는 [부모 타입]이어야 한다.
 *       부모 클래스 타입의 참조변수로 여러 개의 자식 클래스 객체를 참조 할 수 있다.
 *       
 * 다형성: 현실 세계와 반대: 자식은 부모에게 조건없이 드린다.
*/

class Tv2{   //부모(일반화, 추상화) 공통자원
    boolean power;
    int ch;
    
    void power() {
        this.power=!this.power;
    }    
    void chUp() {
        this.ch++;
    }
    void chDown() {
        this.ch--;
    }
}

class CapTv extends Tv2{  //Tv를 특수화, 구체화, 고유한 표현
    String text;
    String captionText() {
        return this.text = "현재 자막 처리 중...";
    }
}


public class Ex10_Inherit_polymorphism {

    public static void main(String[] args) {
        
        CapTv captv = new CapTv();
        captv.power();
        System.out.println("전원: "+captv.power);
        
        captv.chUp();
        System.out.println("채널 정보: "+captv.ch);
        System.out.println("자막 처리: "+captv.captionText());
        //기존 배운 내용
        
        Tv2 tv2 = captv;  //상속 관계에서 부모 타입은 자식 타입의 주소를 가질 수 있다(이게 다형성)
        //[상속 관계]에서 [부모 타입 변수]는 [자식 타입 변수]의 주소를 가질 수 있다(다형성)
        //단 부모는 자신의 객체만 볼 수 있다
        //단 재정의만 제외하고...
                
//        Tv2 tv = new Tv2(); //이렇게 하면 또 하나의 인스턴스를 만드는 것 > 메모리 낭비. 따라서 다형성을 이용
        System.out.println(tv2.toString());
        System.out.println(captv.toString());   // 두 참조 변수의 주소는 같다        

        
        
        
        
        
        
        
    }

}
