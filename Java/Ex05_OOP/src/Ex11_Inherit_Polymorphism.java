//자바 다형성 (상속)
class Pbase{
    int p = 100;
}

class Cbase extends Pbase{
    int c = 200;
}

class Dbase extends Pbase{
    
}



public class Ex11_Inherit_Polymorphism {

    public static void main(String[] args) {
            Cbase cbase = new Cbase();
            System.out.println(cbase.toString());
            
            Pbase p = cbase; //다형성
            //부모타입의 참조변수 p는 자식 타입의 참조변수 cbase가 가지는 주소값을 가질 수 있다. 
            //부모타입의 참조변수 p는 생성된 부모객체만 접근 가능.. 자식객체는 접근 불가 (단, 오버라이딩 된 메서드는 접근 가능)
            
            Dbase dbase = new Dbase();
            
            p = dbase; //가능
            //부모타입 p는 자식타입 cbase의 주소도 가질 수 있고, 또 다른 자식타입 dbase의 주소도 가질 수 있다.
            
            
        
        
        
        
        
        
        
        
    }

}
