package java_study_ex;
import java.util.Scanner;
public class Ex2_2 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);		
	System.out.println("==== 금액을 투입하시오 ====");
	int a = sc.nextInt();
	System.out.println("============");
	System.out.println("1. 콜라 : 600원");
	System.out.println("2. 사이다 : 400원");
	System.out.println("3. 환타 : 900원");
	System.out.println("============");
	System.out.println("음료수를 선택하시오(1/2/3)");
	
	int c = sc.nextInt();
	int p =0;
	String s="";
	switch (c) {
	case(1):
		p = 600;
		s = "콜라";
		break;
	case(2):
		p = 400;
		s = "사이다";
		break;
	case(3):
		p= 900;
	    s = "환타";
	break;
	}

    if(a>p){
		System.out.printf("주문하신 음료수는 %s입니다.\n", s);
		System.out.println("잔돈"+ (a-p)+ "원이 나왔습니다");
	}else{
		System.out.println((p-a)+"원이 부족합니다...");
		System.out.println("투입금액 "+a+"원이 나왔습니다");
	}


           
	}
}

}