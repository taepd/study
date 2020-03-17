import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ex02_ArrayList {

    public static void main(String[] args) {
        ArrayList arraylist = new ArrayList();
        
        arraylist.add(100);
        arraylist.add(200);
        arraylist.add(300);
        
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(arraylist.get(i));
            
        }
        
        System.out.println(arraylist.toString()); //toString 생략 가능
        
        System.out.println("특정 방에 있는 값: "+ arraylist.get(0));
        //add 순차적으로 데이터 넣기
        //arraylist.add 는 오버로딩 되어 있음 
        arraylist.add(0,111);           //0번째 자리에 111 삽입 >> 0번째 index 요소값 수정이 아니라 하나씩 뒤로 밀려난다
        System.out.println(arraylist);  //[111, 100, 200, 300]
        arraylist.add(4,444);
        System.out.println(arraylist);
        
        //비순차적인 데이터 추가, 삭제를 하게 되면 성능 떨어짐
        //arraylist.remove(index)
        //arraylist.add(index, element) 
        
        //순차적 데이터 추가, 삭제에 어울림
        
        System.out.println(arraylist.contains(200));  //true
        
        System.out.println(arraylist.isEmpty()); //size가 0이면 true
        
        arraylist.clear(); //siez ==0
        
        System.out.println(arraylist.isEmpty()); //true
 
        arraylist.add(101);
        arraylist.add(102);
        arraylist.add(103);
        System.out.println(arraylist);
        
        //삭제 remove()
        System.out.println("삭제 전 : "+arraylist.size());
        Object value = arraylist.remove(0); //0번째 방의 값을 삭제. 따로 보관(보험용)
        System.out.println("삭제된 데이터 : "+value);
        System.out.println(arraylist);
        System.out.println("삭제 후 : "+arraylist.size()); 
        
        //Point
        //개발할 때 일상다반사
        //ArrayList alist = new ArrayList(); //이렇게 쓰지 않고
        List li = new ArrayList();  //ArrayList는 List 인터페이스를 구현한 것이므로 다형성 >> 확장성, 유연성 위해
        li.add("가");
        li.add("나");
        li.add("다");
        li.add("라");
        
        //sublist 해당 구간 배열을 배열로 추출하여 부모타입으로 리턴
        List li4 = li.subList(0, 2); 
        System.out.println(li4);
        
        
        //Collections.sort()
        ArrayList alist = new ArrayList();
        alist.add(50);
        alist.add(1);
        alist.add(7);
        alist.add(40);
        alist.add(45);
        alist.add(3);
        alist.add(15);
        
        System.out.println("before : "+alist);
        Collections.sort(alist); //Collections 초보개발자는 쓰지말자 > 실력이 안늠
        System.out.println("after : "+alist);
        Collections.reverse(alist);   //역 정렬은 없지만, 정렬된 리스트를 리버스할 수는 있음
        System.out.println("reverse: "+alist);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        

    }

}
