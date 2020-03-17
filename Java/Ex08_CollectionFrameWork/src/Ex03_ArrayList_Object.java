import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object {

    public static void main(String[] args) {
        
        //사원 1명을 만드세요
        Emp emp = new Emp(100, "김유신", "군인");
        System.out.println(emp.toString());
        
        //Array(고정 배열)
        //사원 2명 만드세요
        Emp[] emplist = {new Emp(100, "김씨", "일반인"), new Emp(200, "박씨", "학생")};
        for( Emp e : emplist) {
            System.out.println(e);  //toString 생략
        }
        //여기까진 이전 방식
        
        //한 명이 입사를 더 했네요. 추가시키세요
        
        //Collection
        ArrayList list = new ArrayList();
        list.add(new Emp(1, "강", "IT"));
        list.add(new Emp(2, "홍", "IT"));
        
       
        System.out.println(list);   //toString을 Emp 클래스에서 오버라이딩 했기 때문에 내용 출력
        //toString 활용하지 말고 사원 출력해 보세요
        //일반 for문
        for (int i = 0; i < list.size(); i++) {
            //list.get(i)
            Object obj = list.get(i);   //get()메서드의 리턴은 Object 타입이다
//            System.out.println(list.get(i));
            
            //getter를 사용해서 내용을 출력해보기
            Emp e =(Emp)list.get(i); //부모타입의 주소를 자식타입에게 주려면 자식타입에 맞게 캐스팅해야 한다
            System.out.println(e.getEmpno()+"/"+e.getEname()+"/"+e.getJob());
        }
        
        //toString을 사용하지 말고 개선된 for문을 출력하세요
        //왕짜증 다운 캐스팅 다형성..
        for(Object obj : list) {
            Emp e = (Emp)obj;
            System.out.println(e.getEmpno()+"/"+e.getEname()+"/"+e.getJob());
        }
        
        //Object 불편함 해소 위해
        //제네릭(타입을 강제)        
        
        ArrayList<Emp> list2 = new ArrayList<Emp>();  //내가 가지는 방의 타입은 Emp타입
        list2.add(new Emp(1, "A", "IT"));
        list2.add(new Emp(2, "B", "IT"));
        
        for(Emp e: list2) {     //제네릭을 활용해서 편하게 for문 사용
            System.out.println(e.getEmpno()+"/"+e.getEname()+"/"+e.getJob());
        }
        
        //그래서...
        //입사 한 명 추가
        list2.add(new Emp(3, "New", "IT"));  // 배열 추가가 매우 간편!!
        System.out.println(list2);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
