package java_study_ex;

import java.util.Scanner;

public class Ex4_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== 구구단 출력 프로그램 ===");
		System.out.println("시작 단수를 입력하시오");
		int a = sc.nextInt();
		System.out.println("끝 단수를 입력하시오");
		int b = sc.nextInt();
		int n;
		for(n = a; n<=b;n++) {
			System.out.printf("*** %d단 ***\n",n);
			for(int i=1;i<10;i++) {
				System.out.printf("%d * %d = %d\n",n,i,(n*i));
				
			}System.out.println("");
		}
		
	}

}
