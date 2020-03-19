import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//https://cafe.naver.com/opensourceweb/441 참고

public class Ex10_Format_Date {
	public static void main(String[] args) throws ParseException  {
		Date curdate = new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println("Date : " + curdate); //format화 되서 출력
		System.out.println("cal : " + cal);  //문자열 그대로 출력
		System.out.println("cal getTime()" + cal.getTime()); //format화 되어 출력
		
	
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmm");
		System.out.println(dateformat.format(curdate));
		System.out.println(dateformat.format(cal.getTime()));
		
		SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy년MM월dd일HH시mm분");
		System.out.println(dateformat2.format(curdate));
		System.out.println(dateformat2.format(cal.getTime()));
		
		String StringDate = "202012121212";
		
		Date stringdate =  dateformat.parse(StringDate);      //문자열 변수로 받은 날짜입력을 포맷팅하는 방법
		System.out.println("StringDate : " + StringDate);
		System.out.println("stringdate : " + stringdate);
		
//		long datelong = stringdate.getTime();
//		System.out.println(datelong);   //11번 파일로 넘어간듯
		

	}

}







