import kr.or.bit.Bird;

/*
 * protected > 상속 관계에서만
 * 목적: 상속 관계에서 재정의를 권함
 * 당신이 나를 상속한다면 이 자원(함수) 재정의 했으면 좋겠어
 * 
 *  
*/
//새
class Ostrich extends Bird{
    //구체화, 특수화
    void run() {
        System.out.println("run ^^");
    }
    
  

    @Override
    protected void moveFast() {    //public과 다르게 자손클래스에서 오버라이딩하지 않으면 사용하지 못한다.
        super.moveFast();
        run();
    }
    
}


public class Ex09_Inherit_Proteced {

    public static void main(String[] args) {
        
        Ostrich ostrich = new Ostrich();
        ostrich.moveFast();    // run^^ : 오버라이딩해서 타조에 맞게 바꿈. 
        
        
        
        
        
        
        
        

    }

}
