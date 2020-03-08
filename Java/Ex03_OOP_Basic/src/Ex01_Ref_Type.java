import kr.or.bit.BodyInfo;
import kr.or.bit.Emp;
import kr.or.bit.Person;
import kr.or.bit.Tv;

public class Ex01_Ref_Type {

    public static void main(String[] args) {
       
        
        //값 타입(저장공간: 메모리)
        int i = 100;
        i = 200;
        System.out.println("i : "+i);
        
        //참조타입
        
        Person person;  //선언    >> stack이라는 메모리 영역에 변수가 만들어 짐
        person = new Person(); //person라는 변수에 값(주소값)을 할당
        System.out.println(person); //참조타입은 주소값을 갖는다. 출력값: kr.or.bit.Person@15db9742
        
        //초기값 할당
        
        Person person2 = null; //null (객체의 초기값: 값이 없다, 비어 있다)
        System.out.println(person2); //메모리를 가지고 있지 않다
        
        //person2가 메모리를 갖는 방법은
        //1. person2 = new Person();
        //2. person2 = person; 다른 객체 주소값을 할당
        
        person2 = person;
        System.out.println(person2==person); //true 출력
        
        person2.name="홍길동";
        person2.age=100;
        person2.print();
        
        System.out.println(person.name);
        
        //선언과 할당을 동시에
        Person myperson = new Person();
        myperson.name="아무개";
        myperson.print(); //출력값: 아무개 / age : 0  age는 할당하지 않아서 기본값 0 출력
        System.out.println(myperson.power); 
               
        Tv stv = new Tv();
        
        stv.brandname="비트";
        
        System.out.println("현재 채널 정보 : " + stv.ch);  // 현재는 0번(int 기본값)
        
        stv.ch_Up();
        stv.ch_Up();
        stv.ch_Up();
        stv.ch_Up();
        stv.ch_Up();
        
        System.out.println("현재 채널 정보 : " + stv.ch); // 5번
        
        stv.ch_Down();
        stv.ch_Down();
                
        System.out.println("현재 채널 정보 : " + stv.ch);  //3번
        System.out.println("브랜드 이름 : " + stv.brandname);
        stv.tvPrint();
        
        //사원1명 생성
        Emp emp = new Emp();
        emp.empno = 7788;
        emp.name = "김유신";
        emp.job = "IT";
        System.out.println(emp.bodyinfo);
        
        BodyInfo bodyinfo = new BodyInfo();
        bodyinfo.height = 190;
        bodyinfo.weight = 90;
        
        emp.bodyinfo = bodyinfo;
        
        System.out.println(emp.empno+ "/ "+emp.bodyinfo);
        System.out.println(emp.empno + "/ " + emp.bodyinfo.height);
        System.out.println(emp.empno + "/ " + emp.bodyinfo.weight);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
