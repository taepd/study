package kr.or.bit;
//새: 공통(일반, 추상): 새는 날 수 있다, 새는 빠르다

public class Bird {
  //공통기능
  
    public void fly() {
        System.out.println("flying");
    }
    //나를 상속하는 녀석은 moveFast 재정의 했으면 좋겠어 (90%  재정의)
    protected void moveFast() {
        fly();
    }
}
