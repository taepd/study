import java.util.Calendar;
import java.util.Date;

import kr.or.bit.utils.Edu_Date;

/*
* Calendar 를 상속받아 완전히 구현한 클래스는 
 * GregorianCalendar
   buddhisCalendar 있는데 getInstance()는 [시스템의 국가와 지역설정]을 [확인]해서
      태국인 경우 buddhisCalendar 의 인스턴스를 반환하고 그 외에는 GregorianCalendar
     의 인스턴스를 반환한다
   GregorianCalendar 는 Calendar를 상속받아 오늘날 전세계 공통으로 사용하고 있는 
   그레고리력에 맞게 구현한 것으로 태국을 제외한 나머지 국가에서는 GregorianCalendar 사용
   그래서 인스턴스를 직접 생성해서 사용하지 않고 메서드를 통해서 인스턴스를 반환받게하는
   이유는 최소의 변경으로 프로그램 동작을 하도록 하기 위함
   class MyApp{
     static void main(){
      Calendar cal = new GregorianCalendar();
      다른 종류의 역법의 사용하는 국가에서 실행하면 변경......    }  }
   class MyApp{
     static void main(){
      Calendar cal = new getInstance();
        다른 종류의 역법의 사용하는 국가에서 실행하면 변경......   }  }
  API : 생성자 Protected Calendar() 
 */
//Java API
//날짜 : Date (구) -> Calendar(신)
public class Ex09_Calendar {

	public static void main(String[] args) {
	    //구버전
	    Date dt = new Date();
	    System.out.println(dt.toString());
	    
	    //신버전
	    Calendar cal = Calendar.getInstance(); //getInstance의 리턴값이 Calendar이므로 이렇게 씀
	    System.out.println(cal);
	    
	    //당신이 필요한 형식을 추출해서 조합해서 사용
	    
	    System.out.println("년도: "+cal.get(Calendar.YEAR));  //년도 추출
	    System.out.println("월: "+(cal.get(Calendar.MONTH)+1)); //달 출력. 0부터 시작하므로 +1해줘야 함
	    System.out.println("일: "+cal.get(Calendar.DATE));
	    System.out.println("이 달의 몇째 주: "+cal.get(Calendar.WEEK_OF_MONTH));
	    System.out.println("이 주의 몇째 날: "+cal.get(Calendar.DAY_OF_WEEK));  //일요일부터 시작함
	    
	    
	    //시, 분, 초
	    System.out.println("시: "+cal.get(Calendar.HOUR));
	    System.out.println("분: "+cal.get(Calendar.MINUTE));
	    System.out.println("초: "+cal.get(Calendar.SECOND));
	    
	    //오전, 오후
	    System.out.println("오전/오후: "+cal.get(Calendar.AM_PM));  //오전 0, 오후:1 인듯
	    
        /*
         * 학사관리 시스템
         * 본수 200Page > 150Page 날짜가 들어감
         * 만일 페이지마다 코드를 넣는다면
         * 1page >> 2020-03-19
         * 2page >> 2020-03-19
         * 요구사항: 2020년 3월 19일로 수정 >>150번 해야함-_-
         * 해결책: 한 번 수정 >> 150개의 page 날짜 변경
         * 날짜 관련된 클래스 >> 메서드 
         * class EduDate { static String todate(){...날짜 생성 리턴}}
        */
	    
	    String date = Edu_Date.DateString(Calendar.getInstance());
	    System.out.println(date);
	    
	    String date2 = Edu_Date.DateString(Calendar.getInstance(),"/");
        System.out.println(date2);
        
        String date3 = Edu_Date.monthFormat_DateString(Calendar.getInstance(), "-");
        System.out.println(date3);
	    

	}

}
