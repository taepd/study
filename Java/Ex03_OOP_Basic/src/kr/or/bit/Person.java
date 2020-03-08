package kr.or.bit;
//class == 설계도 == Type
//설계도 구체화(메모리 올려서)를 통해서 객체로 생성되어야 한다
//구체화된 것 > 객체, 인스턴스

//설계도의 기본적인 구성요소(필드 + 함수) + 생성자

//class Car{}   >>default class Car{}  > 현재 폴더에서만
//public class Car {public String color; int door; > default int door}
 public class Person {
     public String name; //member field > instance variable
                         //초기화를 하지 않아도 된다(초기화: 최초에 값을 할당 하는 것)
                         //생성되는 객체(사람)마다 다른 이름을 가지기 때문에..
                         //Person p = new Person(); p.name="홍길동";
                         //Person p2 = new Person(); p.name="김유신";
                         //default 값을 가진다
                         //public int age; //default값은 0
                         //public boolean power //default값은 false
     public boolean power;
     public int age;
     
     //기능(행위) >> method
     public void print() {
         System.out.println("name : "+name+" / age : "+age);
         
     }
     
}
