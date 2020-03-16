/*
 * 상수<->변수
 * 상수: 한 번 값이 초기화되면 변경 불가
 * 상수 자원: 고유값(주민번호). 수학적인 값: PI=3.14159...
 * 상수는 관용적으로 [대문자]
 * 
 *  java: final int NUM  = 10;
 *  C#: const int NUM = 10;
 *  
 *  final 키워드
 *  클래스 앞에 >> final class Car{}  >> final Math >> 상속 불가
 *  함수 앞에: public final void print(){} >> 오버라이딩 불가
 *           public static final void print(){}  >> 공유자원, 공통함수, 오버라이딩 불가
 *  상수: public final String KIND="heart"  //상수
*/
    
class Vcard {
//    final String KIND;   //상수는 초기화가 꼭 필요(기본값 초기화 안됨)
    final String KIND = "heart";
    final int NUM = 10;
    
    void method() {
        //자바 API
        System.out.println(Math.PI);
    }
}

//Vcard 카드 53장을 만들면 모든 카드 모양은 KIND>> heart
//혹시 53장의 카드 KIND 다 다르게. 만들어지면 바뀌지 않게

class Vcard2{
    final String KIND;
    final int NUM;
    
//    Vcard2(){
//        this.KIND="heart";
//        this.NUM=10;
//    }
//    Vcard2(){} //사용자 정의 초기화를 안했기 때문에 에러
    Vcard2(String kind, int num){   //오버로딩을 이용하면 객체 별로 여러 개의 상수를 생성 가능
        this.KIND=kind;
        this.NUM=num;
    }

    @Override
    public String toString() {
        return "Vcard2 [KIND=" + KIND + ", NUM=" + NUM + "]";
    }
    
    
}

public class Ex07_Inherit_Final {

    public static void main(String[] args) {
        Vcard v = new Vcard();
        v.method();
//        v.NUM=1000; //The final field Vcard.NUM cannot be assigned 한 번 초기화된 값은 변경 불가
        
        Vcard2 c = new Vcard2("spade", 1);
        System.out.println(c.toString());
        Vcard2 c2 = new Vcard2("spade", 2);
        System.out.println(c2.toString());
        Vcard2 c3 = new Vcard2("spade", 3);
        System.out.println(c3.toString());
        
//        c.KIND = "heart"; //상수는 한 번 초기화 된 값은 수정이 불가능
        

        
        
        
        
        
        
        

        
    }

}
