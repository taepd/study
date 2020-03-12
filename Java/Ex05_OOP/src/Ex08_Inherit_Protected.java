import kr.or.bit.Pclass;

/*
 * public, default, private, 상속관계 >> protected
 * 
 * protected
 * 양면성을 가짐(default, public)
 * 
 * 상속이 없는 클래스 안에서 protected 접근자는 default와 같음
 * 
 * protected를 사용하는 의도
 * >> 사용할 때 재정의해서 쓰면 좋겠다
 * 
*/

class Dclass{
    public int j;
    private int o;
    int p;
    protected int k;
}

class Child2 extends Pclass{
    void method() {
        this.k = 1000;  //상속 관계에서 자식은 부모의 protected 접근자 자원을 public처럼 사용 가능
        System.out.println(this.k);
    }
}


public class Ex08_Inherit_Protected {

    public static void main(String[] args) {
        Dclass dc = new Dclass();
//        dc.j ok >>public
//        dc.p ok >>default(같은 폴더 안)
//        dc.k ok >>protected(같은 폴더 안에서 default나 마찬가지)
//        dc.o >> private(x)
//        결국 proteced는 상속 관계에서만 사용
        Pclass pc = new Pclass();
//        pc.j >> public인 이것만 가능
        
        Child2 ch = new Child2();
        ch.method();       
        
    }

}
