import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* Map 인터페이스
 * Key와 value라는 쌍의 구조를 갖는 배열
 * ex) 지역번호(02, 서울), (031, 경기)
 * key: 중복(x)
 * value: 중복(o)
 * 
 * generic 지원
 * 
 * Map 인터페이스 구현 클래스
 * 구버전: HashTable (Vector와 마찬가지로 동기화 보장(lock을 가지고 있음))
 * 신버전: HashMap (동기화를 강제하지 않음: 성능 고려) 
 * (Thread를 배우지 않으면 동기화는 의미가 없다)
 * 
*/



public class Ex11_Map_Interface {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Tiger", "1004");
        map.put("scott", "1004");
        map.put("sueprman", "1004");
        
        //containsKey()  해당 키의 값이 있는지 없는지
        System.out.println(map.containsKey("Tiger"));
        System.out.println(map.containsKey("scott"));
        System.out.println(map.containsKey("1004"));
        
        //key 제공하면 value 값을 얻는게 필요
        //get()  키를 매개변수로 하여 값을 반환
        System.out.println(map.get("Tiger")); 
        System.out.println(map.get("hong"));  //null. 해당되는 키가 존재하지 않으면 null반환
        
        //put()  해당 키의 값을 변경, 혹은 입력
        map.put("Tiger","1005"); //Tiger의 value를 1005로 덮어씀
        System.out.println(map.get("Tiger"));
        map.put("아기", 1004);  //입력의 경우
        System.out.println(map.get("아기"));
        
        
        //remove()
        Object value = map.remove("superman");
        System.out.println("value: "+ value);
        System.out.println(map.toString());
        
        
        //KeySet()
        Set set = map.keySet();  //key 집합은 Set이어야 하므로
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        Collection vlist = map.values();   //값들은 Collection 타입으로 받아야 한다
        System.out.println(vlist.toString());
        
        
        
        
        
        
        
        
    }

}
