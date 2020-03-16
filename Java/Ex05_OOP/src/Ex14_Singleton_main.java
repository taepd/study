import kr.or.bit.Singleton;

public class Ex14_Singleton_main {

    public static void main(String[] args) {

//        Singleton singleton = new Singleton();  //private 생성자라 노출안됨
        
        Singleton single = Singleton.getInstance();
        System.out.println(single);
        Singleton single2 = Singleton.getInstance();
        System.out.println(single2);
        Singleton single3= Singleton.getInstance();
        System.out.println(single3);
        
        //kr.or.bit.Singleton@15db9742
        //kr.or.bit.Singleton@15db9742
        //kr.or.bit.Singleton@15db9742  모두 같은 주소값, 즉 모두 같은 객체를 참조한다 
        
        
    }

}
