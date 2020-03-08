package kr.or.bit;
/*
 * 기능, 행위 만드는 방법
 * 함수(function)(method)
 * 
 * 함수(method): 행위 또는 기능의 최소단위  >> [**하나의 기능만 구현**]
 * ex) 먹는다, 걷는다, 잔다....
 * 
 * 
 * 클래스: 필드+함수+생성자
 * 
 * ex)게임방: 게임기 동전넣고.... 함수형태
 *          인형뽑기 동전넣고 인형을 받는 것 .... 함수형태
 *          
 * Java 함수 종류(4가지)
 * 1. void, parameter(O) : void print(String str){실행코드}
 * 2. void, parameter(X) : void print(){실행코드}
 * 3. return Type, parameter(O) : int print(int data){실행코드 내에 return이 있어야 함}
 * 4. return Type, parameter(x) : int print(){return 200;}
 * 
 *  void > 돌려주는 것이 없음. return value가 없음
 *  return Type: (8가지 기본 타입 + 참조타입) + Array + Collection + Interface
 *  ex) Car print(){return new Car()}
 *  ex) boolean print(){return true;}
 * 
 * parameter(인자, 인수, 매개값, 전달값): 게임기 동전 구멍(여러 개 일 수 도 있음)
 * 동전구멍이 두 개면 두 개 다 동전 넣어야 실행됨
 * ex) void print(int a, int b, int c, int d, int f) >
 * print(10,20,30,40,50); 이래야 실행됨
 * 
 * 
 * 함수의 이름은 : 첫 글자는 소문자. 관용적 표현. 의미있는 단어조합 
 * :getChannelNumber(), getEmpListByEmpno()
 * 
 * 함수라는 것은 반드시 호출(call) 되어야만 실행된다: 누군가 그의 이름을 부르지 않으면 실행이 안된다
*/




public class Fclass {
    public int data;
    
    //void m()
    public void m() {
        System.out.println("일반함수: void, parameter(x)");
    }
    
    //void m(parameter)
    public void m2(int i) {
        System.out.println("parameter value (scope: 함수내부) :"+i);
        System.out.println("일반함수: void, parameter(O)");
    }
    
    public int m3() {
        return 100; //return type 있는 함수는 반드시 return 키워드를 사용
    }
    
    public int m4(int data) {
        return data+1; //이런 형식도 가능
    }
    
    //확장
    
    public int sum(int i, int j, int k) {
        return i+j+k;
    }
    

    //함수를 만들었는데
    // 접근자 생략 > default  
    //int subSum(int i) {
//        return i+100;
//    }
    
    //함수가 다른 함수 부르는 것 가능
    //설계자의 의도: subSum 함수의 활용은 내부에 다른 함수를 도와주는 함수..
    //but 같은 폴더 내에서는 통용되지 않는다 > 사용가능하다
    //의도: subSum()에 객체(참조변수)가 접근 못하게.. 내부에서 사용
    //그러려면 private을 써야 한다
    //private 접근자, 한정자
    //1. 클래스 내부에서는 의미가 없다
    //2. 참조 변수(Fclass f = new Fclass())에서  f.private을 볼 수 없다
    
    //subSbum 함수는 ***다른 함수를 보조***하는 함수다. 그래서 호출되어서는 안된다.
    //내부에서 다른 함수가 호출해서 사용한다.
    //다른 함수가 사용하는 [공통 함수]
    private int subSum(int i) {
        return i+100;
    }
    //출력담당함수 만들기
    private void print(int data) {
        System.out.println("data : "+data);
    }
    
    public void CallSubSum() {
        int result = subSum(100);
        print(result);    //출력담당 함수 사용해서 편하게 서식으로 출력
    }
    
    
    //함수가 함수를 호출할 수는 있어도, 함수 안에 함수를 만들 수는 없다 main함수도 마찬가지
    
    
    private int operationMethod(int data) {
        return data * 200;
    }
    
    public int opSum(int data) {
        int result=operationMethod(data);
        if(result>0) {
            return 1;
        }else {
            return -1;
        }
    }
    
    //Quiz
    //a와 b 둘 중에 큰 값을 return하는 함수를 만드세요
    //ex) max(500,300) return값이 500받게 하면 되요
    //public int max(int a, int b)
    
//    public int max(int a, int b) {  //주의! 리턴이 있는 함수는 모든 경우에서 리턴을 받을 수 있어야 함
        
        //60점
//        int result = 0;
//        if(a>b) {
//            return a;
//        }else {
//            return b;
//        }
              
 
        
        //90점
//        int result;
//        result = (a>b)?a:b;
//        return result;
        
        
        //100점
//        return (a>b)?a:b;        //3항연산자를 잘 써먹자
//     }
    
    
    public String concat(String s, String s1, String s2) {
        String result = s + "/" +s1+"/"+s2;
        return s +"/"+s1+"/"+s2;     //바로 이렇게 해줘도 문제 없다
    }
    
    
    //여기까지가 함수의 기본편
    
    
    
    //**클래스는 타입이다.**
    /*
     * public int call(int i, int j){return i + j;}
     * public Tv call(){  }
    */
    
//    public Tv tcall() {
//       return new Tv();// 타입과 같은 객체
//       Tv t = new Tv(); //인스턴스 생성 후 리턴
//       return t;
//        return null; //사용하진 않지만 문법적 오류는 아니다
//    }
    
    
//    public Tv tcall() {return new Tv();}
    
    public Tv tcall(Tv t) {  // 매개변수 이용해 이렇게도 된다
        return t;
//        return new Tv();
    }
    
    //Today Point
    //클래스는 memory 올려야 사용가능하다
    //Tv t = new Tv(); >> t라는 변수는 Tv타입객체의 주소를 갖는다
    
    public Tv objMethod() { //Tv라는 타입의 객체 주소를 돌려줌
        Tv tv = new Tv();
        return tv;
    }
    
    public Tv objMethod2() {
        return new Tv();
    }
  
    public Tv objMethod3(Tv t) {  //Tv라는 타입을 갖는 객체의 주소를 받겠다
        return  t;
    }
    

 

  
    
    


    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
