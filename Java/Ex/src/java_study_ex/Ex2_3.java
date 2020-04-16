package java_study_ex;
import java.util.Scanner;
public class Ex2_3 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);		
	System.out.println("=== 숫자 입력 ===");
	int a = sc.nextInt();
	if(a== (a/2)*2){
		System.out.printf("입력한 숫자 %d는 %s입니다.", a,"짝수");
	}else{
		System.out.printf("입력한 숫자 %d는 %s입니다.", a,"홀수");
	}


           
	}

}
