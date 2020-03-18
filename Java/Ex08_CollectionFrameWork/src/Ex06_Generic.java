import java.util.ArrayList;
import java.util.Stack;

/*
 * Today Point
 * Generic
 * jdk 1.5부터
 * C#, Java 필수 기능
 * 
 * Collection 클래스들은(저장공간의 타입: Object) 
 * 1. Object 타입 저항 >> 타입?? >> 타입강제 >> 제네릭
 * 2. 타입 안정성(타입 강제)
 * 3. 형변환(castring)할 필요없음
 * 
 * 만드는 시점: 클래스 설계 >> 타입을 강제하도록
*/

class MyGen<T>{ //Type parameter   <T>
    T obj;
    
    void add(T obj) {
        this.obj=obj;
    }
    T get() {
        return this.obj;
    }
}

class Person extends Object {
    int age = 100;
}

public class Ex06_Generic {

    public static void main(String[] args) {
        
        MyGen<String> mygen = new MyGen<String>();
        mygen.add("문자열");
        String result = mygen.get();
        System.out.println(result);
        
        ArrayList list = new ArrayList();     //제네릭을 명시하지 않으면 기본타입은 Object가 된다
        
        list.add(10);
        list.add("홍길동");
        list.add(new Person());  //다 넣을 수 있다
        
        //출력
        for(Object obj : list) {
//            System.out.println(obj);  //주소값이 출력
//            Person p =(Person)(obj);
//            System.out.println(p.age);
            //판단(객체, 값 구분 .. 변환)
            if(obj instanceof Person) {         //제네릭이 없으면 이렇게 복잡하게 해야한다
                Person p = (Person)(obj);
                System.out.println(p.age);
            }else {
                System.out.println((obj));
            }
        }
        
        ArrayList<Person> plist = new ArrayList<Person>();  //우변 제네릭은 생략할 수 있지만 호환성을 위해 되도록 표기하자
        plist.add(new Person());
        plist.add(new Person());
        for(Person p : plist) {
            System.out.println(p.age);
        }

        MyGen<Person> myobj = new MyGen<Person>();
        myobj.add(new Person());
        Person pe = myobj.get();
        System.out.println(pe.age);
        
        Stack<String> s = new Stack<String>();
        s.push("문자열");
        String str = s.pop();
        System.out.println(str);
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
