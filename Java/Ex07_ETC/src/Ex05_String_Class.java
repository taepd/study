/*
 * String 클래스
 * String str = new String("홍길동"); <원래는 이렇게 써야 함
 * 편의를 위해 8가지 기본 타입과 동일하게 사용할 수 있도록 설계
 * 
 * 1. String 클래스: 데이터 저장 구조 : char[] 배열저장 > 홍길동 > [홍][길][동]
 * ex) String ename = "ABC" >> char[] >> [A][B][C]
 * class String extends Object{
 *  char[] ...
 *  void length(){}
 *  @override
 *  String toString(){
 *      재정의...
 * }
*/

public class Ex05_String_Class {

    public static void main(String[] args) {
        String str = "홍길동";
        System.out.println(str.length());  //데이터가 char[]로 관리되기 때문에 .length 가능
        System.out.println(str.toString()); //toString은 원래 주소값 나오는 메서드인데, 오버라이드해서 내용 출력하게 만든 것
        
        String str1 = "AAA";
        String str2 = "AAA";
        System.out.println("str1: "+System.identityHashCode(str1));
        System.out.println("str2: "+System.identityHashCode(str2));
        
        System.out.println(str1);  //str1.toString()로 컴파일. 따라서 주소가 아닌 내용이 나옴
        System.out.println(str1 == str2); //true다. String은 힙메모리에 같은 문자열이 있으면 새로 만들지 않음. 같은 주소값을 같는 것
        //문자열 '=='은 주소값을 비교하는 것 (xx번지 == xx번지)
        
        System.out.println(str1.equals(str2)); //실제로 힙에 있는 값을 비교하는 것 ("AAA" == "AAA")
        
        //그런데....
        
        String str3 = new String("BBB"); //new를 사용하면 새로운 객체 생성
        String str4 = new String("BBB");
        System.out.println("str3: "+System.identityHashCode(str3));
        System.out.println("str4: "+System.identityHashCode(str4));
        
        System.out.println(str3==str4); //false. 서로 다른 힙 메모리 영역을 갖게 됨
        System.out.println(str3.equals(str4)); //true.
        
        //넌센스
        String s = "A";    // 힙에 char배열 객체 생성

        s+="B";             // 정적 배열이므로 새로운 객체 생성 
        s+="C";             // 또 다시 새로운 객체 생성
        System.out.println(s);
        
        s="A";              // 위에 같은 배열(char[] 요소값이 A인 것)이 있으므로 그걸 참조

        System.out.println(s);    // 
        
        
        
        
        

    }

}
