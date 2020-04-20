package java_study_ex;
import java.util.Scanner;
public class Ex2_4 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);		
	System.out.println("==== 湲덉븸�쓣 �닾�엯�븯�떆�삤 ====");
	int a = sc.nextInt();
	System.out.println("============");
	System.out.println("1. 肄쒕씪 : 600�썝");
	System.out.println("2. �궗�씠�떎 : 400�썝");
	System.out.println("3. �솚�� : 900�썝");
	System.out.println("============");
	System.out.println("�쓬猷뚯닔瑜� �꽑�깮�븯�떆�삤(1/2/3)");
	
	int c = sc.nextInt();
	int p =0;
	String s="";
	switch (c) {
	case(1):
		p = 600;
		s = "肄쒕씪";
		break;
	case(2):
		p = 400;
		s = "�궗�씠�떎";
		break;
	case(3):
		p= 900;
	    s = "�솚��";
	break;
	}

    if(a>p){
		System.out.printf("二쇰Ц�븯�떊 �쓬猷뚯닔�뒗 %s�엯�땲�떎.\n", s);
		System.out.println("�옍�룉"+ (a-p)+ "�썝�씠 �굹�솕�뒿�땲�떎");
	}else{
		System.out.println((p-a)+"�썝�씠 遺�議깊빀�땲�떎...");
		System.out.println("�닾�엯湲덉븸 "+a+"�썝�씠 �굹�솕�뒿�땲�떎");
	}


           
	}
}
