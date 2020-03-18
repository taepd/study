import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

//Today POINT
public class Ex02_ArrayList1 {
	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		for(int i = 0 ; i < arraylist.size() ; i++) {
			System.out.println(arraylist.get(i));
		}
		
		System.out.println(arraylist.toString());
		
		System.out.println("특정 방에 있는 값 : " + arraylist.get(0));
		//add 순차적으로 데이터 넣기
		//arraylist.add overloading .... index , element
		arraylist.add(0,111); //[111, 100, 200, 300]
		System.out.println(arraylist.toString());
		arraylist.add(4,444);
		System.out.println(arraylist.toString());
		//비순차적인 데이터 추가 , 삭제   >> ArrayList (순서가 있는 데이터 집합)
		//[순차적인] 데이터 추가 , 삭제  ^^
		
		//데이터 삽입 (add)  : 중간 >> 나머지 데이터 이동 
		//데이터 삭제 ...
		//arraylist.remove(index)
		//arraylist.add(index, element);
		
		//ArrayList 가지는 함수 학습
		System.out.println(arraylist.contains(200));
		System.out.println(arraylist.contains(5555));
		
		System.out.println(arraylist.isEmpty()); //false 나 비워 있지 않아
		//true >> size == 0
		arraylist.clear(); // size ==0
		System.out.println(arraylist.isEmpty());
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist.toString());
		
		//삭제 remove()
		System.out.println("삭제전 : " + arraylist.size());
		Object value = arraylist.remove(0); //0번째 방의 값을 삭제
		System.out.println("삭제된 데이터 : " + value);
		System.out.println(arraylist.toString());
		System.out.println("삭제후 : " + arraylist.size());
		
		//POINT
		//개발자 ... 일상다반사 ..
		List li = new ArrayList();  //다형성 >> 확장성 , 유연성
		//li.add(e)
		//ArrayList alist = new  ArrayList();
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
		
		List li4 =  li.subList(0, 2); //sublist 만들어 주는 데이터가 .. 순서가 데이터 집합
		System.out.println(li4.toString());
		
		
		ArrayList alist = new ArrayList();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(45);
		alist.add(3);
		alist.add(15);
		
		//Arrays.sort(a);
		System.out.println("before : " + alist.toString());
		Collections.sort(alist);  //Collections 초보개발자는 쓰지 ..(x)
		System.out.println("after : " + alist.toString());
	    //[1, 3, 7, 15, 40, 45, 50]
		Collections.reverse(alist);
		System.out.println("after : " + alist.toString());
	
	}

}




























