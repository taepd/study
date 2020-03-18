import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* Set 인터페이스를 구현하는 클래스
 * 데이터 순서 보장(x), 중복(x)
 * 구현하는 클래스 : HashSet, TreeSet
*/

public class Ex09_Set_Interface {

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(1);
        hs.add(100);
        boolean bo2 = hs.add(55);
        System.out.println(bo2);
        System.out.println(hs.toString());
        bo2 = hs.add(1);  //같은 데이터는 추가 안됨
        System.out.println(bo2);
        System.out.println(hs.toString());
        hs.add(2);
        System.out.println(hs);  //toString 생략. 순서 보장 x
        
        HashSet<String> hs2 = new HashSet<String>();
        hs2.add("b");
        hs2.add("A");
        hs2.add("F");
        hs2.add("c");
        hs2.add("z");
        hs2.add("A");
        hs2.add("A");
        hs2.add("A");
        System.out.println(hs2);
        
        String[] obj = {"A","B","C","D","B","A"};
        HashSet<String> hs3 = new HashSet<String>();
        for (int i = 0; i < obj.length; i++) {
            hs3.add(obj[i]);
        }
        System.out.println(hs3);
        
        //Quiz
        //HashSet 을 이용해서 1~45까지 난수 6개를 넣으세요
        //hint size의 활용
        HashSet<Integer> lotto = new HashSet<Integer>();
        for (int i = 0; lotto.size()<6; i++) {
            int num = (int)(Math.random()*45)+1;
            lotto.add(num);
        }
        
        while(lotto.size()<6) {
            lotto.add((int)(Math.random()*45+1));
        }
        System.out.println(lotto);
        
        Set set2 = new HashSet();
        int index=0;
        while(set2.size()<6) {
            System.out.println("index: "+(++index));
            set2.add((int)(Math.random()*45+1));
        }
        System.out.println(set2);
        
        HashSet<String> set3 = new HashSet<String>();
        set3.add("AA");
        set3.add("DD");
        set3.add("ABC");
        set3.add("FFFF");
        System.out.println(set3.toString());
        
        Iterator<String> s = set3.iterator();
        while(s.hasNext()) {
            System.out.println(s.next());   //순서를 보장하진 않는다. set이니까
        }
        
        //Collections.sort(List<T>);
        //sort함수의 parameter로는 List 인터페이스를 구현한 객체만 가능
        //vector, stack, ArrayList는 가능하지만, Set은 불가
        
        List list = new ArrayList(set3); //ArrayList 생성자 parameter에는 Collection Interface 타입 변수도 가능 >> HashSet도 가능(다형성)
        System.out.println("before 무작위: "+list);
        Collections.sort(list);
//        list.sort(null);  //이것도 되는데 이건 뭘까
        System.out.println("sort : "+list);
        
        Collections.reverse(list);
        System.out.println("reverse : "+list);
        
        
        
        
        
        
        
        
        
    }

}
