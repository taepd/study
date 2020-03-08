//static method 함수:
//내가 static 함수를 만들었다면 나는 이런 의도를 가지고 있을 것이다..
//hint: Math.Random()
//System.out도 static이다.   static 함수를 만드는 이유: 해당 함수를 자주 쓰기 때문에!
//하지만 static은 남발하면 안된다. 조심해서 사용해야 한다.

class StaticClass{
    static int cv;
    
    static void sm() {
        System.out.println("나 static이야");
    }
}





public class Ex09_Static_Method {

    public static void main(String[] args) {
    StaticClass.sm();  //요렇게 객체 생성안하고 바로 사용 가능
    
        
    }

}
