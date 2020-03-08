import kr.or.bit.Fclass;
import kr.or.bit.NoteBook;


public class Ex02_Method {

    public static void main(String[] args) {
       Fclass fc = new Fclass();       
       fc.m();
       
       fc.m2(10);
       
       int result = fc.m3();  //return이 있는 함수이므로 변수로 값을 받아줌
       System.out.println(result); //100. m3의 리턴값이 출력
       
       result = fc.m4(100);
       System.out.println(result);
       
//       fc.subSum(); 호출 불가 접근자가 default 이므로
       
       fc.CallSubSum();//호출 가능
           
       System.out.println(fc.opSum(-1));
       
       NoteBook nb = new NoteBook();
       nb.color="red";
       nb.setYear(-2000);
       int rs = nb.getYear();
       System.out.println(rs);       //음수를 넣었으므로 get set에 의해 1999 리턴
   
       nb.setYear(2020);
       rs=nb.getYear();
       System.out.println(rs);    // 양수이므로 그대로 2020 출력
               
       
       
       
       
       
       
       
       
       
       
       
       
       
    
    }
   
}
