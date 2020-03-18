import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*Collection Framework
 * 나열된 자원에 대해 순차적으로 접근해서 값을 리턴하는 표준 정의
 * Iterator 인터페이스
 * 1. hasNext(), Next() ... 이런 이름으로 구현하라고 강제
 * 2. Collection {public Iterator iterator();} >> List 상속 >> ArrayList 구현
 * >> Collection 인터페이스가 Iterator 인터페이스를 반환하는 iterator라는 추상메서드를 가지고 있고, 이를 ArrayList에서 구현
 *  >>hasNext(), Next(), remove() >> 재정의 구현
 * 3.ListIterator : 양방향 가능(Iterator 개선 버전) > 데이터 read 표준화 제공
*/



public class Ex08_Collection_Iterator {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(100);
        list.add(200);
        list.add(300);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        
        //표준화 된 출력방식
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        
                
        
//        ArrayList<int> intlist = new ArrayList<int>(); //generic<> 안에는 참조타입만 올 수 있음
        ArrayList<Integer> intlist = new ArrayList<Integer>();
        intlist.add(44);
        intlist.add(55);
        intlist.add(66);
        
        //iterator 이용해서 해보자
        Iterator<Integer> list2 = intlist.iterator(); //list2는 intlist라는 ArrayList의 iterator메서드를 값으로 받는 변수
        
        while(list2.hasNext()) {
            System.out.println(list2.next());
//            System.out.println(intlist.iterator().next()); //바로 위 문장과 같다. 위는 표준화된 표현 방식일뿐
        }
        
        for (int i = 0; i < intlist.size(); i++) {
            System.out.println(intlist.get(i));
        }
        
        //일반 for문 역방향
        for (int i = intlist.size()-1; i >=0; i--) {
            System.out.println(intlist.get(i));
        }
        
        //Iterator는 역방향 조회 불가
        
        //역방향 조회.. (조건: 순방향 진행 후 역방향만 가능 >> 처음부터 역방향 안됨)
        
        ListIterator<Integer> li2 =  intlist.listIterator();
        
        System.out.println("***************");
        //순방향
        while(li2.hasNext()) {
            System.out.println(li2.next());
        }
        System.out.println("***************");
        //역방향
        while(li2.hasPrevious()) {
            System.out.println(li2.previous());
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
