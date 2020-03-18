import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * HashMap<k, v>
 * HashMap<String, String>
 * HashMap<Integer, String>
 * HashMap<String, Emp>
 * >>put("hong", new Emp()); << 이런 경우가 정말 많다 스트링 키에 대한 값 타입은 객체로
*/

class Student{
    int kor=100;
    int math=50;
    int eng=20;
    String name;
    public Student(String name, int kor, int math, int eng) {
        this.name=name;
        this.kor=kor;
        this.math=math;
        this.eng=eng;
    }
}

public class Ex13_HashMap_Generic {

    public static void main(String[] args) {
        
        HashMap<String, Student> sts = new HashMap<String, Student>();  //프로젝트할 때 이런 형식을 정말 많이 쓴다
        sts.put("hong", new Student("홍길동", 100, 50, 30));
        sts.put("kim", new Student("김유신", 50, 100, 60));
        
        Student std = sts.get("hong");
        System.out.println(std.kor);
        System.out.println(std.math);
        
        //Tip
        //Map 안에 있는 key, value 모두 같이 출력
        //entrySet()
        Set set = sts.entrySet(); //key+"="+value
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());   //hong=Student@15db9742  value값이 주소값으로 오게 되는 문제가 생긴다
        }
        
        //따라서
        //만약에 value가 Object(객체)라면
        //Map.Entry으로 getKey(), getValue() 제공받는다
        for(Map.Entry m: sts.entrySet()) {
            System.out.println(m.getKey()+"/"+((Student)m.getValue()).name);  //Map.Entry에는 name 변수가 없으므로 Student로 다운캐스팅한 다음 name가져온다
        }
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
