import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex10_TreeSet {

    public static void main(String[] args) {
        
        
        //HashSet 확장  >> LinkedHash(순서유지)>> Linked(주소: node)
        Set<String> hs2 = new LinkedHashSet<String>();
        hs2.add("B");
        hs2.add("A");       
        hs2.add("F");        
        hs2.add("K");       
        hs2.add("G");       
        hs2.add("D");       
        hs2.add("P");
        hs2.add("A");
        System.out.println(hs2.toString()); //[B, A, F, K, G, D, P]. 순서가 유지됨
        
        //TreeSet
        //자료구조(순서(x), 중복(x), 정렬(0))
        //검색하거나 정렬을 필요로 하는 데이터 집합 예)로또
        //1. 이진 검색 트리(binary search tree) 구조를 가지고 있다
        //2. 데이터가 저장될 때 정렬된다
        
        Set<Integer> lotto = new TreeSet<Integer>();
        for (int i = 0; lotto.size()<6; i++) {
            lotto.add((int)(Math.random()*45)+1);            
        }
        System.out.println(lotto.toString());
        
        
        
        //Iterator로 만들기
        Iterator<Integer> lo = lotto.iterator();
        while(lo.hasNext()) {
            System.out.println(lo.next());
        } 
        
        
        
        
        
    
        
        
    }

}
