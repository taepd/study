import java.util.Vector;

/*
 * Collection FrameWork
 * [다수의 데이터를] 다루는 표준화된 인터페이스를 구현하고 있는 클래스 집합
 * 
 * Collection 인터페이스 <- List(상속)<---- ArrayList(구현)
 *                    <- Set(상속)<----HashSet, TreeSet(구현)
 * Map 인터페이스(key, value)<----HashMap(구현)
 * ArrayList, HashMap 중요
 * -------------------------------------------------
 * List Interface (줄을 서시오)
 * 순서(번호표), 중복(허용) >>내부적으로 데이터(자료, 객체)들을 배열로 관리
 * 
 * 1. Vector(구버전) -> 동기화(멀티스레드) -> Lock(보호) -> 성능 좀 떨어짐  
 * 예) 한강 화장실
 * 2. ArrayList(신버전) -> 동기화(멀티스레드) -> Lock(필요에 따라서) -> 성능 고려
 * 예) 한강 비빔밥 축제(동시 떠먹기 가능)
 * 
 * Array
 * 1. 배열의 크기가 고정: Car[] card = {new Car(), new Car()};
 * 2. 접근 방법: index(첨자) index는 0부터 시작 
 * 3. 초기 설정 변경 불가
 * 
 * List 인터페이스를 구현한 클래스:: Vector, ArrayList
 * 1. 배열의 크기를 동적으로 확장/축소 가능 >> 사실은 배열의 재할당
 * 2. 순서를 유지(Array), 순서값(index), 중복값 허용
 * 3. 데이터 저장 공간(Array)
*/


public class Ex01_Vector {

    public static void main(String[] args) {
        
        Vector v = new Vector();  //제네릭 표기를 안하면 가장 상위인 Object타입으로 값을 받음
        System.out.println("초기  default 용량: "+v.capacity()); //기본적으로 10개 방 생성
        v.add("AA");
        v.add("BB");
        v.add("AA");
        v.add(100);
        
        System.out.println(v);
        
        //Array >> length >> 배열의 길이
        //List >> size >> 값의 길이
        
        for (int i = 0; i < v.size(); i++) {
            //정적(Array: arr[i]
            System.out.println(v.get(i));          //get() 값을 가져오는 메서드
        }
        //개선된 for문 사용
        for(Object i: v) {
            System.out.println(i);  //print()에 Object도 오버로딩 되어있음
        }
        //제네릭 >> 타입을 강제
        Vector<String> v2 = new Vector<String>();
        
        v2.add("Hello");
        v2.add("world");
        v2.add("king");
        for(String str : v2) {
            System.out.println(str);
        }
        System.out.println(v2.toString());
        System.out.println(v2.get(2));
        System.out.println("size 데이터 개수: "+v2.size());
        System.out.println("Capacity: "+v2.capacity());
        
        Vector<String> v3 = new Vector<>();  //타입 추정 가능한 경우 인스턴스의 제네릭 표기는 생략 가능
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        System.out.println(v3.capacity()); //기본 캐퍼시티는 10 
        v3.add("A");                       //10개를 넘겨 저장
        System.out.println(v3.capacity()); //20. size가 기본 사이즈 초과하면 캐퍼시티를 두 배로 늘림
        
        
                
        
        
        
        
        
        

    }

}
