
class InitTest{
    static int cv=10;
    int iv=1;
    
        static{ //static 초기자: static 변수 초기화(실행 시점)
            cv =20;
            
        }
        
    
    

        //instance 초기자(static memberfield 나 memberfield의 값을 초기화)
        { //초기자 : 메모리에 iv라는 변수가 올라가고 나서 바로 실행
            //instance 변수의 초기화    //논리적인 코드 초기화를 하기 위해 필요 ex) cv2=cv+10; 
            iv = 3;
    
        }

}

public class Ex08_Static_init {

    public static void main(String[] args) {
        System.out.println(InitTest.cv);
        InitTest init = new InitTest();
        System.out.println(init.iv); //초기화해야만 iv변수 접근 가능

    }

}
